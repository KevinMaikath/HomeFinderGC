package es.ulpgc.maikath101.kevin.homefindergc.adminModeTests.login;

import android.util.Log;

import org.junit.Test;

import es.ulpgc.maikath101.kevin.homefindergc.adminMode.login.LoginModel;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class LoginModelJUnitTests {

  @Test
  public void wrongCredentials() {
    LoginModel model = new LoginModel();
    assertFalse(model.checkCredentials("admina", "12345"));
  }

  @Test
  public void rigthCredentials() {
    LoginModel model = new LoginModel();
    assertTrue(model.checkCredentials("admin", "1234"));
  }
}
