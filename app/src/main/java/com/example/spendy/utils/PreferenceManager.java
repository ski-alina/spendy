package com.example.spendy.utils;

import android.content.Context;
import android.content.SharedPreferences;

public class PreferenceManager {
    private static final String PREF_NAME = "finance_preferences";
    private static final String KEY_CURRENCY = "currency";
    private static final String KEY_LANGUAGE = "language";
    private static final String KEY_THEME = "theme";

    private final SharedPreferences preferences;

    public PreferenceManager(Context context) {
        preferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
    }

    public void setCurrency(String currency) {
        preferences.edit().putString(KEY_CURRENCY, currency).apply();
    }

    public String getCurrency() {
        return preferences.getString(KEY_CURRENCY, "USD");
    }

    public void setLanguage(String language) {
        preferences.edit().putString(KEY_LANGUAGE, language).apply();
    }

    public String getLanguage() {
        return preferences.getString(KEY_LANGUAGE, "en");
    }

    public void setTheme(String theme) {
        preferences.edit().putString(KEY_THEME, theme).apply();
    }

    public String getTheme() {
        return preferences.getString(KEY_THEME, "light");
    }
}