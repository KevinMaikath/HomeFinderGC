package es.ulpgc.maikath101.kevin.homefindergc.adminMode.addHouse;

import android.net.Uri;
import android.util.Log;

import java.lang.ref.WeakReference;

import android.support.v7.app.AppCompatActivity;
import android.support.v4.app.FragmentActivity;

import es.ulpgc.maikath101.kevin.homefindergc.data.House;
import es.ulpgc.maikath101.kevin.homefindergc.data.HouseRepository;
import es.ulpgc.maikath101.kevin.homefindergc.data.HouseRepositoryContract;
import es.ulpgc.maikath101.kevin.homefindergc.database.HouseDao;

public class AddHouseModel implements AddHouseContract.Model {

  public static String TAG = AddHouseModel.class.getSimpleName();

  private HouseRepositoryContract repository;

  public AddHouseModel(HouseRepositoryContract repository) {
    this.repository = repository;
  }

  @Override
  public void doneButtonPressed(String name, String location, String price, String description, Uri imageUri) {
   // House house = new House(0, 111, 1, )
  }
}
