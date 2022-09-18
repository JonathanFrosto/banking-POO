package org.jonathan.domain;

class SavingsAccount extends Account {

    public SavingsAccount(int agency, int number, Client client) {
        super(agency, number, client);
    }

    @Override
    protected String getAccountType() {
        return "savings account";
    }
}
