package es.ulpgc.maikath101.kevin.homefindergc.data;

import java.util.ArrayList;

public class HouseRepository {

  private ArrayList<House> houses;
  private int COUNT = 20;
  private static HouseRepository instance = null;

  private HouseRepository() {
    houses = new ArrayList<House>();
    for (int i = 1; i < COUNT; i++) {
      addHouse(createHouse(i));
    }
  }

  public static HouseRepository getInstance(){
    if(instance == null){
      instance = new HouseRepository();
    }
    return instance;
  }

  private House createHouse(int position) {
    String description = "Descripcion: " + position;
    String referenceNumber = "Reference: " + position;
    return new House(position, description, referenceNumber, "");
  }

  private void addHouse(House house) {
    this.houses.add(house);
  }

  public ArrayList<House> getHouses(){
    return this.houses;
  }


}
