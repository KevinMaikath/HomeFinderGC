package es.ulpgc.maikath101.kevin.homefindergc.customerMode.homeDetails;

import java.lang.ref.WeakReference;

import es.ulpgc.maikath101.kevin.homefindergc.app.AppRouter;
import es.ulpgc.maikath101.kevin.homefindergc.data.House;
import es.ulpgc.maikath101.kevin.homefindergc.data.HouseRepositoryContract;
import es.ulpgc.maikath101.kevin.homefindergc.data.Image;

interface HomeDetailsContract {

  interface View {
    void injectPresenter(Presenter presenter);

    void displayData(HomeDetailsViewModel viewModel);

    void setImageList(HomeDetailsViewModel viewModel);
  }

  interface Presenter {
    void injectHomeDetailsView(WeakReference<View> view);

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

    void imageClicked(Image image);
  }

  interface Model {
    String fetchData();

    House getHouse();

    void setHouse(House house);

    String changeToSummaryInfo();

    String changeToDescriptionInfo();

    String changeToLocationInfo();

    String changeToDistributionInfo();

    void loadSellHouseInfo(int current_house_id, HouseRepositoryContract.LoadCompleteSellHouseInfoCallback loadCompleteSellHouseInfoCallback);

    void loadRentHouseInfo(int current_house_id, HouseRepositoryContract.LoadCompleteRentHouseInfoCallback loadCompleteRentHouseInfoCallback);
  }

  interface Router extends AppRouter {
    HomeDetailsState getDataFromStartScreen();
  }
}
