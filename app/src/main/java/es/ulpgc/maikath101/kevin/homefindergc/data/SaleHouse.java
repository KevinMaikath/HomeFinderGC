package es.ulpgc.maikath101.kevin.homefindergc.data;

public class SaleHouse extends House {

  private String price;

  public SaleHouse(String description, String referenceNumber, String image, int id, String name, int rooms, String location, boolean pool, int bathrooms, boolean parking, String community, String floor_type, int surface) {
    super(description, referenceNumber, image, id, name, rooms, location, pool, bathrooms, parking, community, floor_type, surface);
  }


  public String getPrice() {
    return price;
  }

  public void setPrice(String price) {
    this.price = price;
  }
}
