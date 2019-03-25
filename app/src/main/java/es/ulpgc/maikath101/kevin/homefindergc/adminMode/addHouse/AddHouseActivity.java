package es.ulpgc.maikath101.kevin.homefindergc.adminMode.addHouse;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import es.ulpgc.maikath101.kevin.homefindergc.R;

public class AddHouseActivity
        extends AppCompatActivity implements AddHouseContract.View {

  public static String TAG = AddHouseActivity.class.getSimpleName();

  private AddHouseContract.Presenter presenter;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_remove_house);

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
