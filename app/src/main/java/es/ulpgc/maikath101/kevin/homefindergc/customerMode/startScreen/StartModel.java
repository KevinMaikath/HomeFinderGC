package es.ulpgc.maikath101.kevin.homefindergc.customerMode.startScreen;

import java.util.List;

import es.ulpgc.maikath101.kevin.homefindergc.data.HouseRepository;
import es.ulpgc.maikath101.kevin.homefindergc.data.HouseRepositoryContract;

public class StartModel implements StartContract.Model {

  public static String TAG = StartModel.class.getSimpleName();
  private HouseRepository repository;

  public StartModel(HouseRepository repository) {
    this.repository = repository;
  }


  //  TODO  adaptar al nuevo repositorio

  @Override
  public void loadStartHouses(final HouseRepositoryContract.GetStartHousesCallback callback) {
    repository.loadHousesInformation(true, new HouseRepositoryContract.FetchHousesInformationCallback() {
      @Override
      public void onHousesInformationFetched(boolean error) {
        if (!error) {
          repository.getStartHouses(callback);
        }
      }
    });
  }

}
