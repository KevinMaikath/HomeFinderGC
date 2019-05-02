package es.ulpgc.maikath101.kevin.homefindergc.customerMode.drawer;

import android.app.Activity;

import java.lang.ref.WeakReference;

import es.ulpgc.maikath101.kevin.homefindergc.app.AppRouter;

public class DrawerPresenter implements DrawerContract.Presenter{

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
  }

  @Override
  public void goToForSale(Activity activity) {
    router.navigateToForSaleScreen(activity);
  }

  @Override
  public void goToForRent(Activity activity) {
    router.navigateToForRentScreen(activity);
  }

  @Override
  public void goToHolidayRental(Activity activity) {
    router.navigateToHolidayRentalScreen(activity);
  }

  @Override
  public void goToAboutUS(Activity activity) {
    router.navigateToAboutUsScreen(activity);
  }

  @Override
  public void goToContact(Activity activity) {
    router.navigateToContactScreen(activity);
  }

}
