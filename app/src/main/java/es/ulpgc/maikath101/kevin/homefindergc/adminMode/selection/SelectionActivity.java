package es.ulpgc.maikath101.kevin.homefindergc.adminMode.selection;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import es.ulpgc.maikath101.kevin.homefindergc.R;

public class SelectionActivity
        extends AppCompatActivity implements SelectionContract.View {

  public static String TAG = SelectionActivity.class.getSimpleName();

  private SelectionContract.Presenter presenter;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_selection);

    Button addHouseBt = findViewById(R.id.addHouseButton);
    Button removeHouseBt = findViewById(R.id.removeHouseButton);

    addHouseBt.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        presenter.goToAddHouseScreen(v.getContext());
      }
    });

    removeHouseBt.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        presenter.goToRemoveHouseScreen(v.getContext());
      }
    });
    // do the setup
    SelectionScreen.configure(this);

    verifyPermissions();
  }

  @Override
  public void injectPresenter(SelectionContract.Presenter presenter) {
    this.presenter = presenter;
  }

  private void verifyPermissions() {
    Log.e(TAG, "Verifying permisssions");
    String[] permissions = {Manifest.permission.READ_EXTERNAL_STORAGE};

    if (ContextCompat.checkSelfPermission(this.getApplicationContext(), permissions[0])
            == PackageManager.PERMISSION_GRANTED) {

    } else {
      ActivityCompat.requestPermissions(this, permissions, 1);
    }
  }

}
