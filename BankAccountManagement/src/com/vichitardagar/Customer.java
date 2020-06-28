package com.vichitardagar;

import java.util.ArrayList;


public class Customer {     //our basic customer class
    private String name;    //variable to store name of customer
    private ArrayList<Double> transactions; //this list will store all the transactions for a customer
    private final int custId;   //this will assign ID to each customer right when their account is created
    private double balance;     //this will store the account balance
    private static int addId=0;     //this static variable is incremented to assign ID as new customers are added

    public Customer(String name, double initialAmount) {     //constructor for our customer class
        this.name = name;
        addId++;
        this.custId=addId;
        this.transactions = new ArrayList<>();
        balance=initialAmount;
        transactions.add(initialAmount);
    }

    public boolean addTransaction(double amount) {          //adds a transaction for customer
        if ((this.balance+amount)>=0) {
            this.transactions.add(amount);
            balance+=amount;
            return true;
        }else{
            System.out.println("Balance Insufficient");
            return false;
        }
    }

    public double getBalance(){     //getter for account balance
        return this.balance;
    }

    public String getName() {   //getter for customer name
        return name;
    }
    public int getCustId(){   //getter for customer ID
        return this.custId;
    }

    public ArrayList<Double> getTransactions() {    //this will return a list of all the transactions of the customer
        return transactions;
    }
}
