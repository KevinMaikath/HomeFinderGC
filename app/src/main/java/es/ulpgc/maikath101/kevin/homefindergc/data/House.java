package es.ulpgc.maikath101.kevin.homefindergc.data;

public class House {

  private String description;
  private String referenceNumber;
  private String image;
  private int id;
  private String name;
  private int rooms;
  private String location;

  public House(int id, String description, String referenceNumber, String image, String name, int rooms, String location) {
    this.id = id;
    this.description = description;
    this.referenceNumber = referenceNumber;
    this.image = image;
    this.name = name;
    this.rooms = rooms;
    this.location = location;
  }

  public String getLocation() {
    return location;
  }

  public void setLocation(String location) {
    this.location = location;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getRooms() {
    return rooms;
  }

  public void setRooms(int rooms) {
    this.rooms = rooms;
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
