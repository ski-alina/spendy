package com.example.spendy.models;

import java.io.Serializable;

public class Transaction implements Serializable {
    private String id;
    private String title;
    private double amount;
    private String category;
    private long date;
    private String type;
    private String accountType;

    public Transaction(String id, String title, double amount, String category, long date, String type, String accountType) {
        this.id = id;
        this.title = title;
        this.amount = amount;
        this.category = category;
        this.date = date;
        this.type = type;
        this.accountType = accountType;
    }
    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public double getAmount() {
        return amount;
    }

    public String getCategory() {
        return category;
    }

    public long getDate() {
        return date;
    }

    public String getType() {
        return type;
    }

    public String getAccountType() {
        return accountType;
    }
}

