package es.ulpgc.maikath101.kevin.homefindergc.customerMode.contactScreen;

import java.lang.ref.WeakReference;

import es.ulpgc.maikath101.kevin.homefindergc.app.AppRouter;

interface ContactContract {

  interface View {
    void injectPresenter(Presenter presenter);

    void displayData(ContactViewModel viewModel);
  }

  interface Presenter {
    void injectContactView(WeakReference<View> view);

    void injectModel(Model model);

    void injectRouter(Router router);

    void fetchData();
    /**
    void goToStart();

    void goToForSale();

    void goToForRent();

    void goToHolidayRental();

    void goToAboutUS();

    void goToContact();
**/
    void onSendButtonPressed(String name, String telephone, String country,
                             String zipcode, String address, String email,
                             String subject, String bodyemail);
  }

  interface Model {
    String fetchData();
  }

  interface Router extends AppRouter {
    void sendEmail(String name, String telephone, String country,
                             String zipcode, String address, String email,
                             String subject, String bodyemail);
  }
}
