package com.kainos.training.login.service.resource;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.FormParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("/login")
@Produces(MediaType.APPLICATION_JSON)
public class LoginResource {

    private final String requiredUsername;
    private final String requiredPassword;
    private List<String> users = new ArrayList<String>();

    public LoginResource(String requiredUsername, String requiredPassword) {
        this.requiredUsername = requiredUsername;
        this.requiredPassword = requiredPassword;
        //add users to the list
        users.add("admin");
        users.add("ciara");
        users.add("bill");
    }

    @POST
    public Response login(@FormParam("username") String username,
                          @FormParam("password") String password) {

        if (username.toLowerCase().equals(requiredUsername) && password.toLowerCase().equals(requiredPassword)) {
            return Response
                    .status(Response.Status.OK)
                    .entity("Success!")
                    .build();
        } else if (username.isEmpty() || password.isEmpty()) {
            return Response
                    .status(Response.Status.UNAUTHORIZED)
                    .entity("Error with username or password")
                    .build();
        } else if(username.length()>20 || password.length()>20){
            return Response
                    .status(Response.Status.UNAUTHORIZED)
                    .entity("Error with username or password")
                    .build();
        } else {
            return Response
                    .status(Response.Status.UNAUTHORIZED)
                    .entity("Unauthorized access:(")
                    .build();
        }
    }

    @GET
    public Response showUsers(){
        return Response
                .status(Response.Status.OK)
                .entity(users).build();

    }
}
