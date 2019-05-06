package es.ulpgc.maikath101.kevin.homefindergc.database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import es.ulpgc.maikath101.kevin.homefindergc.data.SellHouse;

import java.util.List;

@Dao
public interface SellHouseDao {

  @Insert
  void insert(SellHouse sellHouse);

  @Delete
  void delete(SellHouse sellHouse);

  @Query("SELECT * FROM house_sell WHERE id_house=:id_house")
  SellHouse getSellHouse(int id_house);

  @Query("SELECT * FROM house_sell")
  List<SellHouse> getAllSellHouses();
}
