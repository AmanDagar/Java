package com.vichitardagar;

import java.util.ArrayList;

public class Bank {     //our bank class that is linked with multiple branches

    private String name;        //stores name of Bank
    private  ArrayList<Branch> branches;    //to store list of branches linked to the bank

    public Bank(String name) {      //constructor for our Bank class
        this.name = name;
        this.branches = new ArrayList<>();
    }

    public String getName(){        //getter for Bank name
        return this.name;
    }

    public ArrayList<Branch> getBranches() {       //getter for list of branches
        return this.branches;
    }


    public boolean addBranch(String branchName) {       //to add a branch to the bank
        if (findBranch(branchName) == null) {
            this.branches.add(new Branch(branchName));
            return true;
        }

        return false;
    }

    public boolean removeBranch(String branchName) {    //to remove a branch from a bank
        if (findBranch(branchName) != null) {
            this.branches.remove(findBranch(branchName));
            System.out.println("Branch removed successfully");
            return true;
        }
        System.out.println("Branch not found");
        return false;
    }

    public boolean addCustomer(String branchName, String customerName, double initialAmount) {      //to add a new customer to a branch.
        Branch branch = findBranch(branchName);
        if (branch != null) {
            return branch.newCustomer(customerName, initialAmount);
        }
        System.out.println("Branch not found");
        return false;
    }

    public boolean removeCustomer(String branchName, int customerId) {      //to remove a customer from a branch.
        Branch branch = findBranch(branchName);
        if(branch!=null){
            return branch.removeCustomer((customerId-1));
        }
        System.out.println("Branch not found");
        return false;
    }

    public boolean addCustomerTransaction(String branchName, int customerId, double amount) {   //to add a transaction to a customer belonging to a particular branch.
        Branch branch = findBranch(branchName);
        if (branch != null) {
            return branch.addCustomerTransaction(customerId, amount);
        }

        return false;
    }

    private Branch findBranch(String branchName) {      //to find a branch using branch name
        for (int i = 0; i < this.branches.size(); i++) {
            Branch checkedBranch = this.branches.get(i);
            if (checkedBranch.getName().equalsIgnoreCase(branchName)) {
                return checkedBranch;
            }
        }

        return null;
    }

    public void listBranches() {        //to list all the branches belonging to the bank
        if (this.branches.isEmpty()) {
            System.out.println("No Branches Available");
        } else {
            for (int i = 0; i < this.branches.size(); i++) {
                System.out.println((i + 1) + "-> " + branches.get(i).getName());
            }
        }
    }

    public boolean listCustomers(String branchName, boolean showTransactions) {     //to list all the customers belonging to a branch
        Branch branch = findBranch(branchName);
        if (!branch.getCustomers().isEmpty()) {
            System.out.println("Customer details for branch " + branch.getName());

            ArrayList<Customer> branchCustomers = branch.getCustomers();
            for (int i = 0; i < branchCustomers.size(); i++) {
                Customer branchCustomer = branchCustomers.get(i);
                System.out.println("Customer Id " + branchCustomer.getCustId() +
                                   " name : " + branchCustomer.getName() +
                                   "\n" + " balance is $" + branchCustomer.getBalance());
                if (showTransactions) {
                    System.out.println("Transactions:");
                    ArrayList<Double> transactions = branchCustomer.getTransactions();
                    for (int j = 0; j < transactions.size(); j++) {
                        System.out.println("[" + (j + 1) + "]  Amount " + transactions.get(j));
                    }
                }
            }
            return true;
        } else {
            System.out.println("No record available");
            return false;
        }
    }

    public void getCustomerByName(String customerName, int index) {     //to find customer by name

        ArrayList<Customer> cust = this.branches.get(index).findCustomer(customerName);
        if (!cust.isEmpty()) {
        for (int i = 0; i < cust.size(); i++) {
            printCustomer(cust.get(i));
        }
        }else{
            System.out.println("No such Customer Found");
        }

}

   public void getCustomerById(int customerId,int index){   //to find a customer by customer ID
       Customer cust =this.branches.get(index).findCustomer((customerId-1));
       if(cust!=null){
           printCustomer(cust);
       }else{
           System.out.println("No such Customer Found");
       }
    }

   private void printCustomer(Customer customer){       //to print the details of a customer
       System.out.println("Customer Id " + customer.getCustId() +
                          " name : " + customer.getName()  + "\n" +
                          " balance is $" + customer.getBalance());
   }
}
