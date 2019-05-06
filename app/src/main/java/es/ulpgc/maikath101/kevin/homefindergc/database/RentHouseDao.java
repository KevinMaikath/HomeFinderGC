package es.ulpgc.maikath101.kevin.homefindergc.database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

import es.ulpgc.maikath101.kevin.homefindergc.data.RentHouse;

@Dao
public interface RentHouseDao {

  @Insert
  void insert(RentHouse rentHouse);

  @Delete
  void delete(RentHouse rentHouse);

  @Query("SELECT * FROM house_rent WHERE id_house=:id_house")
  RentHouse getRentHouse(int id_house);

  @Query("SELECT * FROM house_rent")
  List<RentHouse> getAllRentHouses();
}
