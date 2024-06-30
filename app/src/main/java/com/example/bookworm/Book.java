package com.example.bookworm;

public class Book {
    private String title;
    private String author;
    private String url;
    private int imageResId;
    private String returnDate;

    public Book(String title, String author, int imageResId,String url ) {
        this.title = title;
        this.author = author;
        this.url = url;
        this.imageResId = imageResId;
        this.returnDate = "";
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getUrl() {
        return url;
    }

    public int getImageResId() {
        return imageResId;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }
}
