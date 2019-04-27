package es.ulpgc.maikath101.kevin.homefindergc.customerMode.startScreen;

import java.lang.ref.WeakReference;

import es.ulpgc.maikath101.kevin.homefindergc.app.AppRouter;
import es.ulpgc.maikath101.kevin.homefindergc.data.House;
import es.ulpgc.maikath101.kevin.homefindergc.data.HouseRepository;
import es.ulpgc.maikath101.kevin.homefindergc.data.HouseRepositoryContract;

interface StartContract {

  interface View {
    void injectPresenter(Presenter presenter);

    void displayData(StartViewModel viewModel);

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

    void checkCurrentScreen();

    void goToHomeDetail();

    void fetchStartHousesData();

    void fetchForSaleHousesData();

    void fetchForRentHousesData();

    void fetchHolidayRentalHousesData();

    void selectHouse(House item);
  }

  interface Model {
    //  TODO  adaptar para cada caso
    /**
    void fetchJSONData(HouseRepository.FetchOnSaleHousesDataCallback callback);
    void fetchOnRentHousesData(HouseRepository.FetchOnRentHousesDataCallback callback);
    void fetchOnHolidayRentalHousesData(HouseRepository.FetchOnHolidayRentalHousesDataCallback callback);
    void fetchForSaleHousesData(HouseRepository.FetchOnSaleHousesDataCallback callback);
     **/

    void loadStartHouses(HouseRepositoryContract.GetStartHousesCallback callback);
  }

  interface Router extends AppRouter {
    void navigateToHomeDetailScreen();

    void passDataToHomeDetailScreen(int id);
  }
}
