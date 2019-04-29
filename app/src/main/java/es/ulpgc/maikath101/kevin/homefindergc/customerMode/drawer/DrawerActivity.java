package es.ulpgc.maikath101.kevin.homefindergc.customerMode.drawer;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;

import es.ulpgc.maikath101.kevin.homefindergc.R;
import es.ulpgc.maikath101.kevin.homefindergc.customerMode.startScreen.StartActivity;

public class DrawerActivity extends AppCompatActivity implements DrawerContract.View, NavigationView.OnNavigationItemSelectedListener{

  public static String TAG = StartActivity.class.getSimpleName();
  private DrawerContract.Presenter presenter;
  //private FloatingActionButton floatingActionButton;
  private DrawerLayout drawerLayout;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
   // setContentView(R.layout.drawer_layout);

   // presenter = new DrawerPresenter();

    /**
    drawerLayout = findViewById(R.id.drawer_layout);
    ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
            this, drawerLayout, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
    drawerLayout.addDrawerListener(toggle);
    toggle.syncState();

    NavigationView navigationView = findViewById(R.id.navigation_view);
    navigationView.setNavigationItemSelectedListener(this);
**/
    DrawerScreen.configure(this);

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

  @Override
  public void injectPresenter(DrawerContract.Presenter presenter) {
    this.presenter = presenter;
  }

  @Override
  public void onBackPressed() {
    if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
      drawerLayout.closeDrawer(GravityCompat.START);
    } else {
      super.onBackPressed();
    }
  }

  public void setDrawerLayout(DrawerLayout drawerLayout) {
    this.drawerLayout = drawerLayout;
    configureDrawerLayout();
  }

  private void configureDrawerLayout(){
    ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
            this, drawerLayout, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
    drawerLayout.addDrawerListener(toggle);
    toggle.syncState();
  }

  public void setNavigationView(NavigationView navigationView){
    navigationView.setNavigationItemSelectedListener(this);
  }
}
