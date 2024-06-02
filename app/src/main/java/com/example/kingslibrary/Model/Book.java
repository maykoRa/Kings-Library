package com.example.kingslibrary.Model;

public class Book {
    private Integer id;
    private Integer Year;
    private String Title;
    private String Publisher;
    private String ISBN;
    private Integer Pages;

    public Book(Integer id, Integer year, String title, String publisher, String ISBN, Integer pages) {
        this.id = id;
        this.Year = year;
        this.Title = title;
        this.Publisher = publisher;
        this.ISBN = ISBN;
        this.Pages = pages;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getYear() {
        return Year;
    }

    public void setYear(Integer year) {
        Year = year;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getPublisher() {
        return Publisher;
    }

    public void setPublisher(String publisher) {
        Publisher = publisher;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public Integer getPages() {
        return Pages;
    }

    public void setPages(Integer pages) {
        Pages = pages;
    }

}

//"https://covers.openlibrary.org/b/isbn/" + isbn + ".jpg"
