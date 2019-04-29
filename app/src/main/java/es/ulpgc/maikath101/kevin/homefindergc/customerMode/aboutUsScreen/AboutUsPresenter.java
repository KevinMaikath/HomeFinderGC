package es.ulpgc.maikath101.kevin.homefindergc.customerMode.aboutUsScreen;

import android.util.Log;

import java.lang.ref.WeakReference;

import es.ulpgc.maikath101.kevin.homefindergc.customerMode.drawer.DrawerPresenter;

public class AboutUsPresenter extends DrawerPresenter implements AboutUsContract.Presenter {

  public static String TAG = AboutUsPresenter.class.getSimpleName();

  private WeakReference<AboutUsContract.View> view;
  private AboutUsViewModel viewModel;
  private AboutUsContract.Model model;
  private AboutUsContract.Router router;

  public AboutUsPresenter(AboutUsState state) {
    viewModel = state;
  }

  @Override
  public void injectAboutUsView(WeakReference<AboutUsContract.View> view) {
    this.view = view;
  }

  @Override
  public void injectModel(AboutUsContract.Model model) {
    this.model = model;
  }

  @Override
  public void injectRouter(AboutUsContract.Router router) {
    this.router = router;
  }

  @Override
  public void fetchData() {
    // Log.e(TAG, "fetchData()");

    // set passed state
    // update the view
    view.get().displayData(viewModel);

  }

  /**
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
  **/

}
