package com.atyeti.service;

import com.atyeti.exception.NoFileFoundException;
import com.atyeti.model.Expense;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

import static com.atyeti.util.ExpenseUtils.FILE_PATH;

public class ExpenseService implements IExpenseService {

    @Override
    public List<Expense> readDirectory() {
        File folder = new File(FILE_PATH);

        // Get only CSV files
        File[] files = folder.listFiles((dir, name) -> name.endsWith(".csv"));

        // Throw error if no files found
        if (files == null || files.length == 0) {
            throw new NoFileFoundException("No CSV files found in directory.");
        }

        // Create thread pool for parallel file reading
        ExecutorService executor = Executors.newFixedThreadPool(
                Math.min(files.length, Runtime.getRuntime().availableProcessors())
        );

        List<Future<List<Expense>>> futures = new ArrayList<>();

        // Submit one task per file
        for (File file : files) {
            futures.add(executor.submit(() -> readFile(file.getAbsolutePath())));
        }

        List<Expense> allExpenses = new ArrayList<>();

        // Collect results from all threads
        for (Future<List<Expense>> future : futures) {
            try {
                allExpenses.addAll(future.get());
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt(); // restore interrupt flag
                throw new RuntimeException("Thread interrupted while reading files", e);
            } catch (ExecutionException e) {
                throw new RuntimeException("Error while processing file", e);
            }
        }

        // Stop executor service
        executor.shutdown();

        return allExpenses;
    }

    @Override
    public List<Expense> readFile(String path) {
        List<Expense> listOfExpense = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line;
            boolean isFirstLine = true;

            while ((line = reader.readLine()) != null) {

                // Skip header row
                if (isFirstLine) {
                    isFirstLine = false;
                    if (line.toLowerCase().startsWith("amount")) {
                        continue;
                    }
                }

                // Split CSV line into columns
                String[] data = line.split(",", -1);

                // Skip invalid rows
                if (data.length < 4) {
                    continue;
                }

                try {
                    // Create expense object from CSV data
                    Expense expense = new Expense();
                    expense.setAmount((int) Double.parseDouble(data[0].trim()));
                    expense.setDescription(data[1].trim());
                    expense.setDate(LocalDate.parse(data[2].trim()));
                    expense.setCategory(data[3].trim());

                    listOfExpense.add(expense);

                } catch (Exception ex) {
                    // Skip bad row but continue file reading
                    System.err.println("Error parsing line: " + line + " -> " + ex.getMessage());
                }
            }

        } catch (IOException e) {
            throw new NoFileFoundException("Error reading file: " + path);
        }

        return listOfExpense;
    }
}