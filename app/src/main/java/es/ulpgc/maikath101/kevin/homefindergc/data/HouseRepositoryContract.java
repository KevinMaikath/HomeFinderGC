package es.ulpgc.maikath101.kevin.homefindergc.data;

import java.util.List;

public interface HouseRepositoryContract {

  interface FetchOnSaleHousesDataCallback {
    void setOnSaleHouses(List<SaleHouse> saleHouses);
  }

  interface FetchOnRentHousesDataCallback {
    void setOnRentHouses(List<RentHouse> rentHouses);
  }

  interface FetchOnHolidayRentalHousesDataCallback {
    void setOnHolidayRentalHouses(List<HolidayRentalHouse> holidayRentalHouses);
  }

  interface FetchHousesCatalogCallback {
    void onHousesCatalogLoaded(boolean error);
  }

  interface FetchOnSaleHouseDetailCallback {
    void setOnSaleHouseDetail(SaleHouse saleHouse);
  }

  interface FetchOnRentHouseDetailCallback {
    void setOnRentHouseDetail(RentHouse rentHouse);
  }

  interface FetchOnHolidayRentalHouseDetailCallback {
    void setOnHolidayRentalHouseDetail(HolidayRentalHouse holidayRentalHouse);
  }

  void fetchHousesCatalog(HouseRepository.FetchHousesCatalogCallback callback);
  void getOnSaleHousesList(HouseRepository.FetchOnSaleHousesDataCallback callback);
  void getOnRentHousesList(HouseRepository.FetchOnRentHousesDataCallback callback);
  void getOnHolidayRentalHousesList(HouseRepository.FetchOnHolidayRentalHousesDataCallback callback);

  void getOnSaleHouseDetail(int id, HouseRepository.FetchOnSaleHouseDetailCallback callback);
  void getOnRentHouseDetail(int id, HouseRepository.FetchOnRentHouseDetailCallback callback);
  void getOnHolidayRentalHouseDetail(int id, HouseRepository.FetchOnHolidayRentalHouseDetailCallback callback);

}
