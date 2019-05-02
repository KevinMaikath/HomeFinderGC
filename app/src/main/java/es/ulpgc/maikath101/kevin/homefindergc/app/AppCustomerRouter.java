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

    //cambiar estado a Start
    mediator.changeStartScreenLayout("Start");
    //context.startActivity(intent);
    activity.startActivity(intent);
  }

  @Override
  public void navigateToForSaleScreen(Activity activity) {
    Context context = mediator.getApplicationContext();
    Intent intent = new Intent(context, StartActivity.class);

    //cambiar estado a For Sale
    mediator.changeStartScreenLayout("ForSale");
    //context.startActivity(intent);
    activity.startActivity(intent);
  }

  @Override
  public void navigateToForRentScreen(Activity activity) {
    Context context = mediator.getApplicationContext();
    Intent intent = new Intent(context, StartActivity.class);

    //cambiar estado a For Rent
    mediator.changeStartScreenLayout("ForRent");
    //context.startActivity(intent);
    activity.startActivity(intent);
  }

  @Override
  public void navigateToHolidayRentalScreen(Activity activity) {
    Context context = mediator.getApplicationContext();
    Intent intent = new Intent(context, StartActivity.class);

    //cambiar estado a Holiday Rental
    mediator.changeStartScreenLayout("HolidayRental");
    //context.startActivity(intent);
    activity.startActivity(intent);
  }

  @Override
  public void navigateToAboutUsScreen(Activity activity) {
    Context context = mediator.getApplicationContext();
    Intent intent = new Intent(context, AboutUsActivity.class);
    //intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
    //context.startActivity(intent);
    activity.startActivity(intent);
  }

  @Override
  public void navigateToContactScreen(Activity activity) {
    Context context = mediator.getApplicationContext();
    Intent intent = new Intent(context, ContactActivity.class);
    //context.startActivity(intent);
    activity.startActivity(intent);
  }

}
