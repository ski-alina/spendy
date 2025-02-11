package com.example.spendy.models;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "accounts")
public class Account {
    @PrimaryKey(autoGenerate = true)
    private long id;

    @NonNull
    private String name;

    private double balance;

    private String currency;

    private String type; // "CASH", "CARD", etc.

    // Конструкторы, геттеры и сеттеры
}
