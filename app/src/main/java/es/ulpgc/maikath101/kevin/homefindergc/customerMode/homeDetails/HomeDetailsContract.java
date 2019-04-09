package es.ulpgc.maikath101.kevin.homefindergc.customerMode.homeDetails;

import java.lang.ref.WeakReference;

import es.ulpgc.maikath101.kevin.homefindergc.app.AppRouter;

interface HomeDetailsContract {

  interface View {
    void injectPresenter(Presenter presenter);

    void displayData(HomeDetailsViewModel viewModel);
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

    void summaryButtonClicked();

    void descriptionButtonClicked();

    void locationButtonClicked();

    void distributionButtonClicked();

  }

  interface Model {
    String fetchData();

    String changeToSummaryInfo();

    String changeToDescriptionInfo();

    String changeToLocationInfo();

    String changeToDistributionInfo();
  }

  interface Router extends AppRouter {
    int getDataFromStartScreen();
  }
}
