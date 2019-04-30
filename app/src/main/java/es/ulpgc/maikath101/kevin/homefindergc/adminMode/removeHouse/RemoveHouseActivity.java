package es.ulpgc.maikath101.kevin.homefindergc.adminMode.removeHouse;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

import es.ulpgc.maikath101.kevin.homefindergc.R;
import es.ulpgc.maikath101.kevin.homefindergc.data.SimpleHouse;

public class RemoveHouseActivity
        extends AppCompatActivity implements RemoveHouseContract.View {

  public static String TAG = RemoveHouseActivity.class.getSimpleName();

  private RemoveHouseContract.Presenter presenter;
  private RemoveHouseAdapter listAdapter;


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_remove_house);

    Toolbar toolbar = findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);


    listAdapter = new RemoveHouseAdapter(this, new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        SimpleHouse house = (SimpleHouse) v.getTag();
        Log.e(TAG, house.referenceNumber);
        // Toast.makeText(getApplicationContext(), "Pulsada la casa: " + house.referenceNumber).show();
      }
    });


    RecyclerView recyclerView = findViewById(R.id.removeHouseRecyclerView);
    recyclerView.setAdapter(listAdapter);

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
  public void displayData(final RemoveHouseViewModel viewModel) {
    //Log.e(TAG, "displayData()");

    runOnUiThread(new Runnable() {
      @Override
      public void run() {
        // listAdapter.setItems(viewModel.houses);
        listAdapter.setSimpleHouseAdaptersList(viewModel.simpleHouses);
      }
    });

  }
}
