package es.ulpgc.maikath101.kevin.homefindergc.adminMode.addHouse;

import android.net.Uri;
import android.util.Log;

import java.lang.ref.WeakReference;
import java.util.Random;

import android.support.v7.app.AppCompatActivity;
import android.support.v4.app.FragmentActivity;

import es.ulpgc.maikath101.kevin.homefindergc.data.House;
import es.ulpgc.maikath101.kevin.homefindergc.data.HouseRepository;
import es.ulpgc.maikath101.kevin.homefindergc.data.HouseRepositoryContract;
import es.ulpgc.maikath101.kevin.homefindergc.data.Image;
import es.ulpgc.maikath101.kevin.homefindergc.database.HouseDao;

public class AddHouseModel implements AddHouseContract.Model {

  public static String TAG = AddHouseModel.class.getSimpleName();

  private HouseRepositoryContract repository;

  public AddHouseModel(HouseRepositoryContract repository) {
    this.repository = repository;
  }

  @Override
  public void doneButtonPressed(String name, String location, String price, String description, Uri imageUri) {
    int random = (int) Math.random() / 10000;

    House house = new House(0, 111, 1, String.valueOf(random), description, name,
            price, 4, location, false, 4, "", "", 0);
    long id_house = repository.insertHouse(house);
    Image image = new Image(0, "", (int) id_house, imageUri.toString());
    long id_image = repository.insertImage(image);

    House houseToInsert = new House((int) id_house, 111, (int) id_image,
            String.valueOf(random), description, name, price, 4, location, false,
            4, "", "", 0);

    repository.updateHouse(houseToInsert);

    Image imageToInsert = new Image((int) id_image, "", (int) id_house, imageUri.toString());
    repository.updateImage(imageToInsert);
    Log.e(TAG, String.valueOf(id_house));
  }
}
