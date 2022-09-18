package org.jonathan.domain;

import org.jonathan.domain.exception.InsufficientFunds;

public abstract class Account {

    private int agency;
    private int number;
    private double balance;
    private Client client;

    public Account(int agency, int number, Client client) {
        this.agency = agency;
        this.number = number;
        this.client = client;
    }

    public void extract() {
        System.out.println("Account owner: " + client.getName());
        System.out.println("Account type: " + getAccountType());
        System.out.println("Account agency: " + agency);
        System.out.println("Account number: " + number);
        System.out.println("Balance: " + balance);
    }

    protected abstract String getAccountType();

    public void transfer(double value, Account account) {
        try {
            withdraw(value);
            account.deposit(value);
        } catch (InsufficientFunds e) {
            System.out.println("Transfer failed because: " + e.getMessage());
        }
    }

    public void deposit(double value) {
        balance += value;
    }

    public void withdraw(double value) throws InsufficientFunds {
        if (value > balance) throw new InsufficientFunds("Insufficient funds");
        balance -= value;
    }

}
