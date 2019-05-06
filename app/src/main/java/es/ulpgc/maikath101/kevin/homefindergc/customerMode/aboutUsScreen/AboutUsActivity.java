package es.ulpgc.maikath101.kevin.homefindergc.customerMode.aboutUsScreen;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.View;
import android.widget.TextView;

import es.ulpgc.maikath101.kevin.homefindergc.R;
import es.ulpgc.maikath101.kevin.homefindergc.customerMode.drawer.DrawerActivity;

public class AboutUsActivity extends DrawerActivity implements AboutUsContract.View,
        NavigationView.OnNavigationItemSelectedListener {
  public static String TAG = AboutUsActivity.class.getSimpleName();

  private AboutUsContract.Presenter presenter;
  private DrawerLayout drawerLayout;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_about_us);

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

    // do the setup
    AboutUsScreen.configure(this);

    TextView messageView = findViewById(R.id.aboutUsTextView);
    String text = getString(R.string.company_information);
    messageView.setText(text);
  }

  @Override
  protected void onResume() {
    super.onResume();

    // do some work
    presenter.fetchData();
  }

  @Override
  public void injectPresenter(AboutUsContract.Presenter presenter) {
    this.presenter = presenter;
  }

  @Override
  public void displayData(AboutUsViewModel viewModel) {
    //Log.e(TAG, "displayData()");

    // deal with the data}
  }
}
