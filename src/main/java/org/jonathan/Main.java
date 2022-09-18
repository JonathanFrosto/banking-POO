package org.jonathan;

import org.jonathan.domain.Account;
import org.jonathan.domain.AccountType;
import org.jonathan.domain.Bank;
import org.jonathan.domain.Client;

import java.util.ArrayList;

public class Main {

    public static final String BARS = "==========================================";

    public static void main(String[] args) {
        Bank bank = new Bank(new ArrayList<>(), 1);

        Client jonathan = new Client("Jonathan");
        Account accountJonathan = bank.createAccount(jonathan, AccountType.CHECKING_ACCOUNT);

        Client vanessa = new Client("Vanessa");
        Account accountVanessa = bank.createAccount(vanessa, AccountType.SAVINGS_ACCOUNT);

        System.out.println(BARS);
        accountJonathan.transfer(100, accountVanessa);
        accountJonathan.extract();
        accountVanessa.extract();
        System.out.println(BARS);

        accountJonathan.deposit(100);
        accountJonathan.extract();
        System.out.println(BARS);

        accountJonathan.transfer(80, accountVanessa);
        accountJonathan.extract();
        accountVanessa.extract();
    }
}