package com.example.spendy;


import static com.example.spendy.R.*;

import android.annotation.SuppressLint;
import android.os.Bundle;

import com.example.spendy.fragments.accounts.Accounts_fragment;
import com.example.spendy.fragments.categories.Categories_fragment;
import com.example.spendy.fragments.more.More_fragment;
import com.example.spendy.fragments.operations.Operations_fragment;
import com.example.spendy.fragments.statistics.Statistics_fragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNavigationView = findViewById(R.id.nav_view);

        // Setup bottom navigation
        bottomNavigationView.setOnItemSelectedListener(item -> {
            Fragment selectedFragment = null;

            switch (item.getItemId()) {
                case R.id.nav_accounts:
                    selectedFragment = new Accounts_fragment();
                    break;
                case R.id.nav_categories:
                    selectedFragment = new Categories_fragment();
                    break;
                case R.id.nav_operations:
                    selectedFragment = new Operations_fragment();
                    break;
                case R.id.nav_statistics:
                    selectedFragment = new Statistics_fragment();
                    break;
                case R.id.nav_more:
                    selectedFragment = new More_fragment();
                    break;
            }

            if (selectedFragment != null) {
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.container, selectedFragment)
                        .commit();
            }

            return true;
        });

        // Set default fragment
        if (savedInstanceState == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.container, new Operations_fragment())
                    .commit();
        }
    }
}
