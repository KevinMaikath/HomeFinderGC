package es.ulpgc.maikath101.kevin.homefindergc.data;

public class HolidayRentalHouse extends House {

  private String pricePerNight;

  public HolidayRentalHouse(int id, String description, String referenceNumber, String image, String name, int rooms, String location, String pricePerNight) {
    super(id, description, referenceNumber, image, name, rooms, location);
    this.pricePerNight = pricePerNight;
  }

  public String getPricePerNight() {
    return pricePerNight;
  }

  public void setPricePerNight(String pricePerNight) {
    this.pricePerNight = pricePerNight;
  }
}
