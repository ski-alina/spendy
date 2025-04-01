package com.example.spendy.models;

import java.io.Serializable;
import java.util.Date;

public class Transaction implements Serializable {
    private String id;
    private String comment;
    private double amount;
    private String category;
    private long date;
    private String type;
    private String accountType;

    public Transaction(String id, String comment, double amount, String category, long date, String type, String accountType) {
        this.id = id;
        this.comment = comment;
        this.amount = amount;
        this.category = category;
        this.date = date;
        this.type = type;
        this.accountType = accountType;
    }

    public Transaction(String id, String cash, double amount, Date time) {
    }

    public String getId() {
        return id;
    }

    public String getComment() {
        return comment;
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

