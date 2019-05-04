package es.ulpgc.maikath101.kevin.homefindergc.customerMode.homeDetails;

import java.util.ArrayList;
import java.util.List;

import es.ulpgc.maikath101.kevin.homefindergc.data.House;
import es.ulpgc.maikath101.kevin.homefindergc.data.Image;
import es.ulpgc.maikath101.kevin.homefindergc.data.RentHouse;
import es.ulpgc.maikath101.kevin.homefindergc.data.SellHouse;

public class HomeDetailsViewModel {

  public String dataShown;
  public List<Image> image_list = new ArrayList<>();
  public House current_house;
  public Image current_image;
  public SellHouse sellHouse;
  public RentHouse rentHouse;

}
