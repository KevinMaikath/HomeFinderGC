package es.ulpgc.maikath101.kevin.homefindergc.customerMode.homeDetails;

import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import es.ulpgc.maikath101.kevin.homefindergc.R;
import es.ulpgc.maikath101.kevin.homefindergc.customerMode.drawer.DrawerActivity;

public class HomeDetailsActivity
        extends DrawerActivity implements HomeDetailsContract.View, NavigationView.OnNavigationItemSelectedListener {

  public static String TAG = HomeDetailsActivity.class.getSimpleName();

  private HomeDetailsContract.Presenter presenter;
  private FloatingActionButton floatingActionButton;
  private DrawerLayout drawerLayout;
  private TextView textInfo;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_home_details);

    textInfo = findViewById(R.id.text_info);

    floatingActionButton = findViewById(R.id.floatingOptionsButton);
    floatingActionButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        drawerLayout.openDrawer(GravityCompat.START);
      }
    });

    drawerLayout = findViewById(R.id.drawer_layout);
    super.setDrawerLayout(drawerLayout);
    /**
    ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
            this, drawerLayout, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
    drawerLayout.addDrawerListener(toggle);
    toggle.syncState();
**/
    NavigationView navigationView = findViewById(R.id.navigation_view);
    super.setNavigationView(navigationView);
    // navigationView.setNavigationItemSelectedListener(this);


    // do the setup
    HomeDetailsScreen.configure(this);
  }

  @Override
  protected void onResume() {
    super.onResume();

    // do some work
    presenter.fetchData();
  }

  @Override
  public void injectPresenter(HomeDetailsContract.Presenter presenter) {
    this.presenter = presenter;
  }

  @Override
  public void displayData(HomeDetailsViewModel viewModel) {
    //Log.e(TAG, "displayData()");

    textInfo.setText(viewModel.dataShown);
  }

/**
  @Override
  public void onBackPressed() {
    if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
      drawerLayout.closeDrawer(GravityCompat.START);
    } else {
      super.onBackPressed();
    }
  }


  @Override
  public boolean onNavigationItemSelected(MenuItem item) {
    // Handle navigation view item clicks here.
    int id = item.getItemId();

    if (id == R.id.nav_inicio) {
      presenter.goToStart();
    } else if (id == R.id.nav_se_vende) {
      presenter.goToForSale();
    } else if (id == R.id.nav_se_alquila) {
      presenter.goToForRent();
    } else if (id == R.id.nav_alquiler_vacacional) {
      presenter.goToHolidayRental();
    } else if (id == R.id.nav_sobre_nosotros) {
      presenter.goToAboutUS();
    } else if (id == R.id.nav_contacto) {
      presenter.goToContact();
    }

    drawerLayout.closeDrawer(GravityCompat.START);
    return true;
  }
**/

  public void onSummaryButtonClicked(View view) {
    presenter.summaryButtonClicked();
  }

  public void onDescriptionButtonClicked(View view) {
    presenter.descriptionButtonClicked();
  }

  public void onLocationButtonClicked(View view) {
    presenter.locationButtonClicked();
  }

  public void onDistributionButtonClicked(View view) {
    presenter.distributionButtonClicked();
  }

}
