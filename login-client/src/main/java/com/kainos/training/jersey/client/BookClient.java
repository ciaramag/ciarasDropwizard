package com.kainos.training.jersey.client;

import com.kainos.login.models.Book;

import javax.swing.*;
import javax.ws.rs.GET;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ciaram on 01/11/2016.
 */
public class BookClient {

    private final String BASE_URL = "http://localhost:8080";
    private final String BOOK_PATH = "books";
    private Response response;
    private WebTarget bookWebTarget;

    public BookClient() {
        Client client = ClientBuilder.newClient();
        WebTarget webTarget = client.target(BASE_URL); // http://localhost:8080
        bookWebTarget = webTarget.path(BOOK_PATH); // http://localhost:8080/book
    }

    public Book getBook(int bookId) {
        response = bookWebTarget.path(String.valueOf(bookId)).request().get();
        return response.readEntity(Book.class);
    }

    public List<Book> getBooks() {
        response = bookWebTarget.request().get();
        return response.readEntity(new GenericType<List<Book>>() {});
    }
}


