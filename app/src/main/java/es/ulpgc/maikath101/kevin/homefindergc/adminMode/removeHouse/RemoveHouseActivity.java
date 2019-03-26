package es.ulpgc.maikath101.kevin.homefindergc.adminMode.removeHouse;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

import es.ulpgc.maikath101.kevin.homefindergc.R;

public class RemoveHouseActivity
        extends AppCompatActivity implements RemoveHouseContract.View {

  public static String TAG = RemoveHouseActivity.class.getSimpleName();

  private RemoveHouseContract.Presenter presenter;



  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_remove_house);

    Toolbar toolbar = findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);



    Button toolbarButton = toolbar.findViewById(R.id.toolbarButton);
    TextView toolbarTextView = toolbar.findViewById(R.id.toolbarTextView);

    toolbarButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        Toast.makeText(getApplicationContext(),"Esto es una prueba", Toast.LENGTH_LONG).show();
      }
    });


    // do the setup
    RemoveHouseScreen.configure(this);
  }

  @Override
  protected void onResume() {
    super.onResume();

    // do some work
    presenter.fetchData();
  }

  @Override
  public void injectPresenter(RemoveHouseContract.Presenter presenter) {
    this.presenter = presenter;
  }

  @Override
  public void displayData(RemoveHouseViewModel viewModel) {
    //Log.e(TAG, "displayData()");

    // deal with the data
  }
}
