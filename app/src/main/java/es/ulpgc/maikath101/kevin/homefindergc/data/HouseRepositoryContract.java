package es.ulpgc.maikath101.kevin.homefindergc.data;

import java.util.List;

public interface HouseRepositoryContract {

  interface FetchHousesInformationCallback {
    void onHousesInformationFetched(boolean error);
  }

  interface GetRentHousesListCallback {
    void setRentHousesList(List<RentHouse> houses);
  }

  interface GetRentHouseCallback {
    void setRentHouse(RentHouse house);
  }

  interface GetSellHousesListCallback {
    void setSellHousesList(List<SellHouse> houses);
  }

  interface GetSellHouseCallback {
    void setSellHouse(SellHouse house);
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


  void loadHousesInformation(boolean clearFirst, HouseRepository.FetchHousesInformationCallback callback);

  void getRentHouseList(HouseRepository.GetRentHousesListCallback callback);

  void getRentHouse(int id, HouseRepository.GetRentHouseCallback callback);

  void getSellHouseList(HouseRepository.GetSellHousesListCallback callback);

  void getSellHouse(int id, HouseRepository.GetSellHouseCallback callback);

  void getAllHouses(HouseRepository.GetAllHousesCallback callback);

  void insertHouse(House house);

  void getImage(int id, HouseRepository.GetImageFromHouseCallback callback);

  void getStartHouses(HouseRepository.GetStartHousesCallback callback);

}
