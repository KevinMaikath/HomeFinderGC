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
    void setRentHouse(House house);
  }

  interface GetSellHousesListCallback {
    void setSellHousesList(List<House> houses);
  }

  interface  GetSellHouseCallback {
    void setSellHouse(House house);
  }

  void loadHousesInformation(boolean clearFirst, HouseRepository.FetchHousesInformationCallback callback);

  void getRentHouseList(HouseRepository.GetRentHousesListCallback callback);

  void getRentHouse(int id, HouseRepository.GetRentHouseCallback callback);

  void getSellHouseList(HouseRepository.GetSellHousesListCallback callback);

  void getSellHouse(int id, HouseRepository.GetSellHouseCallback callback);

}
