package es.ulpgc.maikath101.kevin.homefindergc.customerMode.startScreen;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import es.ulpgc.maikath101.kevin.homefindergc.R;
import es.ulpgc.maikath101.kevin.homefindergc.customerMode.drawer.DrawerActivity;
import es.ulpgc.maikath101.kevin.homefindergc.data.SimpleHouse;

public class StartActivity
        extends DrawerActivity implements StartContract.View {

  public static String TAG = StartActivity.class.getSimpleName();

  private StartContract.Presenter presenter;
  private DrawerLayout drawerLayout;
  private TextView topText;

  private StartHouseAdapter listAdapter;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_start);

    topText = findViewById(R.id.topText);

    FloatingActionButton floatingActionButton = findViewById(R.id.floatingOptionsButton);
    floatingActionButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        drawerLayout.openDrawer(GravityCompat.START);
      }
    });

    drawerLayout = findViewById(R.id.drawer_layout);
    super.setDrawerLayout(drawerLayout);

    NavigationView navigationView = findViewById(R.id.navigation_view);
    navigationView.setItemIconTintList(null);
    super.setNavigationView(navigationView);

    listAdapter = new StartHouseAdapter(new View.OnClickListener() {

      @Override
      public void onClick(View view) {
        SimpleHouse item = (SimpleHouse) view.getTag();
        presenter.selectHouse(view.getContext(),item);
      }

    });

    RecyclerView recyclerView = findViewById(R.id.recyclerView);
    recyclerView.setAdapter(listAdapter);

    // do the setup
    StartScreen.configure(this);

    verifyPermissions();
  }

  @Override
  protected void onResume() {
    super.onResume();

    // do some work
    // presenter.fetchData();
    presenter.checkCurrentScreen();
  }

  @Override
  public void injectPresenter(StartContract.Presenter presenter) {
    this.presenter = presenter;
  }

  @Override
  public void displayData(final StartViewModel viewModel) {
    //Log.e(TAG, "displayData()");

    runOnUiThread(new Runnable() {

      @Override
      public void run() {
        int text_string = viewModel.topText;

        if (text_string == R.string.holiday_rental_label) {
          topText.setTextSize(24);
          topText.setPadding(40, 10, 0, 30);
        } else {
          topText.setTextSize(30);
          topText.setPadding(0, 10, 0, 30);
        }
        topText.setText(viewModel.topText);

        // deal with the data
        listAdapter.setItems(viewModel.simpleHouseList);
      }

    });
  }

  private void verifyPermissions() {
    Log.e(TAG, "Verifying permisssions");
    String[] permissions = {Manifest.permission.READ_EXTERNAL_STORAGE};

    if (ContextCompat.checkSelfPermission(this.getApplicationContext(), permissions[0]) ==
            PackageManager.PERMISSION_GRANTED) {
    } else {
      ActivityCompat.requestPermissions(this, permissions, 1);
    }
  }

  @Override
  public void onBackPressed() {
    presenter.onBackPressed(this);
  }

}
