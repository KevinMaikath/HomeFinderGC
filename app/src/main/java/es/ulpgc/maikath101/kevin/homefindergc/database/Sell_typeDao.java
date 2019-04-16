package es.ulpgc.maikath101.kevin.homefindergc.database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;

import es.ulpgc.maikath101.kevin.homefindergc.data.Sell_type;

@Dao
public interface Sell_typeDao {

  @Insert
  void insert(Sell_type sell_type);

  @Delete
  void delete(Sell_type sell_type);
}
