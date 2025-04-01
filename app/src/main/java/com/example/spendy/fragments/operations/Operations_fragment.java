package com.example.spendy.fragments.operations;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.spendy.R;
import com.example.spendy.adapters.TransactionAdapter;
import com.example.spendy.models.Transaction;
import com.example.spendy.models.TransactionGroup;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;

public class Operations_fragment extends Fragment {
    private RecyclerView recyclerView;
    private TransactionAdapter adapter;
    private TextView monthYearText;
    private Calendar currentMonth;
    private ImageButton prevMonthButton;
    private ImageButton nextMonthButton;
    private FloatingActionButton addButton;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_operations, container, false);
        // Инициализация views
        recyclerView = view.findViewById(R.id.transactions_recycler);
        addButton = view.findViewById(R.id.add_button);
        monthYearText = view.findViewById(R.id.monthYearText);
        prevMonthButton = view.findViewById(R.id.prev_month);
        nextMonthButton = view.findViewById(R.id.next_month);

        // Настройка RecyclerView
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new TransactionAdapter();
        recyclerView.setAdapter(adapter);

        // Инициализация календаря
        currentMonth = Calendar.getInstance();
        updateMonthYearText();

        // Обработка кнопок переключения месяца
        prevMonthButton.setOnClickListener(v -> {
            currentMonth.add(Calendar.MONTH, -1);
            updateMonthYearText();
            loadTransactionsForMonth();
        });

        nextMonthButton.setOnClickListener(v -> {
            currentMonth.add(Calendar.MONTH, 1);
            updateMonthYearText();
            loadTransactionsForMonth();
        });

        addButton.setOnClickListener(v -> {
            // TODO: Открыть диалог добавления транзакции
        });
        // Загрузка начальных данных
        loadTransactionsForMonth();

        return view;
    }
    private void updateMonthYearText() {
        SimpleDateFormat sdf = new SimpleDateFormat("MMMM yyyy", Locale.getDefault());
        monthYearText.setText(sdf.format(currentMonth.getTime()));
    }
    private void loadTransactionsForMonth() {
        // TODO: Загрузить транзакции из базы данных или другого источника данных
        List<TransactionGroup> groups = getTransactionsForMonth(currentMonth);
        adapter.setTransactionGroups(groups);
        updateBalance();
    }

    private void updateBalance() {

    }

    private List<TransactionGroup> getTransactionsForMonth(Calendar month) {
        // Создаем копии дат начала и конца месяца
        Calendar startOfMonth = (Calendar) month.clone();
        startOfMonth.set(Calendar.DAY_OF_MONTH, 1);
        startOfMonth.set(Calendar.HOUR_OF_DAY, 0);
        startOfMonth.set(Calendar.MINUTE, 0);
        startOfMonth.set(Calendar.SECOND, 0);

        Calendar endOfMonth = (Calendar) month.clone();
        endOfMonth.set(Calendar.DAY_OF_MONTH, endOfMonth.getActualMaximum(Calendar.DAY_OF_MONTH));
        endOfMonth.set(Calendar.HOUR_OF_DAY, 23);
        endOfMonth.set(Calendar.MINUTE, 59);
        endOfMonth.set(Calendar.SECOND, 59);

        // TODO: Здесь должен быть ваш код для получения транзакций из базы данных
        // Примерно так:
        // return databaseHelper.getTransactionsBetweenDates(startOfMonth.getTime(), endOfMonth.getTime());

        // Временный код для примера:
        List<TransactionGroup> groups = new ArrayList<>();
        Map<Date, List<Transaction>> transactionsByDate = new TreeMap<>();

        // Пример данных
        Calendar current = (Calendar) startOfMonth.clone();
        while (!current.after(endOfMonth)) {
            if (Math.random() > 0.5) { // Случайные дни для примера
                List<Transaction> dayTransactions = new ArrayList<>();
                dayTransactions.add(new Transaction(
                        "Подработка",
                        "Cash",
                        Math.random() * 200,
                        current.getTime()
                ));

                if (Math.random() > 0.7) {
                    dayTransactions.add(new Transaction(
                            "Personal",
                            "Cash",
                            -Math.random() * 50,
                            current.getTime()
                    ));
                }

                transactionsByDate.put(current.getTime(), dayTransactions);
            }
            current.add(Calendar.DAY_OF_MONTH, 1);
        }

        // Группируем транзакции по датам
        for (Map.Entry<Date, List<Transaction>> entry : transactionsByDate.entrySet()) {
            groups.add(new TransactionGroup(entry.getKey(), entry.getValue()));
        }

        return groups;
    }

    private double calculateBalance() {
        // TODO: Здесь должен быть ваш код для получения общего баланса
        // Примерно так:
        // return databaseHelper.getTotalBalance();

        // Временный код для примера:
        double balance = 0;
        List<TransactionGroup> groups = getTransactionsForMonth(currentMonth);
        for (TransactionGroup group : groups) {
            for (Transaction transaction : group.transactions) {
                balance += transaction.getAmount();
            }
        }
        return balance;
    }

    // Вспомогательный метод для форматирования дат
    private String formatDate(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy", Locale.getDefault());
        return sdf.format(date);
    }


}