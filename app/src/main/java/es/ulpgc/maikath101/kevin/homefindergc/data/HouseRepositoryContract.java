package es.ulpgc.maikath101.kevin.homefindergc.data;

public interface HouseRepositoryContract {

  interface FetchOnSaleHousesDataCallback {
    void setOnSaleHouses();
  }

  interface FetchOnRentHousesDataCallback {
    void setOnRentHouses();
  }

  interface FetchOnHolidayRentalHousesDataCallback {
    void setOnHolidayRentalHouses();
  }

  interface FetchHousesCatalogCallback {
    void onHousesCatalogLoaded(boolean error);
  }








}
