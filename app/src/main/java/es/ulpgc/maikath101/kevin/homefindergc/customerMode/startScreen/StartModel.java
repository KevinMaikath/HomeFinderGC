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
  /**
  @Override
  public void fetchJSONData(final HouseRepository.FetchOnSaleHousesDataCallback callback) {

    repository.fetchHousesCatalog(new HouseRepositoryContract.FetchHousesCatalogCallback() {
      @Override
      public void onHousesCatalogLoaded(boolean error) {
        if (!error) {
          repository.getOnSaleHousesList(callback);
        }
      }
    });
  }

  @Override
  public void fetchOnRentHousesData(final HouseRepository.FetchOnRentHousesDataCallback callback) {
    repository.getOnRentHousesList(new HouseRepositoryContract.FetchOnRentHousesDataCallback() {
      @Override
      public void setOnRentHouses(List<RentHouse> rentHouses) {
        callback.setOnRentHouses(rentHouses);
      }
    });
  }

  @Override
  public void fetchOnHolidayRentalHousesData(final HouseRepository.FetchOnHolidayRentalHousesDataCallback callback) {
    repository.getOnHolidayRentalHousesList(new HouseRepositoryContract.FetchOnHolidayRentalHousesDataCallback() {
      @Override
      public void setOnHolidayRentalHouses(List<HolidayRentalHouse> holidayRentalHouses) {
        callback.setOnHolidayRentalHouses(holidayRentalHouses);
      }
    });

  }

  @Override
  public void fetchOnSaleHousesData(final HouseRepository.FetchOnSaleHousesDataCallback callback) {
    repository.getOnSaleHousesList(new HouseRepositoryContract.FetchOnSaleHousesDataCallback() {
      @Override
      public void setOnSaleHouses(List<SaleHouse> saleHouses) {
        callback.setOnSaleHouses(saleHouses);
      }
    });
  }

  **/
}
