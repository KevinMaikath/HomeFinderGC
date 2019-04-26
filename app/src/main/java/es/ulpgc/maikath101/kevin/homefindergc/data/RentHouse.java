package es.ulpgc.maikath101.kevin.homefindergc.data;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;

import static android.arch.persistence.room.ForeignKey.CASCADE;

@Entity(tableName = "house_rent")
public class RentHouse{

  @PrimaryKey
  public final int id_house_rent;

  @ForeignKey(entity = House.class, parentColumns = "id_house",
          childColumns = "id_house", onDelete = CASCADE)
  public final int id_house;

  public final boolean animals;
  public final String utilities;

  public RentHouse(int id_house_rent, int id_house, boolean animals, String utilities) {
    this.id_house_rent = id_house_rent;
    this.id_house = id_house;
    this.animals = animals;
    this.utilities = utilities;
  }
}
