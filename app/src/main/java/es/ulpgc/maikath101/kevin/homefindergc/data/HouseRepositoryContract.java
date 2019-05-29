package es.ulpgc.maikath101.kevin.homefindergc.data;

import java.util.List;

public interface HouseRepositoryContract {

  /**
   * Callback que es llamado tras haber sido cargada la información de todas las viviendas del JSON
   */
  interface FetchHousesInformationCallback {
    void onHousesInformationFetched(boolean error);
  }

  /**
   * Callback que es llamado tras haber sido cargadas las casas del tipo HolidayRental
   */
  interface GetHolidayRentalHousesCallback {
    void setHolidayRentalHouses(List<House> houses);
  }

  /**
   * Callback que es llamado tras haber sido cargadas las casas del tipo RentHouses
   */
  interface GetForRentHousesCallback {
    void setForRentHouses(List<House> houses);
  }

  /**
   * Callback que es llamado tras haber sido cargadas las casas del tipo SaleHouses
   */
  interface GetForSaleHousesCallback {
    void setForSaleHouses(List<House> houses);
  }

  /**
   * Callback que es llamado tras haber sido cargadas todas las viviendas
   */
  interface GetAllHousesCallback {
    void setAllHouses(List<House> houses);
  }

  /**
   * Callback que es llamado tras haber sido cargada la imagen de una sola casa
   */
  interface GetImageFromHouseCallback {
    void setImage(Image image);
  }

  /**
   * Callback que es llamado tras haber sido cargadas las viviendas del activity StartHouses
   */
  interface GetStartHousesCallback {
    void setStartHouses(List<House> houses);
  }

  /**
   * Callback que es llamado cuando una vivienda es eliminada de la base de datos
   */
  interface OnHouseDeletedCallback {
    void houseDeleted();
  }

  /**
   * Callback que es llamado cuando se carga toda la información de una vivienda del tipo
   * SellHouse
   */
  interface LoadCompleteSellHouseInfoCallback {
    void setCompleteSellInfo(House house, List<Image> images, SellHouse sellHouse);
  }

  /**
   * Callback que es llamado cuando se carga toda la información de una vivienda del tipo
   * RentHouse
   */
  interface LoadCompleteRentHouseInfoCallback {
    void setCompleteRentInfo(House house, List<Image> images, RentHouse rentHouse);
  }

  /**
   * Callback que es llamado cuando una vivienda ha sido insertada en la base de datos
   */
  interface OnHouseInsertedCallback {
    void setHouseId(int houseId);
  }

  /**
   * Callback que es llamado cuando una imagen es insertada en la base de datos
   */
  interface OnImageInsertedCallback {
    void setImageId(int imageId);
  }

  /**
   * Callback que es llamado cuando una vivienda es completamente insertada en la base de datos
   */
  interface OnHouseCompleteleyInsertedCallback {
    void houseInserted();
  }

  /**
   * Se carga toda la información del JSON
   *
   * @param clearFirst: parámetro que indica si es la primera vez que se va a cargar del JSON
   * @param callback:   Método al que se llama cuando se carga la información del JSON
   */
  void loadHousesInformation(boolean clearFirst, HouseRepository.FetchHousesInformationCallback callback);

  /**
   * Se carga la información de las viviendas del tipo SaleHouses
   *
   * @param callback: Método al que se llama cuando se carga la información de las viviendas
   *                  SaleHouses
   */
  void getForSaleHouses(HouseRepositoryContract.GetForSaleHousesCallback callback);

  /**
   * Se carga la información de las viviendas del tipo RentHouses
   *
   * @param callback: Método al que se llama cuando se carga la información de las viviendas
   *                  RentHouses
   */
  void getForRentHouses(HouseRepositoryContract.GetForRentHousesCallback callback);

  /**
   * Se carga la información de las viviendas del tipo HolidayRental
   *
   * @param callback: Método al que se llama cuando se carga la información de las viviendas
   *                  *                RentalHouses
   */
  void getHolidayRentalHouses(HouseRepositoryContract.GetHolidayRentalHousesCallback callback);

  /**
   * Se carga la información de todas las viviendas
   *
   * @param callback: Método al que se llama cuando se carga la información de todas las
   *                  viviendas
   */
  void getAllHouses(HouseRepository.GetAllHousesCallback callback);

  /**
   * Se inserta una vivienda en la base de datos
   *
   * @param house:    Vivienda a insertar
   * @param callback: Método al que se llama cuando se inserta una vivienda
   */
  void insertHouse(House house, HouseRepository.OnHouseInsertedCallback callback);

  /**
   * Se consigue la imagen de una vivienda con id:
   *
   * @param id:       Id de la vivienda de la que se quiere conseguir la imagen
   * @param callback: Método al que se llama cuando se carga la imagen de la vivienda
   */
  void getImage(int id, HouseRepository.GetImageFromHouseCallback callback);

  /**
   * Se cargan todas las viviendas de la pantalla StartHouses
   *
   * @param callback: Método al que se llama cuando se cargan las viviendas de la pantalla
   *                  StartHouses
   */
  void getStartHouses(HouseRepository.GetStartHousesCallback callback);

  /**
   * Se elimina una vivienda con un determinado id
   *
   * @param id_house: Id de la vivienda a eliminar
   * @param callback: Método al que se llama cuando la vivienda es eliminada
   */
  void deleteHouse(int id_house, HouseRepository.OnHouseDeletedCallback callback);

  /**
   * Se consigue la información de una vivienda del tipo HouseSell
   *
   * @param id_house: Id de la vivienda
   * @param callback: Método al que se llama cuando se consigue la información de la vivienda
   */
  void getCompleteSellInfo(int id_house, HouseRepository.LoadCompleteSellHouseInfoCallback callback);

  /**
   * Se consigue la información de una vivienda del tipo RentHouse
   *
   * @param id_house: Id de la vivienda
   * @param callback: Método al que se llama cuando se consigue la información de la vivienda
   */
  void getCompleteRentInfo(int id_house, HouseRepository.LoadCompleteRentHouseInfoCallback callback);

  /**
   * Se inserta la imagen vinculada a una vivienda
   *
   * @param image:    Imagen de la vivienda que se quiere insertar
   * @param callback: Método al que se llama cuando la imagen es insertada en la base de datos
   */
  void insertImage(Image image, HouseRepository.OnImageInsertedCallback callback);

  /**
   * Se actualiza la imagen de una vivienda
   *
   * @param image: Imagen de la vivienda que se quiere actualizar
   */
  void updateImage(Image image);

  /**
   * Se actualizan los parámetros de una vivienda tras ser insertada
   *
   * @param house: Vivienda cuyos parámetros van a ser actualizados
   */
  void updateHouse(House house);

  /**
   * Se inserta una vivienda en la base de datos del tipo SellHouse
   *
   * @param sellHouse: Vivienda del tipo SellHouse
   */
  void insertSellHouse(SellHouse sellHouse);

}
