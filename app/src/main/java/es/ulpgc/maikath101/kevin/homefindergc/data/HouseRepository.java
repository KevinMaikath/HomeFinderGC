package es.ulpgc.maikath101.kevin.homefindergc.data;

import java.util.ArrayList;

public class HouseRepository {

  private static HouseRepository instance = null;

  public static HouseRepository getInstance(){
    if(instance == null){
      instance = new HouseRepository();
    }
    return instance;
  }


}
