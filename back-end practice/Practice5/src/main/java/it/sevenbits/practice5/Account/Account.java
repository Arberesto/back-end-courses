package it.sevenbits.practice5.Account;

import java.util.UUID;

public class Account implements Comparable<Account> {
    private String id;
    private long balance;

    public Account(long balance) {
        id = UUID.randomUUID().toString();
        this.balance = balance;
    }

    public int compareTo(Account other) {
        return compareAccounts(this,other);
    }

    private int compareAccounts(Account first, Account second) {
        long firstId = first.balance;
        long secondId = second.balance;
        if (firstId - secondId > 0) return 1;
        if (firstId - secondId < 0) return -1;
        return 0;
    }

    public void addToBalance(long value) throws Exception {
        long balance = this.balance;
        Thread.sleep(1);
        this.balance = balance + value;
    }

    @Override
    public String toString() {
        return String.format("Account id: %s with balance %s \n", id, balance);
    }
}