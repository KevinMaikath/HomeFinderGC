package es.ulpgc.maikath101.kevin.homefindergc.app;

import android.app.Activity;

public interface AppRouter {

  void navigateToStartScreen(Activity activity);

  void navigateToForSaleScreen(Activity activity);

  void navigateToForRentScreen(Activity activity);

  void navigateToHolidayRentalScreen(Activity activity);

  void navigateToAboutUsScreen(Activity activity);

  void navigateToContactScreen(Activity activity);

}
