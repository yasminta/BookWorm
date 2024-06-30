package com.example.bookworm;

import android.app.DatePickerDialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Calendar;
import java.util.List;

public class MyListAdapter extends RecyclerView.Adapter<MyListAdapter.MyListViewHolder> {

    private List<Book> myList;
    private Context context;

    public MyListAdapter(List<Book> myList, Context context) {
        this.myList = myList;
        this.context = context;
    }

    @NonNull
    @Override
    public MyListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.my_list_item, parent, false);
        return new MyListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyListViewHolder holder, int position) {
        Book book = myList.get(position);
        holder.titleTextView.setText(book.getTitle());
        holder.authorTextView.setText(book.getAuthor());
        holder.bookImageView.setImageResource(book.getImageResId());

        holder.returnDateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar calendar = Calendar.getInstance();
                DatePickerDialog datePickerDialog = new DatePickerDialog(context,
                        (view, year, month, dayOfMonth) -> {
                            calendar.set(year, month, dayOfMonth);
                            String returnDate = dayOfMonth + "/" + (month + 1) + "/" + year;
                            holder.returnDateTextView.setText(returnDate);
                            book.setReturnDate(returnDate);
                        },
                        calendar.get(Calendar.YEAR),
                        calendar.get(Calendar.MONTH),
                        calendar.get(Calendar.DAY_OF_MONTH));
                datePickerDialog.show();
            }
        });

        holder.reminderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Reminder set", Toast.LENGTH_SHORT).show();
                // Set a reminder for the book
            }
        });

        String returnDate = book.getReturnDate();
        if (!returnDate.isEmpty()) {
            holder.returnDateTextView.setText(returnDate);
        }
    }

    @Override
    public int getItemCount() {
        return myList.size();
    }

    static class MyListViewHolder extends RecyclerView.ViewHolder {

        TextView titleTextView;
        TextView authorTextView;
        ImageView bookImageView;
        TextView returnDateTextView;
        Button returnDateButton;
        Button reminderButton;

        public MyListViewHolder(@NonNull View itemView) {
            super(itemView);
            titleTextView = itemView.findViewById(R.id.titleTextView);
            authorTextView = itemView.findViewById(R.id.authorTextView);
            bookImageView = itemView.findViewById(R.id.bookImageView);
            returnDateTextView = itemView.findViewById(R.id.returnDateTextView);
            returnDateButton = itemView.findViewById(R.id.returnDateButton);
            reminderButton = itemView.findViewById(R.id.reminderButton);
        }
    }
}
