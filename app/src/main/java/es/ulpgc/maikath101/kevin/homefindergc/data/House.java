package es.ulpgc.maikath101.kevin.homefindergc.data;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "houses")
public class House {

  @PrimaryKey
  public final int id_house;

  @ForeignKey(entity = Sell_type.class, parentColumns = "id_sell_type",
          childColumns = "id_sell_type")
  public final int id_sell_type;

  @ForeignKey(entity = Image.class, parentColumns = "id_image", childColumns = "main_image")
  public final int main_image;

  public final String refNumber;
  public final String description;
  public final String name;
  public final int rooms;
  public final String location;
  public final boolean pool;
  public final int bathrooms;
  public final String parking;
  public final String floor_type;
  public final int surface;

  public House(int id_house, int id_sell_type, int main_image, String refNumber,
               String description, String name, int rooms, String location,
               boolean pool, int bathrooms, String parking, String floor_type, int surface) {
    this.id_house = id_house;
    this.id_sell_type = id_sell_type;
    this.main_image = main_image;
    this.refNumber = refNumber;
    this.description = description;
    this.name = name;
    this.rooms = rooms;
    this.location = location;
    this.pool = pool;
    this.bathrooms = bathrooms;
    this.parking = parking;
    this.floor_type = floor_type;
    this.surface = surface;
  }
}
