package es.ulpgc.maikath101.kevin.homefindergc.adminMode.removeHouse;

import android.util.Log;

import java.lang.ref.WeakReference;
import java.util.ArrayList;

import android.support.v7.app.AppCompatActivity;
import android.support.v4.app.FragmentActivity;

import es.ulpgc.maikath101.kevin.homefindergc.data.House;
import es.ulpgc.maikath101.kevin.homefindergc.data.HouseRepository;

public class RemoveHouseModel implements RemoveHouseContract.Model {

  public static String TAG = RemoveHouseModel.class.getSimpleName();

  private HouseRepository repository;

  public RemoveHouseModel() {
    repository = new HouseRepository();
  }

  @Override
  public String fetchData() {
    // Log.e(TAG, "fetchData()");
    return "Hello";
  }

  @Override
  public ArrayList<House> getHousess(){
    return repository.getHouses();
  }
}
