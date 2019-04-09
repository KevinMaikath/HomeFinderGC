package es.ulpgc.maikath101.kevin.homefindergc.data;

import java.util.List;

public class HolidayRentalHouse extends House {

  private String pricePerNight;

  public HolidayRentalHouse(String description, String referenceNumber, String image, int id, String name, int rooms, String location, boolean pool, int bathrooms, boolean parking, String community, String floor_type, int surface, List<ImageHouse> imagenes, String pricePerNight) {
    super(description, referenceNumber, image, id, name, rooms, location, pool, bathrooms, parking, community, floor_type, surface, imagenes);
    this.pricePerNight = pricePerNight;
  }

  public String getPricePerNight() {
    return pricePerNight;
  }

  public void setPricePerNight(String pricePerNight) {
    this.pricePerNight = pricePerNight;
  }
}
