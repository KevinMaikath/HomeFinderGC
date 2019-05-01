package es.ulpgc.maikath101.kevin.homefindergc.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import es.ulpgc.maikath101.kevin.homefindergc.data.House;
import es.ulpgc.maikath101.kevin.homefindergc.data.Image;
import es.ulpgc.maikath101.kevin.homefindergc.data.RentHouse;
import es.ulpgc.maikath101.kevin.homefindergc.data.SellHouse;
import es.ulpgc.maikath101.kevin.homefindergc.data.Sell_type;

@Database(entities = {House.class, RentHouse.class, Sell_type.class, SellHouse.class, Image.class},
        version = 7)
public abstract class HousesDatabase extends RoomDatabase {

  private static final String DB_NAME = "houses.db";
  private static volatile HousesDatabase instance;

  public static HousesDatabase getInstance(Context context){
    if (instance == null){
      instance = create(context);
    }
    return instance;
  }

  private static HousesDatabase create(Context context){
    return Room.databaseBuilder(context, HousesDatabase.class, DB_NAME).fallbackToDestructiveMigration().build();
  }

  public abstract HouseDao getHouseDao();
  public abstract ImageDao getImageDao();
  public abstract RentHouseDao getRentHouseDao();
  public abstract Sell_typeDao getSell_typeDao();
  public abstract SellHouseDao getSellHouseDao();

}
