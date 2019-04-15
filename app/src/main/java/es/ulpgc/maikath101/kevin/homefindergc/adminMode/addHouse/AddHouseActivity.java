package es.ulpgc.maikath101.kevin.homefindergc.adminMode.addHouse;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import es.ulpgc.maikath101.kevin.homefindergc.R;

public class AddHouseActivity
        extends AppCompatActivity implements AddHouseContract.View {

  public static String TAG = AddHouseActivity.class.getSimpleName();

  private AddHouseContract.Presenter presenter;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_add_house);

    Toolbar toolbar = findViewById(R.id.addHouseToolbar);
    setSupportActionBar(toolbar);

    ImageButton doneButton = toolbar.findViewById(R.id.doneButton);
    ImageButton backButton = toolbar.findViewById(R.id.backToolbarButton);
    ImageButton addImageButton = findViewById(R.id.add_image_button);

    doneButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        Toast.makeText(getApplicationContext(), "Done presionado", Toast.LENGTH_SHORT).show();
      }
    });
    backButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        finish();
      }
    });

    addImageButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        presenter.launchCamera();
      }
    });
    // do the setup
    AddHouseScreen.configure(this);
  }

  @Override
  protected void onResume() {
    super.onResume();

    // do some work
    presenter.fetchData();
  }

  @Override
  public void injectPresenter(AddHouseContract.Presenter presenter) {
    this.presenter = presenter;
  }

  @Override
  public void displayData(AddHouseViewModel viewModel) {
    //Log.e(TAG, "displayData()");

    // deal with the data
  }
}
