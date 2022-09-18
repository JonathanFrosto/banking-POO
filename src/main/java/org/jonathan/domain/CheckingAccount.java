package org.jonathan.domain;

class CheckingAccount extends Account {

    public CheckingAccount(int agency, int number, Client client) {
        super(agency, number, client);
    }

    @Override
    protected String getAccountType() {
        return "checking account";
    }

}
