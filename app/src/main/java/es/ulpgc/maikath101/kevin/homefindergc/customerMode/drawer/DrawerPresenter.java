package es.ulpgc.maikath101.kevin.homefindergc.customerMode.drawer;

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
  public void goToStart() {
    router.navigateToStartScreen();
  }

  @Override
  public void goToForSale() {
    router.navigateToForSaleScreen();
  }

  @Override
  public void goToForRent() {
    router.navigateToForRentScreen();
  }

  @Override
  public void goToHolidayRental() {
    router.navigateToHolidayRentalScreen();
  }

  @Override
  public void goToAboutUS() {
    router.navigateToAboutUsScreen();
  }

  @Override
  public void goToContact() {
    router.navigateToContactScreen();
  }

}
