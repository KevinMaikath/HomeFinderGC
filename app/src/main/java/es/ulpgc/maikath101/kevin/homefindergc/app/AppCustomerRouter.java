package es.ulpgc.maikath101.kevin.homefindergc.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

import es.ulpgc.maikath101.kevin.homefindergc.customerMode.aboutUsScreen.AboutUsActivity;
import es.ulpgc.maikath101.kevin.homefindergc.customerMode.contactScreen.ContactActivity;
import es.ulpgc.maikath101.kevin.homefindergc.customerMode.startScreen.StartActivity;
import es.ulpgc.maikath101.kevin.homefindergc.customerMode.startScreen.StartState;

public class AppCustomerRouter implements AppRouter {

  protected AppMediator mediator;

  public AppCustomerRouter(AppMediator mediator) {
    this.mediator = mediator;
  }

  @Override
  public void navigateToStartScreen(Activity activity) {
    Context context = mediator.getApplicationContext();
    Intent intent = new Intent(context, StartActivity.class);

    //cambia estado a Start
    mediator.changeStartScreenLayout("Start");
    activity.startActivity(intent);
  }

  @Override
  public void navigateToForSaleScreen(Activity activity) {
    Context context = mediator.getApplicationContext();
    Intent intent = new Intent(context, StartActivity.class);

    //cambia estado a For Sale
    mediator.changeStartScreenLayout("ForSale");
    activity.startActivity(intent);
  }

  @Override
  public void navigateToForRentScreen(Activity activity) {
    Context context = mediator.getApplicationContext();
    Intent intent = new Intent(context, StartActivity.class);

    //cambia estado a For Rent
    mediator.changeStartScreenLayout("ForRent");
    activity.startActivity(intent);
  }

  @Override
  public void navigateToHolidayRentalScreen(Activity activity) {
    Context context = mediator.getApplicationContext();
    Intent intent = new Intent(context, StartActivity.class);

    //cambia estado a Holiday Rental
    mediator.changeStartScreenLayout("HolidayRental");
    activity.startActivity(intent);
  }

  @Override
  public void navigateToAboutUsScreen(Activity activity) {
    Context context = mediator.getApplicationContext();
    Intent intent = new Intent(context, AboutUsActivity.class);
    activity.startActivity(intent);
  }

  @Override
  public void navigateToContactScreen(Activity activity) {
    Context context = mediator.getApplicationContext();
    Intent intent = new Intent(context, ContactActivity.class);
    activity.startActivity(intent);
  }

}
