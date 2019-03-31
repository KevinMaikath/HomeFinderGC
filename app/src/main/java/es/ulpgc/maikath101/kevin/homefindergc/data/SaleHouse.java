package es.ulpgc.maikath101.kevin.homefindergc.data;

public class SaleHouse extends House {

  private String price;

  public SaleHouse(int id, String description, String referenceNumber, String image, String name, int rooms, String location, String price) {
    super(id, description, referenceNumber, image, name, rooms, location);
    this.price = price;
  }

  public String getPrice() {
    return price;
  }

  public void setPrice(String price) {
    this.price = price;
  }
}
