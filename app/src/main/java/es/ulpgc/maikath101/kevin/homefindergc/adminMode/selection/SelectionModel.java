package es.ulpgc.maikath101.kevin.homefindergc.adminMode.selection;

import android.util.Log;

import java.lang.ref.WeakReference;

import android.support.v7.app.AppCompatActivity;
import android.support.v4.app.FragmentActivity;

public class SelectionModel implements SelectionContract.Model {

    public static String TAG = SelectionModel.class.getSimpleName();

    public SelectionModel() {

    }

    @Override
    public String fetchData() {
        // Log.e(TAG, "fetchData()");
        return "Hello";
    }
}
