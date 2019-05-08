package es.ulpgc.maikath101.kevin.homefindergc.JUnitTests.customerModeTests.homeDetails;

import org.junit.Before;
import org.junit.Test;

import es.ulpgc.maikath101.kevin.homefindergc.customerMode.homeDetails.HomeDetailsActivity;
import es.ulpgc.maikath101.kevin.homefindergc.customerMode.homeDetails.HomeDetailsContract;
import es.ulpgc.maikath101.kevin.homefindergc.customerMode.homeDetails.HomeDetailsModel;
import es.ulpgc.maikath101.kevin.homefindergc.data.House;
import es.ulpgc.maikath101.kevin.homefindergc.data.HouseRepository;
import es.ulpgc.maikath101.kevin.homefindergc.data.SellHouse;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class HomeDetailsModelJUnitTest {

  private HomeDetailsContract.Model model;
  private House exampleHouse;

  @Before
  public void init() {
    HomeDetailsActivity activity = new HomeDetailsActivity();
    HouseRepository repository = HouseRepository.getInstance(activity);
    model = new HomeDetailsModel(repository);

    exampleHouse = new House(1, 111, 1, "a",
            "b", "c", "d", 1, "e", false,
            1, "f", "g", 10, "h");
    model.setHouse(exampleHouse);
  }

  @Test
  public void getHouse(){
    assertEquals(model.getHouse(), exampleHouse);
  }

  @Test
  public void setHouse() {
    House house = new House(22, 1, 1, "",
            "", "", "", 1, "", false,
            1, "", "", 10, "");
    model.setHouse(house);

    assertNotEquals(model.getHouse(), exampleHouse);
    assertEquals(model.getHouse(), house);
  }

  @Test
  public void getSummaryInfo(){
    SellHouse sellHouse = new SellHouse(1, 1, "x");
    model.setSellHouse(sellHouse);

    String info = "c\n\n"
            + "Precio: d\n\n"
            + "Ref: a\n\n"
            + "Superficie: 10 m2\n\n"
            + "Habitaciones: 1\n\n"
            + "Baños: 1\n\n"
            + "Piscina: No\n\n"
            + "Parking: f\n\n"
            + "Tipo de suelo: g\n\n"
            + "Comunidad: x";
    assertEquals(model.getSummaryInfo(), info);
  }

}