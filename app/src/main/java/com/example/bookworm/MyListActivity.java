package com.example.bookworm;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class MyListActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private MyListAdapter adapter;
    private List<Book> myList;
    private SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_list);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        myList = BrowseBooksActivity.myList;

        adapter = new MyListAdapter(myList, this);
        recyclerView.setAdapter(adapter);

        checkReturnDates();
    }

    private void checkReturnDates() {
        for (Book book : myList) {
            String returnDateStr = book.getReturnDate();
            if (returnDateStr != null && !returnDateStr.isEmpty()) {
                try {
                    Date returnDate = dateFormat.parse(returnDateStr);
                    if (returnDate != null && returnDate.before(new Date())) {
                        Toast.makeText(this, "The return date for " + book.getTitle() + " has passed!", Toast.LENGTH_LONG).show();
                    }
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
