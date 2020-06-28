package com.vichitardagar;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {    //main function
        Bank bank = new Bank("A");      //initialise a new Bank Object
        System.out.println("Welcome to Bank " + bank.getName());
        System.out.println("*********************************************");
        System.out.println("\n");
        boolean quit = true;
        while (quit) {      //this'll execute the code until the user wants to quit. All the choices available are mentioned using print statements
            System.out.println("\n*********************************************\n");
            System.out.println("Please Enter Input As Followed : " +
                    "\n" + "0:Quit" +
                    "\n" + "1:See List of Branches available" +
                    "\n" + "2:Add a new Branch" +
                    "\n" + "3:Add a customer to a branch" +
                    "\n" + "4:Add transaction for a customer" +
                    "\n" + "5:Remove a Branch" +
                    "\n" + "6:Remove a customer from a branch" +
                    "\n" + "7:Find a customer" +
                    "\n" + "8:List customers of a branch" +
                    "\n" + "9:Reprint Choices");
            Scanner scanner = new Scanner(System.in);
            int n = scanner.nextInt();
            scanner.nextLine();
            switch (n) {
                case 0:
                    quit = false;
                    break;
                case 1:
                    bank.listBranches();
                    System.out.println("\n*********************************************\n");
                    continue;
                case 2:
                    System.out.println("Please enter branch name");
                    String name = scanner.nextLine();
                    if (bank.addBranch(name)) {
                        System.out.println("Branch added");
                    } else {
                        System.out.println("Branch already exists");
                    }
                    System.out.println("\n*********************************************\n");
                    continue;
                case 3:
                    bank.listBranches();
                    System.out.println("Please Enter branch number in which you want to" +
                                       " add customer(Enter 0 if you want to go back):");
                    int a = scanner.nextInt();
                    scanner.nextLine();
                    if (a == 0) {
                        System.out.println("\n*********************************************\n");
                        continue;
                    } else if (a > 0 && a <= bank.getBranches().size()) {
                        System.out.println("Please Enter Customer name");
                        String cName = scanner.nextLine();
                        System.out.println("Please Enter Initial amount");
                        double transaction = scanner.nextDouble();
                        scanner.nextLine();
                        bank.addCustomer(bank.getBranches().get(a - 1).getName(), cName, transaction);
                        System.out.println("Customer added successfully");
                        System.out.println("\n*********************************************\n");
                        continue;
                    } else {
                        System.out.println("Invalid Branch");
                        System.out.println("\n*********************************************\n");
                        continue;
                    }
                case 4:
                    bank.listBranches();
                    System.out.println("Please Enter branch number from which you want to add " +
                                       "customer's transaction(Enter 0 if you want to go back):");
                    a = scanner.nextInt();
                    scanner.nextLine();
                    if (a == 0) {
                        System.out.println("\n*********************************************\n");
                        continue;
                    } else if (a > 0 && a <= bank.getBranches().size()) {
                        System.out.println("Please Enter Customer Id");
                        int custId = scanner.nextInt();
                        scanner.nextLine();
                        System.out.println("Please Enter: " + "\n" +
                                           "0: for withdraw" + "\n" + "1: for deposit");
                        int opt = scanner.nextInt();
                        scanner.nextLine();
                        System.out.println("Please Enter amount");
                        double transaction = scanner.nextDouble();
                        scanner.nextLine();
                        if (opt == 0) {
                            transaction = -transaction;
                        }
                        if(bank.addCustomerTransaction(bank.getBranches().get(a - 1).getName(), custId, transaction)){
                            System.out.println("Transaction successful");
                        } else {
                            System.out.println("Transaction failed");
                        }
                        System.out.println("\n*********************************************\n");
                        continue;
                    } else {
                        System.out.println("Invalid Branch");
                        System.out.println("\n*********************************************\n");
                        continue;
                    }
                case 5:
                    bank.listBranches();
                    System.out.println("Please enter the branch number for " +
                                       "the branch to be removed(Enter 0 to go back)");
                    a = scanner.nextInt();
                    scanner.nextLine();
                    bank.removeBranch(bank.getBranches().get(a - 1).getName());
                    System.out.println("\n*********************************************\n");
                    continue;
                case 6:
                    bank.listBranches();
                    System.out.println("Please Enter branch number from which you want to " +
                                       "remove a customer(Enter 0 if you want to go back):");
                    a = scanner.nextInt();
                    scanner.nextLine();
                    if (a == 0) {
                        System.out.println("\n*********************************************\n");
                        continue;
                    } else if (a > 0 && a <= bank.getBranches().size()) {
                        System.out.println("Please Enter Customer Id");
                        int custId = scanner.nextInt();
                        scanner.nextLine();
                        if (bank.removeCustomer(bank.getBranches().get(a - 1).getName(), custId)) {
                            System.out.println("Remove successful");
                        } else {
                            System.out.println("Remove failed");
                        }
                        System.out.println("\n*********************************************\n");
                        continue;
                    } else {
                        System.out.println("Invalid Branch");
                        System.out.println("\n*********************************************\n");
                        continue;
                    }
                case 7:
                    bank.listBranches();
                    System.out.println("Please Enter branch number from which you want to " +
                                       "find customer(Enter 0 if you want to go back):");
                    a = scanner.nextInt();
                    scanner.nextLine();
                    if (a == 0) {
                        System.out.println("\n*********************************************\n");
                        continue;
                    } else if (a > 0 && a <= bank.getBranches().size()) {
                        System.out.println("Please Enter 0 to search customers " +
                                           "with same name , 1 to search with customer ID");
                        int opt = scanner.nextInt();
                        scanner.nextLine();
                        if (opt == 0) {
                            System.out.println("Enter Customer name:");
                            String cName = scanner.nextLine();
                            bank.getCustomerByName(cName, --a);
                        } else if (opt == 1) {
                            System.out.println("Enter Customer Id");
                            int cId = scanner.nextInt();
                            scanner.nextLine();
                            bank.getCustomerById(cId, --a);
                        } else {
                            System.out.println("Invalid Input");
                        }
                        System.out.println("\n*********************************************\n");
                        continue;
                    } else {
                        System.out.println("Invalid Branch");
                        System.out.println("\n*********************************************\n");
                        continue;
                    }
                case 8:
                    bank.listBranches();
                    System.out.println("Please Enter branch number from which you want to " +
                                       "see customers(Enter 0 if you want to go back):");
                    a = scanner.nextInt();
                    scanner.nextLine();
                    if (a == 0) {
                        System.out.println("\n*********************************************\n");
                        continue;
                    } else if (a > 0 && a <= bank.getBranches().size()) {
                        boolean showTransactions;
                        System.out.println("Please enter input if you want to see " +
                                           "transactions \n 0: for yes \n 1: for no");
                        int opt = scanner.nextInt();
                        scanner.nextLine();
                        if (opt == 0) {
                            showTransactions = true;
                        } else if (opt == 1) {
                            showTransactions = false;
                        } else {
                            System.out.println("Invalid Input");
                            System.out.println("\n*********************************************\n");
                            continue;
                        }
                        bank.listCustomers(bank.getBranches().get(a - 1).getName(), showTransactions);
                        System.out.println("\n*********************************************\n");
                        continue;
                    } else {
                        System.out.println("Invalid Branch");
                        System.out.println("\n*********************************************\n");
                        continue;
                    }
                case 9:
                    System.out.println("\n*********************************************\n");
                    continue;
            }
        }
    }
}