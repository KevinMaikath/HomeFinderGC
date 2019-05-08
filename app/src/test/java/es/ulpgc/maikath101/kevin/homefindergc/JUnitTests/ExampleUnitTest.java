package es.ulpgc.maikath101.kevin.homefindergc.JUnitTests;

import org.junit.Before;
import org.junit.Test;

import es.ulpgc.maikath101.kevin.homefindergc.data.SimpleHouse;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {

  @Test
  public void checkForSaleAsForSale() {
    SimpleHouse house = new SimpleHouse(1, "Ref", "name",
            "url", "price", 111, "uri");


    assertTrue();
  }
}