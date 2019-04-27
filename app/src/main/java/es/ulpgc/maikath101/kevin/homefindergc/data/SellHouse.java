package es.ulpgc.maikath101.kevin.homefindergc.data;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;

import static android.arch.persistence.room.ForeignKey.CASCADE;

@Entity(tableName = "house_sell")
public class SellHouse {

  @PrimaryKey(autoGenerate = true)
  public final int id_house_sell;

  @ForeignKey(entity = House.class, parentColumns = "id_house",
          childColumns = "id_house", onDelete = CASCADE)
  public final int id_house;

  public final String community;

  public SellHouse(int id_house_sell, int id_house, String community) {
    this.id_house_sell = id_house_sell;
    this.id_house = id_house;
    this.community = community;
  }
}
