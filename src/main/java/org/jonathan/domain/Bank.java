package org.jonathan.domain;

import lombok.Getter;

import java.util.List;

@Getter
public class Bank {

    private int agency;
    private int accountNumberSequence;
    private List<Account> accounts;

    public Bank(List<Account> accounts, Integer agency) {
        if (accounts == null) throw new IllegalArgumentException("Accounts list can't be null");
        if (agency == null) throw new IllegalArgumentException("Agency can't be null");

        this.accounts = accounts;
        this.agency = agency;
    }

    public Account createAccount(Client client, AccountType accountType) {
        if (client == null) throw new IllegalArgumentException("Client can't be null");
        if (accountType == null) throw new IllegalArgumentException("Account type can't be null");

        if (accountType == AccountType.CHECKING_ACCOUNT) {
            CheckingAccount checkingAccount = new CheckingAccount(agency, accountNumberSequence, client);
            addAccount(checkingAccount);

            return checkingAccount;
        } else if (accountType == AccountType.SAVINGS_ACCOUNT) {
            SavingsAccount savingsAccount = new SavingsAccount(agency, accountNumberSequence, client);
            addAccount(savingsAccount);

            return savingsAccount;
        }

        throw new IllegalArgumentException("Account type not known");
    }
    
    private void addAccount(Account account) {
        accounts.add(account);
        accountNumberSequence++;
    }

}
