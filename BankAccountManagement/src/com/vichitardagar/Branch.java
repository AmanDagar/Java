package com.vichitardagar;

import java.util.ArrayList;

public class Branch {       //our Branch class that will contain multiple customers

    private String name;       //to store name of branch
    private ArrayList<Customer> customers;  //to store a list of customers that belong to the branch

    public Branch(String name) {    //constructor for our Branch class
        this.name = name;
        this.customers = new ArrayList<>();
    }

    public String getName() {   //getter for Branch name
        return name;
    }

    public boolean removeCustomer(int customerId){      //to remove customers from a branch
        if(findCustomer(customerId)!=null){
            customers.remove(findCustomer(customerId));
            System.out.println("Customer removed");
            System.out.println("\n*********************************************\n");
            return true;
        }
        System.out.println("Customer not found");
        System.out.println("\n*********************************************\n");
        return false;
    }

    public ArrayList<Customer> getCustomers() {     //getter for the list of customers belonging to the branch
        return this.customers;
    }

    public boolean newCustomer(String customerName, double initialAmount) {     //to add new customer to the branch
            this.customers.add(new Customer(customerName, initialAmount));
            return true;

    }

    public boolean addCustomerTransaction(int customerId, double amount) {      //to add a transaction to a customer's account
        Customer existingCustomer = findCustomer(customerId-1);
        if(existingCustomer != null) {
            existingCustomer.addTransaction(amount);
            return true;
        }
        System.out.println("Customer not found");
        System.out.println("\n*********************************************\n");
        return false;
    }

    protected ArrayList<Customer> findCustomer(String customerName) {       //to find customers by their name in case their ID isn't known. This will return list of all customers with same name.
        ArrayList customerList = new ArrayList<>();
        for(int i=0; i<this.customers.size(); i++) {
            Customer checkedCustomer = this.customers.get(i);
            if(checkedCustomer.getName().equalsIgnoreCase(customerName)) {
                customerList.add(checkedCustomer);
            }
        }
        return customerList;
    }

    protected Customer findCustomer(int index){     //to fetch a customer by customer ID
                Customer c = this.customers.get(index);
        if (c != null) {
            return c;
        }else{
            System.out.println("Customer not found");
            return null;
        }
    }
}
