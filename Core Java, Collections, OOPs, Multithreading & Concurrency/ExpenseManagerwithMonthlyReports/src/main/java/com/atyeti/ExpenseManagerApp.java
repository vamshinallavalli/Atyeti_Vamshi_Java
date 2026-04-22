package com.atyeti;

import com.atyeti.model.Expense;
import com.atyeti.service.ExpenseService;
import com.atyeti.service.IExpenseService;
import com.atyeti.service.IReportService;
import com.atyeti.service.ReportService;

import java.time.YearMonth;
import java.util.List;

import static com.atyeti.util.ExpenseUtils.FILE_PATH;

public class ExpenseManagerApp {

    private final IExpenseService expenseService;
    private final IReportService reportService;

    // Constructor injection for loose coupling
    public ExpenseManagerApp(IExpenseService expenseService, IReportService reportService) {
        this.expenseService = expenseService;
        this.reportService = reportService;
    }

    public void run() {
        try {
            // Read single CSV file
            List<Expense> allExpenses = expenseService.readFile(FILE_PATH);

            // Select month for report
            YearMonth selectedMonth = YearMonth.of(2025, 7);

            // Generate report
            reportService.generateMonthlyReport(allExpenses, selectedMonth);

        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        // Create service objects
        IExpenseService expenseService = new ExpenseService();
        IReportService reportService = new ReportService();

        // Start application
        ExpenseManagerApp app = new ExpenseManagerApp(expenseService, reportService);
        app.run();
    }
}