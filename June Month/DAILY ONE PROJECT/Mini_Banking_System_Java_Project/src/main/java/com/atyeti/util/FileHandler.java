package com.atyeti.util;

import com.atyeti.model.Account;
import com.atyeti.model.SavingsAccount;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileHandler {
    private static String filepath="C:\\Users\\VamshiNallavalli\\OneDrive - Atyeti Inc\\Desktop\\Atyeti_Vamshi_Java\\June Month\\Projects\\Mini_Banking_System_Java_Project\\src\\main\\resources\\accounts.txt";


    public static List<Account> readAccountsFromFile() {
        List<Account> accounts = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filepath))) {
            String line;

            while((line=reader.readLine())!=null){
                String [] parts=line.split(",");

                if(parts.length==3){
                    String accNo=parts
                            [0];
                    String name=parts[1];
                    double balance=Double.parseDouble(parts[2]);

                    Account account=new SavingsAccount(accNo,name,balance,2.5);
                    accounts.add(account);
                }
            }


        } catch (IOException e) {
            e.printStackTrace();
        }

        return accounts;
    }
    public static void writeAccountToFile(Account account) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filepath, true))) {
            writer.write(account.getAccountNumber() + "," +
                    account.getAccountHolderName() + "," +
                    account.getBalance());
            writer.newLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
