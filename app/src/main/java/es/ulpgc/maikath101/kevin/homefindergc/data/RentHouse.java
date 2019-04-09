package es.ulpgc.maikath101.kevin.homefindergc.data;

import java.util.List;

public class RentHouse extends House {

  private String pricePerMonth;

  public RentHouse(String description, String referenceNumber, String image, int id, String name, int rooms, String location, boolean pool, int bathrooms, boolean parking, String community, String floor_type, int surface, List<ImageHouse> imagenes, String pricePerMonth) {
    super(description, referenceNumber, image, id, name, rooms, location, pool, bathrooms, parking, community, floor_type, surface, imagenes);
    this.pricePerMonth = pricePerMonth;
  }

  public String getPricePerMonth() {
    return pricePerMonth;
  }

  public void setPricePerMonth(String pricePerMonth) {
    this.pricePerMonth = pricePerMonth;
  }
}
