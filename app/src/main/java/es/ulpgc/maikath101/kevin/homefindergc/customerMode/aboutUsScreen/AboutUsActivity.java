package es.ulpgc.maikath101.kevin.homefindergc.customerMode.aboutUsScreen;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.widget.ImageView;
import android.widget.TextView;

import es.ulpgc.maikath101.kevin.homefindergc.R;
import es.ulpgc.maikath101.kevin.homefindergc.app.FlowTextHelper;

public class AboutUsActivity
        extends AppCompatActivity implements AboutUsContract.View {

    public static String TAG = AboutUsActivity.class.getSimpleName();

    private AboutUsContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);

        // do the setup
        AboutUsScreen.configure(this);

        ImageView thumbnailView = (ImageView) findViewById(R.id.imageView3);
        TextView messageView = (TextView) findViewById(R.id.textView2);
        String text = getString(R.string.about_us_info);

        Display display = getWindowManager().getDefaultDisplay();
        FlowTextHelper.tryFlowText(text, thumbnailView, messageView, display);
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

        // deal with the data
    }
}
