package com.kainos.training.dropwizard.login.frontends.resources;

import com.kainos.training.jersey.client.BookClient;
import com.kainos.training.jersey.client.LoginClient;
import io.dropwizard.views.View;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ViewsResourceTest {

    private LoginClient fakeClient;
    private BookClient fakeBookClient;

    @Before
    @Test
    public void setup(){

        fakeClient = mock(LoginClient.class);
        fakeBookClient = mock(BookClient.class);
    }

    @Test
    public void loginMethodReturnsFalse(){
        when(fakeClient.getLogin("adminuser", "password12")).thenReturn(false);
    }

    @Test
    public void loginMethodReturnsTrue(){
        when(fakeClient.getLogin("admin", "password")).thenReturn(true);
    }

    @Test
    public void loginMethodReturnsView(){

        //arrange
        ViewsResource vr = new ViewsResource(fakeClient, fakeBookClient);
        //act
        //assert
        Assert.assertEquals(true, vr.login() instanceof View);
    }



}
