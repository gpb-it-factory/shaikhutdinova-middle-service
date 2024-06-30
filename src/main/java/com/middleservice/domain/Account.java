package com.middleservice.domain;

import java.util.Objects;

public class Account {

    private final long accountId;
    private final String accountName;
    private double balance;

    public Account(long accountId, String accountName, double balance) {
        this.accountId = accountId;
        this.accountName = accountName;
        this.balance = balance;
    }

    public long getAccountId() {
        return accountId;
    }

    public String getAccountName() {
        return accountName;
    }

    public double getBalance() {
        return balance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return accountId == account.accountId && Double.compare(balance, account.balance) == 0 && Objects.equals(accountName, account.accountName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountId, accountName, balance);
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountId=" + accountId +
                ", accountName='" + accountName + '\'' +
                ", balance=" + balance +
                '}';
    }
}
