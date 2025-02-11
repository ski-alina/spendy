package com.example.spendy.models;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "categories")
public class Category {
    @PrimaryKey(autoGenerate = true)
    private long id;

    @NonNull
    private String name;

    private String type; // "INCOME" или "EXPENSE"

    private String icon;

    private String color;

    // Конструкторы, геттеры и сеттеры
}
