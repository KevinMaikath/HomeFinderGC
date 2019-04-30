package es.ulpgc.maikath101.kevin.homefindergc.data;

public class SimpleHouse {

  public String referenceNumber;
  public String apartmentName;
  public String imageURL;
  public String price;

  public SimpleHouse(String referenceNumber, String apartmentName, String imageURL, String price) {
    this.referenceNumber = referenceNumber;
    this.apartmentName = apartmentName;
    this.imageURL = imageURL;
    this.price = price;
  }
}