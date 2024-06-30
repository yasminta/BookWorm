package com.example.bookworm;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class BrowseBooksActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private BookAdapter adapter;
    private List<Book> bookList;

    public static List<Book> myList = new ArrayList<>(); // Temporary list for holding user's selected books

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_browse_book);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        bookList = new ArrayList<>();
        bookList = new ArrayList<>();
        bookList.add(new Book("Fourth Wing", "Rebecca Yarros", R.drawable.fourth_wing, "https://www.steimatzky.co.il/021311398"));
        bookList.add(new Book("How To Be Perfect", "Michael Schur", R.drawable.how_to_be_perfect,"https://www.steimatzky.co.il/029020221"));
        bookList.add(new Book("How To Be Your Own Therapist", "Owen O'kane", R.drawable.how_to_be_your_own_therapist,"https://www.steimatzky.co.il/020882637"));
        bookList.add(new Book("I Could Nosh", "Jake Cohen", R.drawable.i_could_nosh,"https://www.steimatzky.co.il/024362952"));
        bookList.add(new Book("If Love Had a Price", "Ana Huang", R.drawable.if_love_had_a_price,"https://www.steimatzky.co.il/025630320"));
        bookList.add(new Book("Love Your Life", "Dominique Bertoluka", R.drawable.love_your_life,"https://www.steimatzky.co.il/025230510"));
        bookList.add(new Book("Sababa", "Michael Solomonov", R.drawable.sababa,"https://www.steimatzky.co.il/020073331"));
        bookList.add(new Book("Wake Up Call", "Beth O'leary", R.drawable.wake_up_call,"https://www.steimatzky.co.il/029020235"));
        bookList.add(new Book("Wild Love", "Elsie Silver", R.drawable.wild_love,"https://www.steimatzky.co.il/025630347"));
        // ...

        adapter = new BookAdapter(bookList, this);
        recyclerView.setAdapter(adapter);
    }

    public static void addBookToMyList(Book book) {
        myList.add(book);
    }
}



        // ...






// הוספת ספרים לדוגמה



