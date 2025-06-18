//package com.atyeti.controller;
//
//import java.util.Scanner;
//import java.util.logging.Logger;
//
//public class BankingApp {
//    private static final Logger logger = LoggerUtility.getLogger();
//    private static final Scanner scanner = new Scanner(System.in);
//    private static final AccountService accountService = new AccountService();
//
//    public static void main(String[] args) {
//        logger.info("Banking Application Started");
//
//        boolean exit = false;
//        while (!exit) {
//            System.out.println("\n===== Mini Banking System =====");
//            System.out.println("1. Create Account");
//            System.out.println("2. Deposit");
//            System.out.println("3. Withdraw");
//            System.out.println("4. View Account Details");
//            System.out.println("5. Exit");
//            System.out.print("Enter choice: ");
//
//            int choice = scanner.nextInt();
//
//            switch (choice) {
//                case 1 -> accountService.createAccount();
//                case 2 -> accountService.deposit();
//                case 3 -> accountService.withdraw();
//                case 4 -> accountService.viewAccount();
//                case 5 -> {
//                    logger.info("Banking Application Exiting");
//                    exit = true;
//                }
//                default -> System.out.println("Invalid choice.");
//            }
//        }
//
//        scanner.close();
//    }
//}
