package com.company;

import java.util.Scanner;

public class Main {

    public static String getName()
    {
        Scanner opt = new Scanner(System.in);
        return opt.nextLine().toLowerCase();
    }

    public static void main(String[] args)
    {
        Scanner opt = new Scanner(System.in);

        boolean cont = true;

        System.out.print("What is the banks name: ");
        String  bankName = opt.nextLine();

        Bank nBank = new Bank(bankName);


        while(cont)
        {
            System.out.println("\n1. Add Customer");
            System.out.println("2. View Customers");
            System.out.println("3. Customer Withdraw");
            System.out.println("4. Customer Deposit");
            System.out.println("5. Exit");
            System.out.print("\nWhat would ypu like to do: ");
            int whatDo = opt.nextInt();


            switch (whatDo)
            {
                case 1:
                    System.out.print("\nFirst Name: ");
                    String fName = getName();
                    System.out.print("Last Name: ");
                    String lName =  getName();

                    Customer newCus = new Customer(fName, lName);

                    System.out.print("Please set amount in the deposit: ");
                    double amount = opt.nextDouble();

                    if(amount < 0 )
                    {
                        System.out.println("Invalid amount given");
                    }
                    else
                    {
                        Account newAcc = new Account(amount);
                        newCus.setAccount(newAcc);

                        nBank.addCustomer(newCus.getFirstName(), newCus.getLastName(), newCus.getAccount());
                    }

                    break;


                case 2:
                    System.out.println("Customers: ");
                    for(int i = 0; i<nBank.getNumberOfCustomers(); i++)
                    {
                        Customer curCus = nBank.getCustomer(i);

                        System.out.println(i+1 + ". " + curCus.getFirstName() +" "+ curCus.getLastName());
                    }
                    
                    break;


                case 3:
                    System.out.print("Which customer is withdrawing: ");
                    int curInd = opt.nextInt();
                    if(curInd > nBank.getNumberOfCustomers())
                    {
                        System.out.println("Out of bounds");
                    }
                    else
                    {
                        Customer curCus = nBank.getCustomer(curInd-1);
                        Account curAccount = curCus.getAccount();

                        System.out.println(curCus.getFirstName() + " " + curCus.getLastName());
                        System.out.println(curAccount.getBalance());

                        System.out.print("How much would like to be withdrawn: ");
                        double withdraw = opt.nextDouble();
                        curAccount.withdraw(withdraw);

                    }
                    break;


                case 4:
                    System.out.print("Which customer is depositing");
                    int curIndex = opt.nextInt();
                    if(curIndex > nBank.getNumberOfCustomers())
                    {
                        System.out.println("Out of bounds");
                    }
                    else
                    {
                        Customer curCus = nBank.getCustomer(curIndex-1);
                        Account curAccount = curCus.getAccount();

                        System.out.println(curCus.getFirstName() + " " + curCus.getLastName());
                        System.out.println(curAccount);

                        System.out.print("How much would like to be deposited: ");
                        double deposit = opt.nextDouble();
                        curAccount.withdraw(deposit);

                    }

                case 5:
                    cont = false;
            }
        }

    }
}
