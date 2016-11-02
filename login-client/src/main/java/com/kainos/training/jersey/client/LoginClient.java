package com.kainos.training.jersey.client;

import javax.annotation.Resource;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;

public class LoginClient {

    private final String BASE_URL = "http://localhost:8080";
    private final String LOGIN_PATH = "login";
    private final String USER_PATH = "users";
    private final String USERNAME_FORM_PARAM = "username";
    private final String PASSWORD_FORM_PARAM = "password";
    private final String REQUEST_ENCODING = "application/x-www-form-urlencoded";

    private final int SUCCESS_RESPONSE = 200;

    private WebTarget loginWebTarget, userWebTarget;

    public LoginClient() {
        Client client = ClientBuilder.newClient();
        WebTarget webTarget = client.target(BASE_URL); // http://localhost:8080
        loginWebTarget = webTarget.path(LOGIN_PATH); // http://localhost:8080/login
        userWebTarget = webTarget.path(USER_PATH); // http://localhost:8080/users

    }

    public boolean getLogin(String username, String password) {
        Form form = new Form();
        form.param(USERNAME_FORM_PARAM, username);
        form.param(PASSWORD_FORM_PARAM, password);

        Invocation.Builder invocationBuilder = loginWebTarget.request();
        Response response = invocationBuilder.post(Entity.entity(form, REQUEST_ENCODING));

        if (response.getStatus() == SUCCESS_RESPONSE) {
            return true;
        }
        return false;
    }

    public boolean changePassword(String username, String password, String newPassword){

        if(username == USERNAME_FORM_PARAM && password ==PASSWORD_FORM_PARAM){
            password = newPassword;
            return true;
        }
        else return false;
    }

    public ArrayList<String> showUsers(){

        Invocation.Builder ib = loginWebTarget.request();
        Response response = ib.get();

        System.out.println(response.getEntity());

       ArrayList<String> users = response.readEntity(new GenericType<ArrayList<String>>(){});

        return users;
    }
}
