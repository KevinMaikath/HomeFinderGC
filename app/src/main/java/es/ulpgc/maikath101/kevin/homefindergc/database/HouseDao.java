package es.ulpgc.maikath101.kevin.homefindergc.database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

import es.ulpgc.maikath101.kevin.homefindergc.data.House;

@Dao
public interface HouseDao {

  @Insert
  void insert(House house);

  @Delete
  void delete(House house);

  @Query("SELECT * FROM houses WHERE id_sell_type=111")
  List<House> getForSaleHouses();

  @Query("SELECT * FROM houses WHERE id_sell_type=222")
  List<House> getForRentHouses();

  @Query("SELECT * FROM houses WHERE id_sell_type=333")
  List<House> getHolidayRentalHouses();
}
