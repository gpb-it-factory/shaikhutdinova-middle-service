package com.middleservice.domain;

import java.util.Objects;

public class Account {

    private final long userId;
    private final String accountName;

    public Account(long userId, String accountName) {
        this.userId = userId;
        this.accountName = accountName;
    }

    public long getUserId() {
        return userId;
    }

    public String getAccountName() {
        return accountName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return userId == account.userId && Objects.equals(accountName, account.accountName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, accountName);
    }

    @Override
    public String toString() {
        return "Account{" +
                "userId=" + userId +
                ", accountName='" + accountName + '\'' +
                '}';
    }
}
