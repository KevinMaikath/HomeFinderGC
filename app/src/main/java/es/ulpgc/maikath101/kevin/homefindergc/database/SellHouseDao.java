package es.ulpgc.maikath101.kevin.homefindergc.database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;

import es.ulpgc.maikath101.kevin.homefindergc.data.SellHouse;

@Dao
public interface SellHouseDao {

  @Insert
  void insert(SellHouse sellHouse);

  @Delete
  void delete(SellHouse sellHouse);
}
