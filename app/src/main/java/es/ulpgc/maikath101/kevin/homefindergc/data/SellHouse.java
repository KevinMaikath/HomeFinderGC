package es.ulpgc.maikath101.kevin.homefindergc.data;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;

import static android.arch.persistence.room.ForeignKey.CASCADE;

@Entity(tableName = "house_sell")
public class SellHouse extends House{

  @PrimaryKey
  public final int id_house_sell;

  @ForeignKey(entity = House.class, parentColumns = "id_house",
          childColumns = "id_house", onDelete = CASCADE)
  public final int id_house;

  public final String community;

  public SellHouse(int id_house, int id_sell_type, int main_image, String refNumber,
                   String description, String name, String price, int rooms, String location, boolean pool,
                   int bathrooms, String parking, String floor_type, int surface, int id_house_sell,
                   String community) {
    super(id_house, id_sell_type, main_image, refNumber, description, name, price, rooms, location, pool,
            bathrooms, parking, floor_type, surface);
    this.id_house_sell = id_house_sell;
    this.id_house = id_house;
    this.community = community;
  }
}
