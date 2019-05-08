package es.ulpgc.maikath101.kevin.homefindergc.customerMode.homeDetails;

import es.ulpgc.maikath101.kevin.homefindergc.app.AppRouter;
import es.ulpgc.maikath101.kevin.homefindergc.data.House;
import es.ulpgc.maikath101.kevin.homefindergc.data.HouseRepositoryContract;
import es.ulpgc.maikath101.kevin.homefindergc.data.Image;
import es.ulpgc.maikath101.kevin.homefindergc.data.RentHouse;
import es.ulpgc.maikath101.kevin.homefindergc.data.SellHouse;

import java.lang.ref.WeakReference;


public interface HomeDetailsContract {

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

    void summaryButtonClicked();

    void descriptionButtonClicked();

    void locationButtonClicked();

    void distributionButtonClicked();

    void imageClicked(Image image);
  }

  interface Model {
    String getSummaryInfo();

    House getHouse();

    void setSellHouse(SellHouse sellHouse);

    void setRentHouse(RentHouse rentHouse);

    void setHouse(House house);

    void loadSellHouseInfo(int current_house_id,
                           HouseRepositoryContract.LoadCompleteSellHouseInfoCallback
                                   loadCompleteSellHouseInfoCallback);

    void loadRentHouseInfo(int current_house_id,
                           HouseRepositoryContract.LoadCompleteRentHouseInfoCallback
                                   loadCompleteRentHouseInfoCallback);
  }

  interface Router extends AppRouter {
    HomeDetailsState getDataFromStartScreen();
  }
}
