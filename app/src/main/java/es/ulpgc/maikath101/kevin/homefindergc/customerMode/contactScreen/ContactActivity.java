package es.ulpgc.maikath101.kevin.homefindergc.customerMode.contactScreen;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import es.ulpgc.maikath101.kevin.homefindergc.R;

public class ContactActivity
        extends AppCompatActivity implements ContactContract.View {

    public static String TAG = ContactActivity.class.getSimpleName();

    private ContactContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        // do the setup
        ContactScreen.configure(this);
    }

    @Override
    protected void onResume() {
        super.onResume();

        // do some work
        presenter.fetchData();
    }

    @Override
    public void injectPresenter(ContactContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void displayData(ContactViewModel viewModel) {
        //Log.e(TAG, "displayData()");

        // deal with the data
    }
}
