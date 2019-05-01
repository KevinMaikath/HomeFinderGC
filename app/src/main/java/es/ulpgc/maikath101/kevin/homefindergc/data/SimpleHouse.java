package es.ulpgc.maikath101.kevin.homefindergc.data;

public class SimpleHouse {

  public int house_id;
  public String referenceNumber;
  public String apartmentName;
  public String imageURL;
  public String price;
  public int sell_type_id;

  public SimpleHouse(int house_id, String referenceNumber, String apartmentName, String imageURL, String price, int sell_type_id) {
    this.house_id = house_id;
    this.referenceNumber = referenceNumber;
    this.apartmentName = apartmentName;
    this.imageURL = imageURL;
    this.price = price;
    this.sell_type_id = sell_type_id;
  }
}
