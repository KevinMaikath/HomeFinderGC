package es.ulpgc.maikath101.kevin.homefindergc.adminMode.removeHouse;

import es.ulpgc.maikath101.kevin.homefindergc.data.HouseRepository;

public class RemoveHouseModel implements RemoveHouseContract.Model {

  public static String TAG = RemoveHouseModel.class.getSimpleName();

  private HouseRepository repository;

  public RemoveHouseModel() {
   // repository = HouseRepository.getInstance();
  }

  @Override
  public String fetchData() {
    // Log.e(TAG, "fetchData()");
    return "Hello";
  }


}
