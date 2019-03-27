package es.ulpgc.maikath101.kevin.homefindergc.customerMode.aboutUsScreen;

import java.lang.ref.WeakReference;

import es.ulpgc.maikath101.kevin.homefindergc.app.AppRouter;

interface AboutUsContract {

  interface View {
    void injectPresenter(Presenter presenter);

    void displayData(AboutUsViewModel viewModel);
  }

  interface Presenter {
    void injectView(WeakReference<View> view);

    void injectModel(Model model);

    void injectRouter(Router router);

    void fetchData();

    void goToStart();

    void goToForSale();

    void goToForRent();

    void goToHolidayRental();

    void goToAboutUS();

    void goToContact();
  }

  interface Model {
    String fetchData();
  }

  interface Router extends AppRouter {

  }
}
