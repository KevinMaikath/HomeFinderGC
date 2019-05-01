package es.ulpgc.maikath101.kevin.homefindergc.data;

public class SimpleHouse {

  public int house_id;
  public String referenceNumber;
  public String apartmentName;
  public String imageURL;
  public String price;

  public SimpleHouse(int house_id, String referenceNumber, String apartmentName, String imageURL, String price) {
    this.house_id = house_id;
    this.referenceNumber = referenceNumber;
    this.apartmentName = apartmentName;
    this.imageURL = imageURL;
    this.price = price;
  }
}
