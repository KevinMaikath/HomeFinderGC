package es.ulpgc.maikath101.kevin.homefindergc.customerMode.homeDetails;

import android.net.Uri;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;

import es.ulpgc.maikath101.kevin.homefindergc.R;
import es.ulpgc.maikath101.kevin.homefindergc.customerMode.drawer.DrawerActivity;
import es.ulpgc.maikath101.kevin.homefindergc.data.Image;

public class HomeDetailsActivity
        extends DrawerActivity implements HomeDetailsContract.View, NavigationView.OnNavigationItemSelectedListener {

  public static String TAG = HomeDetailsActivity.class.getSimpleName();

  private HomeDetailsContract.Presenter presenter;
  private FloatingActionButton floatingActionButton;
  private DrawerLayout drawerLayout;
  private TextView textInfo;
  private ImageView current_image;
  private ImageListAdapter image_list;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_home_details);

    textInfo = findViewById(R.id.text_info);
    current_image = findViewById(R.id.current_image);

    floatingActionButton = findViewById(R.id.floatingOptionsButton);
    floatingActionButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        drawerLayout.openDrawer(GravityCompat.START);
      }
    });

    drawerLayout = findViewById(R.id.drawer_layout);
    super.setDrawerLayout(drawerLayout);

    image_list = new ImageListAdapter(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        Image image = (Image) view.getTag();
        presenter.imageClicked(image);
      }
    });

    RecyclerView image_recycler = findViewById(R.id.image_list);
    image_recycler.setAdapter(image_list);
    image_recycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

    NavigationView navigationView = findViewById(R.id.navigation_view);
    navigationView.setItemIconTintList(null);
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
  public void displayData(final HomeDetailsViewModel viewModel) {
    //Log.e(TAG, "displayData()");
    textInfo.setText(viewModel.dataShown);

    runOnUiThread(new Runnable() {
      @Override
      public void run() {
        if (viewModel.current_image.imageUri != null) {
          current_image.setImageURI(Uri.parse(viewModel.current_image.imageUri));
        } else {
          loadImageFromURL(current_image, viewModel.current_image.url);
        }
      }
    });
  }

  @Override
  public void setImageList(HomeDetailsViewModel viewModel) {
    image_list.setItems(viewModel.image_list);
  }

  @Override
  public void onBackPressed() {
    this.finish();
  }

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

  private void loadImageFromURL(ImageView imageView, String imageUrl) {
    RequestManager reqManager = Glide.with(imageView.getContext());
    RequestBuilder reqBuilder = reqManager.load(imageUrl);
    RequestOptions reqOptions = new RequestOptions();
    reqOptions.diskCacheStrategy(DiskCacheStrategy.ALL);
    reqBuilder.apply(reqOptions);
    reqBuilder.into(imageView);
  }

}
