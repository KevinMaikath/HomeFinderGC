package es.ulpgc.maikath101.kevin.homefindergc.JUnitTests.customerModeTests.homeDetails;

import org.junit.Before;
import org.junit.Test;

import es.ulpgc.maikath101.kevin.homefindergc.customerMode.startScreen.StartContract;
import es.ulpgc.maikath101.kevin.homefindergc.customerMode.startScreen.StartPresenter;
import es.ulpgc.maikath101.kevin.homefindergc.customerMode.startScreen.StartState;
import es.ulpgc.maikath101.kevin.homefindergc.data.SimpleHouse;

public class HomeDetailsModelJUnitTest {

  private StartContract.Presenter presenter;

  @Before
  public void init() {
    StartState state = new StartState();
    presenter = new StartPresenter(state);
  }

  @Test
  public void checkForSaleAsForSale() {
    SimpleHouse house = new SimpleHouse(1, "Ref", "name",
            "url", "price", 111, "uri");

    // metodo privado jaja
    // assertTrue(presenter.chec);
  }
}