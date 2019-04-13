package es.ulpgc.maikath101.kevin.homefindergc.adminMode.login;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import es.ulpgc.maikath101.kevin.homefindergc.R;

public class LoginActivity
        extends AppCompatActivity implements LoginContract.View {

  public static String TAG = LoginActivity.class.getSimpleName();

  private LoginContract.Presenter presenter;
  private Button signInButton;
  private EditText userEditText;
  private EditText passwordEditText;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_login2);

    // do the setup
    LoginScreen.configure(this);
    userEditText = findViewById(R.id.userEditText2);
    passwordEditText = findViewById(R.id.passwordEditText2);

    signInButton = findViewById(R.id.signInButton2);

    signInButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        presenter.navigateToNextScreen();
        // presenter.onSignInPressed(userEditText.toString(), passwordEditText.toString());
      }
    });
  }

  @Override
  public void injectPresenter(LoginContract.Presenter presenter) {
    this.presenter = presenter;
  }

  @Override
  public void wrongCredentials() {
    Toast.makeText(getApplicationContext(), "El usuario o la contraseña son incorrectos", Toast.LENGTH_LONG).show();
  }


}
