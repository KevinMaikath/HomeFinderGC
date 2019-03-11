package es.ulpgc.maikath101.kevin.homefindergc.customerMode.homeDetails;

import android.util.Log;

import java.lang.ref.WeakReference;

import android.support.v7.app.AppCompatActivity;
import android.support.v4.app.FragmentActivity;

public class HomeDetailsModel implements HomeDetailsContract.Model {

    public static String TAG = HomeDetailsModel.class.getSimpleName();

    public HomeDetailsModel() {

    }

    @Override
    public String fetchData() {
        // Log.e(TAG, "fetchData()");
        return "Hello";
    }
}
