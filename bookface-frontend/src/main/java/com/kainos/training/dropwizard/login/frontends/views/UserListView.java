package com.kainos.training.dropwizard.login.frontends.views;

import io.dropwizard.views.View;

public class UserListView extends View{

        public UserListView(){
            super("/users.ftl");
        }
    }
