package com.example.spendy.models;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "users")
public class User {
    @PrimaryKey
    private String id;

    @NonNull
    private String username;

    private String email;

    private String defaultCurrency;

    private String language;

    // Конструкторы, геттеры и сеттеры
}
