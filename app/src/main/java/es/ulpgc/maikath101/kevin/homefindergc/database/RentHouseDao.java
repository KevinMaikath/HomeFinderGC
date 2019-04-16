package es.ulpgc.maikath101.kevin.homefindergc.database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;

import es.ulpgc.maikath101.kevin.homefindergc.data.RentHouse;

@Dao
public interface RentHouseDao {

  @Insert
  void insert(RentHouse rentHouse);

  @Delete
  void delete(RentHouse rentHouse);
}
