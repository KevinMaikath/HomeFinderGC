package es.ulpgc.maikath101.kevin.homefindergc.customerMode.aboutUsScreen;

import android.util.Log;

import java.lang.ref.WeakReference;

import android.support.v7.app.AppCompatActivity;
import android.support.v4.app.FragmentActivity;

public class AboutUsModel implements AboutUsContract.Model {

    public static String TAG = AboutUsModel.class.getSimpleName();

    public AboutUsModel() {

    }

    @Override
    public String fetchData() {
        // Log.e(TAG, "fetchData()");
        return "Hello";
    }
}
