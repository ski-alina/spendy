package com.example.spendy.models;

import java.util.Date;
import java.util.List;

public class TransactionGroup {
    public Date date;
    private int dayOfMonth;
    private String dayOfWeek;
    private String monthYear;
    private double total;
    public List<Transaction> transactions;
    public double dayTotal;

    public TransactionGroup(Date date, List<Transaction> transactions) {
            this.date = date;
            this.transactions = transactions;
            this.dayTotal = transactions.stream()
                    .mapToDouble(Transaction::getAmount)
                    .sum();
        }

    public TransactionGroup(Date date, int dayOfMonth, String dayOfWeek, String monthYear, double total, List<Transaction> transactions) {
        this.date = date;
        this.dayOfMonth = dayOfMonth;
        this.dayOfWeek = dayOfWeek;
        this.monthYear = monthYear;
        this.total = total;
        this.transactions = transactions;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
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

    public double getDayTotal() {
        return dayTotal;
    }

    public void setDayTotal(double dayTotal) {
        this.dayTotal = dayTotal;
    }
}
