package es.ulpgc.maikath101.kevin.homefindergc.app;

public class House {

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getReferenceNumber() {
    return referenceNumber;
  }

  public void setReferenceNumber(String referenceNumber) {
    this.referenceNumber = referenceNumber;
  }

  public String getImage() {
    return image;
  }

  public void setImage(String image) {
    this.image = image;
  }

  private String description;
  private String referenceNumber;
  private String image;

  public House(String description, String referenceNumber, String image) {
    this.description = description;
    this.referenceNumber = referenceNumber;
    this.image = image;
  }
}
