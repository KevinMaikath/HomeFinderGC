package es.ulpgc.maikath101.kevin.homefindergc.data;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;

import static android.arch.persistence.room.ForeignKey.CASCADE;

@Entity(tableName = "house_rent")
public class RentHouse extends House{

  @PrimaryKey
  public final int id_house_rent;

  @ForeignKey(entity = House.class, parentColumns = "id_house",
          childColumns = "id_house", onDelete = CASCADE)
  public final int id_house;

  public final boolean animals;
  public final String utilities;

  public RentHouse(int id_house, int id_sell_type, int main_image, String refNumber,
                   String description, String name, String price, int rooms, String location, boolean pool,
                   int bathrooms, String parking, String floor_type, int surface, int id_house_rent,
                   boolean animals, String utilities) {
    super(id_house, id_sell_type, main_image, refNumber, description, name, price, rooms, location, pool,
            bathrooms, parking, floor_type, surface);
    this.id_house_rent = id_house_rent;
    this.id_house = id_house;
    this.animals = animals;
    this.utilities = utilities;
  }


}
