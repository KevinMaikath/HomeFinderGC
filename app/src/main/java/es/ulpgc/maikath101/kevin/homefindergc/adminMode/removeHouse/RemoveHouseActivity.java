package es.ulpgc.maikath101.kevin.homefindergc.adminMode.removeHouse;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

import es.ulpgc.maikath101.kevin.homefindergc.R;

public class RemoveHouseActivity
        extends AppCompatActivity implements RemoveHouseContract.View {

  public static String TAG = RemoveHouseActivity.class.getSimpleName();

  private RemoveHouseContract.Presenter presenter;
  private ListView listView;


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_remove_house);

    Toolbar toolbar = findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);


    listView = findViewById(R.id.removeHouseListView);
    Button toolbarButton = toolbar.findViewById(R.id.backToolbarButton);
    TextView toolbarTextView = toolbar.findViewById(R.id.toolbarTextView);

    toolbarButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        finish();
      }
    });

    // do the setup
    RemoveHouseScreen.configure(this);

    presenter.loadAllHouses();
  }

  @Override
  public void injectPresenter(RemoveHouseContract.Presenter presenter) {
    this.presenter = presenter;
  }

  @Override
  public void displayData(RemoveHouseViewModel viewModel) {
    //Log.e(TAG, "displayData()");

    // deal with the data
    listView.setAdapter(new RemoveHouseAdapter(this, viewModel.houses, new View.OnClickListener() {
      @Override
      public void onClick(View v) {

      }
    }));

  }
}
