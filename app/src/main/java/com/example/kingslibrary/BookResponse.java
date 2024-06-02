package com.example.kingslibrary;

import com.example.kingslibrary.Model.Book;

import java.util.List;

public class BookResponse {

    private List<Book> data;
    public List<Book> getData() {
        return data;
    }
    public void setData(List<Book> data) {
        this.data = data;
    }
}
