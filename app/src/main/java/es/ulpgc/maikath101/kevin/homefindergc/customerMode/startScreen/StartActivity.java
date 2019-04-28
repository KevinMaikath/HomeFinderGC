package es.ulpgc.maikath101.kevin.homefindergc.customerMode.startScreen;

import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import es.ulpgc.maikath101.kevin.homefindergc.R;
import es.ulpgc.maikath101.kevin.homefindergc.customerMode.drawer.DrawerActivity;
import es.ulpgc.maikath101.kevin.homefindergc.customerMode.drawer.DrawerContract;
import es.ulpgc.maikath101.kevin.homefindergc.data.House;

public class StartActivity
        extends DrawerActivity implements StartContract.View {
  /**
   * TODO  crear DrawerLayout
   * CREAR:
   * - DrawerActivity: todas las activities heredan de esta.
   * - DrawerLayout: solo drawer con navigationView, las activities que heredan se quedan
   * con solo el CoordinatorLayout
   * - AppRouter: ya creado
   * - DrawerPresenter: para comunicar DrawerActivity con AppRouter, todos los presentadores
   * heredan de este
   */


  public static String TAG = StartActivity.class.getSimpleName();

  private StartContract.Presenter presenter;
  private FloatingActionButton floatingActionButton;
  private DrawerLayout drawerLayout;
  private TextView topText;

  private StartHouseAdapter listAdapter;


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_start);

    topText = findViewById(R.id.topText);

    floatingActionButton = findViewById(R.id.floatingOptionsButton);
    floatingActionButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        drawerLayout.openDrawer(GravityCompat.START);
      }
    });

    /**
    drawerLayout = findViewById(R.id.drawer_layout);
    ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
            this, drawerLayout, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
    drawerLayout.addDrawerListener(toggle);
    toggle.syncState();

    NavigationView navigationView = findViewById(R.id.navigation_view);
    navigationView.setNavigationItemSelectedListener(this);
**/
    listAdapter = new StartHouseAdapter(new View.OnClickListener() {

      @Override
      public void onClick(View view) {
        House item = (House) view.getTag();
        presenter.selectHouse(item);
      }

    });

    RecyclerView recyclerView = findViewById(R.id.recyclerView);
    recyclerView.setAdapter(listAdapter);

    RecyclerView.LayoutManager linearLayoutManager = new LinearLayoutManager(this) {
      @Override
      public boolean canScrollVertically() {
        return false;
      }
    };
    recyclerView.setLayoutManager(linearLayoutManager);

    // do the setup
    StartScreen.configure(this);

    // POR DEFECTO SE CARGAN LAS CASAS QUE ESTÁN EN VENTA
    presenter.fetchStartHousesData();

    presenter.checkCurrentScreen();
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
        listAdapter.setItems(viewModel.houseList);
      }

    });
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
**/
/**
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

  public void onHouseClicked(View view) {
    presenter.goToHomeDetail();
  }

}
