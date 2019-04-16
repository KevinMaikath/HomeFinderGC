package es.ulpgc.maikath101.kevin.homefindergc.data;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "sell_type")
public class Sell_type {

  @PrimaryKey
  public final int id_sell_type;

  public final String type;

  public Sell_type(int id_sell_type, String type) {
    this.id_sell_type = id_sell_type;
    this.type = type;
  }
}
