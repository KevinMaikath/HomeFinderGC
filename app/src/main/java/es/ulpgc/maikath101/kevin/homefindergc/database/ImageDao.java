package es.ulpgc.maikath101.kevin.homefindergc.database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

import es.ulpgc.maikath101.kevin.homefindergc.data.Image;

@Dao
public interface ImageDao {

  @Insert
  void insert(Image image);

  @Delete
  void delete(Image image);

  @Query("SELECT * FROM images WHERE id_house=:id_house")
  List<Image> getImages(int id_house);


}
