package es.ulpgc.maikath101.kevin.homefindergc.customerMode.startScreen;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import es.ulpgc.maikath101.kevin.homefindergc.R;

public class StartActivity
        extends AppCompatActivity implements StartContract.View {

    public static String TAG = StartActivity.class.getSimpleName();

    private StartContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        // do the setup
        StartScreen.configure(this);
    }

    @Override
    protected void onResume() {
        super.onResume();

        // do some work
        presenter.fetchData();
    }

    @Override
    public void injectPresenter(StartContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void displayData(StartViewModel viewModel) {
        //Log.e(TAG, "displayData()");

        // deal with the data
        ((TextView) findViewById(R.id.data)).setText(viewModel.data);
    }
}
