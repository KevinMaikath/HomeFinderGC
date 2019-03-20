package es.ulpgc.maikath101.kevin.homefindergc.customerMode.startScreen;

import android.util.Log;

import java.lang.ref.WeakReference;

import android.support.v7.app.AppCompatActivity;
import android.support.v4.app.FragmentActivity;

public class StartModel implements StartContract.Model {

  public static String TAG = StartModel.class.getSimpleName();

  public StartModel() {

  }

  @Override
  public String fetchData() {
    // Log.e(TAG, "fetchData()");
    return "Hello";
  }
}
