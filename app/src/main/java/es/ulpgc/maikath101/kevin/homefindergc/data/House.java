package es.ulpgc.maikath101.kevin.homefindergc.data;

public class House {

  private String description;
  private String referenceNumber;
  private String image;
  private int id;

  public House(int id, String description, String referenceNumber, String image) {
    this.id = id;
    this.description = description;
    this.referenceNumber = referenceNumber;
    this.image = image;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

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
}
