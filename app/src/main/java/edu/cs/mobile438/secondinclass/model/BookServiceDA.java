package edu.cs.mobile438.secondinclass.model;

import java.util.ArrayList;
import java.util.List;

public class BookServiceDA implements BookService{

    private List<Book> books = new ArrayList<>();

    @Override
    public boolean addBook(Book book) {

        books.add(book);


        return true;
    }

    @Override
    public List<Book> getBooks() {
        return books;
    }
}
