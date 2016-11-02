package com.kainos.training.dropwizard.login.frontends.views;

import com.kainos.login.models.Book;
import io.dropwizard.views.View;

import java.util.List;

public class BookView extends View {

    private final List<Book> books;

    private final int bookCount;

    public BookView(List<Book> books) {
        super("/list.ftl");
        this.books = books;
        bookCount = books.size();
    }

    public List<Book> getBooks() {

        return books;
    }

    public int getBookCount() {

        return bookCount;
    }
}