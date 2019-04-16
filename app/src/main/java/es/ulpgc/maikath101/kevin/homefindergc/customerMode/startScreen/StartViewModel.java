package es.ulpgc.maikath101.kevin.homefindergc.customerMode.startScreen;

import java.util.List;

import es.ulpgc.maikath101.kevin.homefindergc.R;

public class StartViewModel {

  public int topText = R.string.start_label;
  public List<SaleHouse> saleHouseList;
  public List<RentHouse> rentHouseList;
  public List<HolidayRentalHouse> holidayRentalHousesList;

  // TODO cambiar el viewModel para que solo tenga la lista que debe presentar en pantalla
  //public List<House> houseList;
}
