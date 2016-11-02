package com.kainos.training.dropwizard.login.frontends.resources;

import com.kainos.login.models.Book;
import com.kainos.training.dropwizard.login.frontends.views.*;
import com.kainos.training.jersey.client.BookClient;
import com.kainos.training.jersey.client.LoginClient;
import io.dropwizard.views.View;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import com.codahale.metrics.annotation.Timed;

import java.util.ArrayList;
import java.util.List;

@Path("/test")
public class ViewsResource {

	private LoginClient client;
	private BookClient bookClient;

	public ViewsResource(LoginClient client, BookClient bookClient){
		this.client = client;
		this.bookClient = bookClient;
	}

	@GET
	@Timed
	@Path("/login")
	@Produces(MediaType.TEXT_HTML)
	public View login() {
		return new Index();
	}

	@POST
	@Timed
	@Path("login-details")
	@Produces(MediaType.TEXT_HTML)
	public View loginDetails(@FormParam("username") String username,
			 			     @FormParam("password") String password){

		if(client.getLogin(username, password)){
			return new LoginSuccessView();
		}
		else{
			return new LoginFailureView();
		}
	}

	@GET
	@Timed
	@Path("/users")
	@Produces(MediaType.TEXT_HTML)
	public void users() {
		ArrayList<String> users = client.showUsers();
		users.stream().forEach(System.out::println);
	}

	@GET
	@Timed
	@Path("/books")
	@Produces(MediaType.TEXT_HTML)
	public View bookList(){
		List<Book> books = bookClient.getBooks();
		return new BookView(books);
	}

	@GET
	@Timed
	@Path("/{bookId}")
	@Produces(MediaType.TEXT_HTML)
	public View book(@QueryParam("id") int bookId){
		return new BookView();
	}

}