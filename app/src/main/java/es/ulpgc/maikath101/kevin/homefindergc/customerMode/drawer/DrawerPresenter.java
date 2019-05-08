package es.ulpgc.maikath101.kevin.homefindergc.customerMode.drawer;

import android.app.Activity;
import android.util.Log;

import java.lang.ref.WeakReference;

import es.ulpgc.maikath101.kevin.homefindergc.app.AppRouter;
import es.ulpgc.maikath101.kevin.homefindergc.customerMode.startScreen.StartActivity;

public class DrawerPresenter implements DrawerContract.Presenter {

  private WeakReference<DrawerContract.View> view;
  private AppRouter router;


  public DrawerPresenter() {

  }

  @Override
  public void injectView(WeakReference<DrawerContract.View> view) {
    this.view = view;
  }

  @Override
  public void injectRouter(AppRouter router) {
    this.router = router;
  }

  @Override
  public void goToStart(Activity activity) {
    router.navigateToStartScreen(activity);
    activity.finish();
  }

  @Override
  public void goToForSale(Activity activity) {
    router.navigateToForSaleScreen(activity);
    activity.finish();
  }

  @Override
  public void goToForRent(Activity activity) {
    router.navigateToForRentScreen(activity);
    activity.finish();
  }

  @Override
  public void goToHolidayRental(Activity activity) {
    router.navigateToHolidayRentalScreen(activity);
    activity.finish();
  }

  @Override
  public void goToAboutUs(Activity activity) {
    router.navigateToAboutUsScreen(activity);
    activity.finish();
  }

  @Override
  public void goToContact(Activity activity) {
    router.navigateToContactScreen(activity);
    //Log.e(this.getClass().getSimpleName(),  activity.toString());
    activity.finish();
  }

  @Override
  public void onBackPressed(Activity activity) {
    router.navigateToStartScreen(activity);
    activity.finish();
  }
}
