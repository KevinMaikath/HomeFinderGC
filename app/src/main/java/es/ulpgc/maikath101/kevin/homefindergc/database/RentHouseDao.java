package es.ulpgc.maikath101.kevin.homefindergc.database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import es.ulpgc.maikath101.kevin.homefindergc.data.House;
import es.ulpgc.maikath101.kevin.homefindergc.data.RentHouse;

@Dao
public interface RentHouseDao {

  @Insert
  void insert(RentHouse rentHouse);

  @Delete
  void delete(RentHouse rentHouse);

  @Query("SELECT * FROM houses WHERE id_house=:id_house")
  RentHouse getRentHouse(int id_house);
}
