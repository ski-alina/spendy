package com.example.spendy.adapters;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.spendy.R;
import com.example.spendy.models.Transaction;
import com.example.spendy.models.TransactionGroup;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class TransactionAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final int TYPE_DATE_HEADER = 0;
    private static final int TYPE_TRANSACTION = 1;

    private List<Object> items = new ArrayList<>(); // Содержит смесь DateHeader и Transaction

    public void setTransactionGroups(List<TransactionGroup> groups) {
        items.clear();
        for (TransactionGroup group : groups) {
            // Добавляем заголовок с датой и суммой за день
            items.add(group);
            // Добавляем транзакции
            items.addAll(group.transactions);
        }
        notifyDataSetChanged();
    }

    @Override
    public int getItemViewType(int position) {
        return items.get(position) instanceof TransactionGroup ? TYPE_DATE_HEADER : TYPE_TRANSACTION;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == TYPE_DATE_HEADER) {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_date_header, parent, false);
            return new DateHeaderViewHolder(view);
        } else {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_transaction, parent, false);
            return new TransactionViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof DateHeaderViewHolder) {
            TransactionGroup group = (TransactionGroup) items.get(position);
            DateHeaderViewHolder dateHolder = (DateHeaderViewHolder) holder;

            SimpleDateFormat dateFormat = new SimpleDateFormat("EEEE\ndd MMMM yyyy", Locale.getDefault());
            dateHolder.dateText.setText(dateFormat.format(group.date));
            dateHolder.totalText.setText(String.format("%+.1f ₪", group.dayTotal));
            dateHolder.totalText.setTextColor(group.dayTotal >= 0 ?
                    Color.parseColor("#4CAF50") : Color.parseColor("#F44336"));

        } else {
            Transaction transaction = (Transaction) items.get(position);
            TransactionViewHolder transactionHolder = (TransactionViewHolder) holder;

            transactionHolder.titleText.setText(transaction.getComment());
            transactionHolder.categoryText.setText(transaction.getCategory());
            transactionHolder.amountText.setText(String.format("%.1f ₪", transaction.getAmount()));
            transactionHolder.amountText.setTextColor(transaction.getAmount() >= 0 ?
                    Color.parseColor("#4CAF50") : Color.parseColor("#F44336"));


            // TODO: Установка иконки категории
        }
        /*private int getCategoryIcon(String categoryText) {
            // Возвращает id ресурса в зависимости от категории
            switch (category.toLowerCase()) {
                case "накопления":
                    return R.drawable.ic_health;
              /*  case "личные":
                 //   return R.drawable.ic_personal;
                 Добавьте остальные категории
                default:
                    return R.drawable.ic_default_category;
            }
            return 0;
            categoryIcon.setImageResource(getCategoryIcon(transaction.getCategory()));
         */
    }


    @Override
    public int getItemCount() {
        return items.size();
    }

    class DateHeaderViewHolder extends RecyclerView.ViewHolder {
        TextView dateText;
        TextView totalText;

        DateHeaderViewHolder(View itemView) {
            super(itemView);
            dateText = itemView.findViewById(R.id.dateText);
            totalText = itemView.findViewById(R.id.dayTotalText);
        }
    }

    class TransactionViewHolder extends RecyclerView.ViewHolder {
        ImageView categoryIcon;
        TextView titleText;
        TextView categoryText;
        TextView amountText;

        TransactionViewHolder(View itemView) {
            super(itemView);
            categoryIcon = itemView.findViewById(R.id.categoryIcon);
            titleText = itemView.findViewById(R.id.transactionTitle);
            categoryText = itemView.findViewById(R.id.transactionCategory);
            amountText = itemView.findViewById(R.id.transactionAmount);
        }
    }
}






