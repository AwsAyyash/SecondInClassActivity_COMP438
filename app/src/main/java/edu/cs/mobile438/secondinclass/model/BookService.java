package edu.cs.mobile438.secondinclass.model;

import java.util.List;

public interface BookService {

    boolean addBook(Book book);

    List<Book> getBooks();
}
