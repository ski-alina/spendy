package com.example.spendy.models;

import java.util.List;

public class TransactionGroup {
    private long date;
    private int dayOfMonth;
    private String dayOfWeek;
    private String monthYear;
    private double total;
    private List<Transaction> transactions;

    public TransactionGroup(long date, int dayOfMonth, String dayOfWeek, String monthYear, double total, List<Transaction> transactions) {
        this.date = date;
        this.dayOfMonth = dayOfMonth;
        this.dayOfWeek = dayOfWeek;
        this.monthYear = monthYear;
        this.total = total;
        this.transactions = transactions;
    }

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

    public int getDayOfMonth() {
        return dayOfMonth;
    }

    public void setDayOfMonth(int dayOfMonth) {
        this.dayOfMonth = dayOfMonth;
    }

    public String getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(String dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public String getMonthYear() {
        return monthYear;
    }

    public void setMonthYear(String monthYear) {
        this.monthYear = monthYear;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }
}
