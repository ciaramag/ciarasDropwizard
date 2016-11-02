import com.kainos.training.jersey.client.LoginClient;
import org.junit.Assert;
import org.junit.Test;

import javax.ws.rs.core.Response;

/**
 * Created by ciaram on 25/10/2016.
 */
public class LoginClientTest {

    @Test
    public void loginCorrectUsernameCorrectPassword() {
        LoginClient lc = new LoginClient();
      Boolean response = lc.getLogin("admin", "password");
        Assert.assertTrue(response);
    }
    @Test
    public void loginIncorrectUsernameCorrectPassword() {
        LoginClient lc = new LoginClient();
        Boolean response = lc.getLogin("admin1", "password");
        Assert.assertFalse(response);
    }

    @Test
    public void loginCorrectUsernameIncorrectPassword() {
        LoginClient lc = new LoginClient();
        Boolean response = lc.getLogin("admin", "password1");
        Assert.assertFalse(response);
    }

    @Test
    public void changePassword() {
        LoginClient lc = new LoginClient();
        Boolean response = lc.changePassword("admin", "password", "password123");
        Assert.assertTrue(response);
    }

    }