package es.ulpgc.maikath101.kevin.homefindergc.data;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;
import android.net.Uri;

import static android.arch.persistence.room.ForeignKey.CASCADE;

@Entity(tableName = "images")
public class Image {

  @PrimaryKey(autoGenerate = true)
  public final int id_image;

  public final String url;

  @ForeignKey(entity = House.class, parentColumns = "id_house",
          childColumns = "id_house", onDelete = CASCADE)
  public final int id_house;

  public final String imageUri;

  public Image(int id_image, String url, int id_house, String imageUri) {
    this.id_image = id_image;
    this.url = url;
    this.id_house = id_house;
    this.imageUri = imageUri;
  }
}
