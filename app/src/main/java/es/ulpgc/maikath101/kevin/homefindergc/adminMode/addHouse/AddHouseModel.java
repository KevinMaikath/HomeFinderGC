package es.ulpgc.maikath101.kevin.homefindergc.adminMode.addHouse;

import android.net.Uri;
import android.util.Log;
import es.ulpgc.maikath101.kevin.homefindergc.data.House;
import es.ulpgc.maikath101.kevin.homefindergc.data.HouseRepository;
import es.ulpgc.maikath101.kevin.homefindergc.data.HouseRepositoryContract;
import es.ulpgc.maikath101.kevin.homefindergc.data.Image;
import es.ulpgc.maikath101.kevin.homefindergc.data.SellHouse;

public class AddHouseModel implements AddHouseContract.Model {

  public static String TAG = AddHouseModel.class.getSimpleName();

  private HouseRepositoryContract repository;

  public AddHouseModel(HouseRepositoryContract repository) {
    this.repository = repository;
  }

  @Override
  public void doneButtonPressed(final String name, final String location, final String price, final String description,
                                final Uri imageUri, final HouseRepository.OnHouseCompleteleyInsertedCallback callback) {
    final double random = Math.random() * 100 + 17 % 3 * 87;
    final double random2 = Math.random() * 1823 + 79 % 10 * 8;

    final int intRandom = (int) Math.round(random) + (int) Math.round(random2);

    House house = new House(0, 111, 1, String.valueOf(intRandom) + "-OM", description, name,
            price, 4, location, false, 4, "", "", 0,"");


    repository.insertHouse(house, new HouseRepositoryContract.OnHouseInsertedCallback() {
      @Override
      public void setHouseId(final int houseId) {

        Log.e(TAG, String.valueOf(houseId));
        Image image = new Image(0, "", houseId, imageUri.toString());

        repository.insertImage(image, new HouseRepositoryContract.OnImageInsertedCallback() {
          @Override
          public void setImageId(int imageId) {
            // id_image[0] = imageId;
            Log.e(TAG, String.valueOf(imageId));

            House houseToInsert = new House((int) houseId, 111, imageId,
                    String.valueOf(intRandom) + "-OM", description, name, price, 4, location, false,
                    4, "", "", 0,"");

            repository.updateHouse(houseToInsert);

            Image imageToInsert = new Image((int) imageId, "", houseId, imageUri.toString());
            repository.updateImage(imageToInsert);

            SellHouse sellhouse = new SellHouse(0, houseId, "No tiene comunidad");
            repository.insertSellHouse(sellhouse);


            callback.houseInserted();
          }
        });

      }
    });
  }
}
