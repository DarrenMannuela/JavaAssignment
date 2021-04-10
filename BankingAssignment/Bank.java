package com.company;

import java.util.ArrayList;

public class Bank {
    private final ArrayList<Customer> customers = new ArrayList<>();
    private int numberOfCustomers = 0;
    private final String bankName;

    public Bank(String bName)
    {
        this.bankName = bName;
    }

    public void addCustomer(String f, String l, Account deposit)
    {
        Customer newCus = new Customer(f, l);
        newCus.setAccount(deposit);
        customers.add(newCus);
        numberOfCustomers++;
    }

    public int getNumberOfCustomers()
    {
        return numberOfCustomers;
    }

    public Customer getCustomer(int index)
    {
        return customers.get(index);
    }


}
