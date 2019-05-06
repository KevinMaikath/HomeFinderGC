package es.ulpgc.maikath101.kevin.homefindergc.adminMode.removeHouse;

import es.ulpgc.maikath101.kevin.homefindergc.data.HouseRepository;
import es.ulpgc.maikath101.kevin.homefindergc.data.HouseRepositoryContract;

public class RemoveHouseModel implements RemoveHouseContract.Model {

  public static String TAG = RemoveHouseModel.class.getSimpleName();

  private HouseRepositoryContract repository;

  public RemoveHouseModel(HouseRepositoryContract repository) {
    this.repository = repository;
  }

  @Override
  public String fetchData() {
    // Log.e(TAG, "fetchData()");
    return "Hello";
  }

  @Override
  public void loadAllHouses(final HouseRepositoryContract.GetAllHousesCallback callback) {
    repository.loadHousesInformation(true,
            new HouseRepositoryContract.FetchHousesInformationCallback() {
      @Override
      public void onHousesInformationFetched(boolean error) {
        if (!error) {
          repository.getAllHouses(callback);
        }
      }
    });
  }

  @Override
  public void loadImages(int id_image, HouseRepository.GetImageFromHouseCallback callback) {
    repository.getImage(id_image, callback);
  }

  @Override
  public void removeHouse(int id_house, HouseRepository.OnHouseDeletedCallback callback) {
    repository.deleteHouse(id_house, callback);
  }


}
