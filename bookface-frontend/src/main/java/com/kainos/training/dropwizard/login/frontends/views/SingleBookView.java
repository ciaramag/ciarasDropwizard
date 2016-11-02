package com.kainos.training.dropwizard.login.frontends.views;

import io.dropwizard.views.View;

/**
 * Created by ciaram on 02/11/2016.
 */
public class SingleBookView extends View {

    protected SingleBookView(int bookID) {
        super("/book");
    }
}
