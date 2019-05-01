package es.ulpgc.maikath101.kevin.homefindergc.data;

import java.util.List;

public interface HouseRepositoryContract {

  interface FetchHousesInformationCallback {
    void onHousesInformationFetched(boolean error);
  }

  interface GetHolidayRentalHousesCallback {
    void setHolidayRentalHouses(List<House> houses);
  }

  interface GetForRentHousesCallback {
    void setForRentHouses(List<House> houses);
  }

  interface GetForSaleHousesCallback {
    void setForSaleHouses(List<House> houses);
  }

  interface GetAllHousesCallback {
    void setAllHouses(List<House> houses);
  }

  interface GetImageFromHouseCallback {
    void setImage(Image image);
  }

  interface GetStartHousesCallback {
    void setStartHouses(List<House> houses);
  }

  interface OnHouseDeletedCallback {
    void houseDeleted();
  }

  interface LoadCompleteSellHouseInfoCallback {
    void setCompleteSellInfo(House house, List<Image> images, SellHouse sellHouse);
  }

  interface LoadCompleteRentHouseInfoCallback {
    void setCompleteRentInfo(House house, List<Image> images, RentHouse rentHouse);
  }


  void loadHousesInformation(boolean clearFirst, HouseRepository.FetchHousesInformationCallback callback);

  void getForSaleHouses(HouseRepositoryContract.GetForSaleHousesCallback callback);

  void getForRentHouses(HouseRepositoryContract.GetForRentHousesCallback callback);

  void getHolidayRentalHouses(HouseRepositoryContract.GetHolidayRentalHousesCallback callback);

  void getAllHouses(HouseRepository.GetAllHousesCallback callback);

  void insertHouse(House house);

  void getImage(int id, HouseRepository.GetImageFromHouseCallback callback);

  void getStartHouses(HouseRepository.GetStartHousesCallback callback);

  void deleteHouse(int id_house, HouseRepository.OnHouseDeletedCallback callback);

  void getCompleteSellInfo(int id_house, HouseRepository.LoadCompleteSellHouseInfoCallback callback);

  void getCompleteRentInfo(int id_house, HouseRepository.LoadCompleteRentHouseInfoCallback callback);

}
