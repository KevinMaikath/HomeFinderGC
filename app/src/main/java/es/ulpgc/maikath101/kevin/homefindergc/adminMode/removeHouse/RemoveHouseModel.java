package es.ulpgc.maikath101.kevin.homefindergc.adminMode.removeHouse;

import android.util.Log;

import java.lang.ref.WeakReference;

import android.support.v7.app.AppCompatActivity;
import android.support.v4.app.FragmentActivity;

public class RemoveHouseModel implements RemoveHouseContract.Model {

  public static String TAG = RemoveHouseModel.class.getSimpleName();

  public RemoveHouseModel() {

  }

  @Override
  public String fetchData() {
    // Log.e(TAG, "fetchData()");
    return "Hello";
  }
}
