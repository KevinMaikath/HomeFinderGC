package es.ulpgc.maikath101.kevin.homefindergc.data;

public class RentHouse extends House {

  private String pricePerMonth;

  public RentHouse(int id, String description, String referenceNumber, String image, String name, int rooms, String location, String pricePerMonth) {
    super(id, description, referenceNumber, image, name, rooms, location);
    this.pricePerMonth = pricePerMonth;
  }

  public String getPricePerMonth() {
    return pricePerMonth;
  }

  public void setPricePerMonth(String pricePerMonth) {
    this.pricePerMonth = pricePerMonth;
  }
}
