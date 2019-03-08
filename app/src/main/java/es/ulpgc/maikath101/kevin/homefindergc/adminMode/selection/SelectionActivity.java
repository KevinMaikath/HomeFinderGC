package es.ulpgc.maikath101.kevin.homefindergc.adminMode.selection;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import es.ulpgc.maikath101.kevin.homefindergc.R;

public class SelectionActivity
        extends AppCompatActivity implements SelectionContract.View {

    public static String TAG = SelectionActivity.class.getSimpleName();

    private SelectionContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selection);

        // do the setup
        SelectionScreen.configure(this);
    }

    @Override
    protected void onResume() {
        super.onResume();

        // do some work
        presenter.fetchData();
    }

    @Override
    public void injectPresenter(SelectionContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void displayData(SelectionViewModel viewModel) {
        //Log.e(TAG, "displayData()");

        // deal with the data
    }
}
