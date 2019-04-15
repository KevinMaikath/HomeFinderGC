package es.ulpgc.maikath101.kevin.homefindergc.adminMode.login;

public class LoginModel implements LoginContract.Model {

  public static String TAG = LoginModel.class.getSimpleName();
  private String USER = "admin";
  private String PASSWORD = "1234";

  public LoginModel() {

  }


  @Override
  public boolean checkCredentials(String user, String password) {
    if (USER.equals(user) && PASSWORD.equals(password)) {
      return true;
    } else {
      return false;
    }
  }
}
