package es.ulpgc.maikath101.kevin.homefindergc.customerMode.contactScreen;

import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import es.ulpgc.maikath101.kevin.homefindergc.R;
import es.ulpgc.maikath101.kevin.homefindergc.customerMode.drawer.DrawerActivity;

public class ContactActivity
        extends DrawerActivity implements ContactContract.View, NavigationView.OnNavigationItemSelectedListener {

  public static String TAG = ContactActivity.class.getSimpleName();

  private ContactContract.Presenter presenter;
  private FloatingActionButton floatingActionButton;
  private DrawerLayout drawerLayout;
  private EditText nameEditText;
  private EditText telephoneEditText;
  private EditText countryEditText;
  private EditText zipcodeEditText;
  private EditText addressEditText;
  private EditText emailEditText;
  private EditText subjectEditText;
  private EditText bodyemailEditText;


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_contact);

    floatingActionButton = findViewById(R.id.floatingOptionsButton);
    floatingActionButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        drawerLayout.openDrawer(GravityCompat.START);
      }
    });

    drawerLayout = findViewById(R.id.drawer_layout);
    super.setDrawerLayout(drawerLayout);

    nameEditText = findViewById(R.id.nameEditText);
    telephoneEditText = findViewById(R.id.telephoneEditText);
    countryEditText = findViewById(R.id.countryEditText);
    zipcodeEditText = findViewById(R.id.zipcodeEditText);
    addressEditText = findViewById(R.id.addressEditText);
    emailEditText = findViewById(R.id.emailEditText);
    subjectEditText = findViewById(R.id.subjectEditText);
    bodyemailEditText = findViewById(R.id.bodyemailEditText);

    NavigationView navigationView = findViewById(R.id.navigation_view);
    navigationView.setItemIconTintList(null);
    super.setNavigationView(navigationView);

    // do the setup
    ContactScreen.configure(this);
  }

  @Override
  protected void onResume() {
    super.onResume();
  }

  @Override
  public void injectPresenter(ContactContract.Presenter presenter) {
    this.presenter = presenter;
  }

  /**
   * Comprueba que todos los campos están rellenados correctamente antes de enviar el correo
   *
   * @return: True si están todos rellenos. False si falta alguno por rellenar
   */
  private boolean checkFields() {
    // Devuelve true si todos los campos están rellenos
    if (!nameEditText.getText().toString().equals("") && !telephoneEditText.getText().toString().equals("")
            && !countryEditText.getText().toString().equals("") && !zipcodeEditText.getText().toString().equals("")
            && !addressEditText.getText().toString().equals("")
            && !emailEditText.getText().toString().equals("")
            && !subjectEditText.getText().toString().equals("")
            && !bodyemailEditText.getText().toString().equals("")) {
      return true;
    }
    return false;
  }

  /**
   * Llama a checkFields y en caso de estar rellenados todos los campos, llama al presenter para
   * formar el correo. En caso contrario, muestra un Toast por pantalla.
   *
   * @param view
   */
  public void onSendButtonPressed(View view) {
    if (checkFields()) {
      presenter.onSendButtonPressed(this, nameEditText.getText().toString(), telephoneEditText.getText().toString(),
              countryEditText.getText().toString(), zipcodeEditText.getText().toString(),
              addressEditText.getText().toString(), emailEditText.getText().toString(),
              subjectEditText.getText().toString(), bodyemailEditText.getText().toString());
    } else {
      Toast.makeText(getApplicationContext(), "Rellene todos los campos, por favor", Toast.LENGTH_LONG).show();
    }
  }

}
