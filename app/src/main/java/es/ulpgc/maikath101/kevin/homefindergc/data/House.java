package es.ulpgc.maikath101.kevin.homefindergc.data;

import java.util.List;

public class House {

  private String description;
  private String referenceNumber;
  private String image;
  private int id;
  private String name;
  private int rooms;
  private String location;
  private boolean pool;
  private int bathrooms;
  private boolean parking;
  private String community;
  private String floor_type;
  private int surface;
  private List<ImageHouse> imagenes;

  public House(String description, String referenceNumber, String image, int id, String name, int rooms, String location, boolean pool, int bathrooms, boolean parking, String community, String floor_type, int surface, List<ImageHouse> imagenes) {
    this.description = description;
    this.referenceNumber = referenceNumber;
    this.image = image;
    this.id = id;
    this.name = name;
    this.rooms = rooms;
    this.location = location;
    this.pool = pool;
    this.bathrooms = bathrooms;
    this.parking = parking;
    this.community = community;
    this.floor_type = floor_type;
    this.surface = surface;
    this.imagenes = imagenes;
  }

  public List<ImageHouse> getImagenes() {
    return imagenes;
  }

  public void setImagenes(List<ImageHouse> imagenes) {
    this.imagenes = imagenes;
  }

  public boolean isPool() {
    return pool;
  }

  public void setPool(boolean pool) {
    this.pool = pool;
  }

  public int getBathrooms() {
    return bathrooms;
  }

  public void setBathrooms(int bathrooms) {
    this.bathrooms = bathrooms;
  }

  public boolean isParking() {
    return parking;
  }

  public void setParking(boolean parking) {
    this.parking = parking;
  }

  public String getCommunity() {
    return community;
  }

  public void setCommunity(String community) {
    this.community = community;
  }

  public String getFloor_type() {
    return floor_type;
  }

  public void setFloor_type(String floor_type) {
    this.floor_type = floor_type;
  }

  public int getSurface() {
    return surface;
  }

  public void setSurface(int surface) {
    this.surface = surface;
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
