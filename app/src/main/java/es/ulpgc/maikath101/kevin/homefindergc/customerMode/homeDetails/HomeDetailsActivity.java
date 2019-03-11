package es.ulpgc.maikath101.kevin.homefindergc.customerMode.homeDetails;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import es.ulpgc.maikath101.kevin.homefindergc.R;

public class HomeDetailsActivity
        extends AppCompatActivity implements HomeDetailsContract.View {

    public static String TAG = HomeDetailsActivity.class.getSimpleName();

    private HomeDetailsContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_details);

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

        // deal with the data
        ((TextView) findViewById(R.id.data)).setText(viewModel.data);
    }
}
