package com.kainos.training.login.service.resource;

import javax.ws.rs.core.Response;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class LoginResourceTest {

	@Test
	public void loginWithCorrectDetailsReturnsOkResponse() {
		// arrange
		LoginResource loginResource = new LoginResource("admin", "password");

		// act
		Response response = loginResource.login("admin", "password");

		// assert
		Assert.assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
		Assert.assertEquals("Success!", response.getEntity());

	}

	@Test
	public void loginWithIncorrectUsernameCorrectPasswordReturnUnauthorized(){
		//arrange
		LoginResource loginResource = new LoginResource("admin", "password");

		//act
		Response response = loginResource.login("a1dmin", "password");

		//assert
		Assert.assertEquals(Response.Status.UNAUTHORIZED.getStatusCode(), response.getStatus());
		Assert.assertEquals("Unauthorized access:(", response.getEntity());
	}

	@Test
	public void loginWithCorrectUsernameIncorrectPasswordReturnUnauthorized(){
		//arrange
		LoginResource loginResource = new LoginResource("admin", "password");

		//act
		Response response = loginResource.login("admin", "password123");

		//assert
		Assert.assertEquals(Response.Status.UNAUTHORIZED.getStatusCode(), response.getStatus());
		Assert.assertEquals("Unauthorized access:(", response.getEntity());
	}

	@Test
	public void loginUpperCaseReturnSuccess(){
		//arrange
		LoginResource loginResource = new LoginResource("admin", "password");

		//act
		Response response = loginResource.login("Admin", "password");

		//assert
		Assert.assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
		Assert.assertEquals("Success!", response.getEntity());
	}

	@Test
	public void loginWithEmptyUsernameReturnUnauthorized(){
		//arrange
		LoginResource loginResource = new LoginResource("admin", "password");

		//act
		Response response = loginResource.login("", "password");

		//assert
		Assert.assertEquals(Response.Status.UNAUTHORIZED.getStatusCode(), response.getStatus());
		Assert.assertEquals("Error with username or password", response.getEntity());
	}

	@Test
	public void loginWithEmptyPasswordReturnUnauthorized(){
		//arrange
		LoginResource loginResource = new LoginResource("admin", "password");

		//act
		Response response = loginResource.login("admin", "");

		//assert
		Assert.assertEquals(Response.Status.UNAUTHORIZED.getStatusCode(), response.getStatus());
		Assert.assertEquals("Error with username or password", response.getEntity());
	}

	@Test
	public void loginWithUsernameTooLongPasswordCorrectReturnLengthRequired(){
		//arrange
		LoginResource loginResource = new LoginResource("admin", "password");

		//act
		Response response = loginResource.login("weallloveadministrationstaff", "password");

		//assert
		Assert.assertEquals(Response.Status.UNAUTHORIZED.getStatusCode(), response.getStatus());
		Assert.assertEquals("Error with username or password", response.getEntity());
	}

	@Test
	public void loginWithPasswordTooLongReturnLengthRequired(){
		//arrange
		LoginResource loginResource = new LoginResource("admin", "password");

		//act
		Response response = loginResource.login("admin", "passwordsareanightmaretoremember");

		//assert
		Assert.assertEquals(Response.Status.UNAUTHORIZED.getStatusCode(), response.getStatus());
		Assert.assertEquals("Error with username or password", response.getEntity());
	}


}
