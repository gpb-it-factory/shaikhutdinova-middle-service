package com.middleservice.domain;

import java.util.Objects;

public class Account {

    private final long userId;
    private final String accountName;
    private double balance;

    public Account(long userId, String accountName, double balance) {
        this.userId = userId;
        this.accountName = accountName;
        this.balance = balance;
    }

    public long getUserId() {
        return userId;
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
        return userId == account.userId && Double.compare(balance, account.balance) == 0 && Objects.equals(accountName, account.accountName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, accountName, balance);
    }

    @Override
    public String toString() {
        return "Account{" +
                "userId=" + userId +
                ", accountName='" + accountName + '\'' +
                ", balance=" + balance +
                '}';
    }
}
