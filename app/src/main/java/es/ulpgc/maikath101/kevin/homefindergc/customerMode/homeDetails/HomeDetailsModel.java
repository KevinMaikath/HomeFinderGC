package es.ulpgc.maikath101.kevin.homefindergc.customerMode.homeDetails;

import es.ulpgc.maikath101.kevin.homefindergc.data.House;
import es.ulpgc.maikath101.kevin.homefindergc.data.HouseRepository;
import es.ulpgc.maikath101.kevin.homefindergc.data.HouseRepositoryContract;
import es.ulpgc.maikath101.kevin.homefindergc.data.RentHouse;
import es.ulpgc.maikath101.kevin.homefindergc.data.SellHouse;

public class HomeDetailsModel implements HomeDetailsContract.Model {

  public static String TAG = HomeDetailsModel.class.getSimpleName();
  private HouseRepository repository;

  private House house;
  private SellHouse sellHouse;
  private RentHouse rentHouse;

  public HomeDetailsModel(HouseRepository repository) {
    this.repository = repository;
  }

  @Override
  public String getSummaryInfo() {
    String info = house.name + "\n\n"
            + "Precio: " + house.price + "\n\n"
            + "Ref: " + house.refNumber + "\n\n"
            + "Superficie: " + house.surface + " m2" + "\n\n"
            + "Habitaciones: " + house.rooms + "\n\n"
            + "Baños: " + house.bathrooms + "\n\n"
            + "Piscina: " + checkYesNo(house.pool) + "\n\n"
            + "Parking: " + house.parking + "\n\n"
            + "Tipo de suelo: " + house.floor_type + "\n\n"
            + getExtraInfo();

    return info;
  }

  private String getExtraInfo() {
    if (house.id_sell_type == 111) {
      return "Comunidad: " + sellHouse.community;
    } else {
      return "Admite animales: " + checkYesNo(rentHouse.animals) + "\n\n"
              + "Agua y luz: " + rentHouse.utilities;
    }
  }

  private String checkYesNo(Boolean b) {
    if (b) {
      return "Si";
    } else {
      return "No";
    }
  }

  @Override
  public House getHouse() {
    return house;
  }

  @Override
  public void setSellHouse(SellHouse sellHouse) {
    this.sellHouse = sellHouse;
  }

  @Override
  public void setRentHouse(RentHouse rentHouse) {
    this.rentHouse = rentHouse;
  }

  @Override
  public void setHouse(House house) {
    this.house = house;
  }

  @Override
  public void loadSellHouseInfo(final int current_house_id,
                                final HouseRepositoryContract.LoadCompleteSellHouseInfoCallback
                                        callback) {
    repository.loadHousesInformation(true,
            new HouseRepositoryContract.FetchHousesInformationCallback() {
              @Override
              public void onHousesInformationFetched(boolean error) {
                if (!error) {
                  repository.getCompleteSellInfo(current_house_id, callback);
                }
              }
            });
  }

  @Override
  public void loadRentHouseInfo(final int current_house_id,
                                final HouseRepositoryContract.LoadCompleteRentHouseInfoCallback
                                        callback) {
    repository.loadHousesInformation(true, new HouseRepositoryContract.FetchHousesInformationCallback() {
      @Override
      public void onHousesInformationFetched(boolean error) {
        if (!error) {
          repository.getCompleteRentInfo(current_house_id, callback);
        }
      }
    });
  }
}
