package es.ulpgc.maikath101.kevin.homefindergc.customerMode.contactScreen;

import java.lang.ref.WeakReference;

public class ContactPresenter implements ContactContract.Presenter {

  public static String TAG = ContactPresenter.class.getSimpleName();

  private WeakReference<ContactContract.View> view;
  private ContactViewModel viewModel;
  private ContactContract.Model model;
  private ContactContract.Router router;

  public ContactPresenter(ContactState state) {
    viewModel = state;
  }

  @Override
  public void injectView(WeakReference<ContactContract.View> view) {
    this.view = view;
  }

  @Override
  public void injectModel(ContactContract.Model model) {
    this.model = model;
  }

  @Override
  public void injectRouter(ContactContract.Router router) {
    this.router = router;
  }

  @Override
  public void fetchData() {
    // Log.e(TAG, "fetchData()");

    // set passed state

    // update the view
    view.get().displayData(viewModel);
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

  @Override
  public void onSendButtonPressed(String name, String telephone, String country,
                                  String zipcode, String address, String email,
                                  String subject, String bodyemail) {
    router.sendEmail(name, telephone, country, zipcode, address, email, subject, bodyemail);
  }

}
