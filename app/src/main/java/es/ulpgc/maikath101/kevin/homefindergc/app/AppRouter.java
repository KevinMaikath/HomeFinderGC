package es.ulpgc.maikath101.kevin.homefindergc.app;

import android.app.Activity;

public interface AppRouter {

  /**
   * Hace un intent a StartActivity, cambiando su pantalla actual a la de Inicio
   *
   * @param activity Activity desde la que realiza el intent
   */
  void navigateToStartScreen(Activity activity);

  /**
   * Hace un intent a StartActivity, cambiando su pantalla actual a la de Se vende
   *
   * @param activity Activity desde la que realiza el intent
   */
  void navigateToForSaleScreen(Activity activity);

  /**
   * Hace un intent a StartActivity, cambiando su pantalla actual a la de Se alquila
   *
   * @param activity Activity desde la que realiza el intent
   */
  void navigateToForRentScreen(Activity activity);

  /**
   * Hace un intent a StartActivity, cambiando su pantalla actual a la de Alquiler Vacacional
   *
   * @param activity Activity desde la que realiza el intent
   */
  void navigateToHolidayRentalScreen(Activity activity);

  /**
   * Hace un intent a AboutUsActivity, cambiando su pantalla actual a la de Alquiler Vacacional
   *
   * @param activity Activity desde la que realiza el intent
   */
  void navigateToAboutUsScreen(Activity activity);

  /**
   * Hace un intent a ContactActivity, cambiando su pantalla actual a la de Alquiler Vacacional
   *
   * @param activity Activity desde la que realiza el intent
   */
  void navigateToContactScreen(Activity activity);

}
