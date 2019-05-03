package es.ulpgc.maikath101.kevin.homefindergc.customerMode.startScreen;

import android.app.Activity;
import android.content.Context;

import java.lang.ref.WeakReference;

import es.ulpgc.maikath101.kevin.homefindergc.app.AppRouter;
import es.ulpgc.maikath101.kevin.homefindergc.customerMode.drawer.DrawerContract;
import es.ulpgc.maikath101.kevin.homefindergc.customerMode.homeDetails.HomeDetailsState;
import es.ulpgc.maikath101.kevin.homefindergc.data.House;
import es.ulpgc.maikath101.kevin.homefindergc.data.HouseRepository;
import es.ulpgc.maikath101.kevin.homefindergc.data.HouseRepositoryContract;
import es.ulpgc.maikath101.kevin.homefindergc.data.SimpleHouse;

public interface StartContract {

  interface View{
    void injectPresenter(Presenter presenter);

    void displayData(StartViewModel viewModel);

  }

  interface Presenter{
    void injectStartView(WeakReference<View> view);

    void injectModel(Model model);

    void injectRouter(Router router);

    void fetchData();

    void checkCurrentScreen();

    void onBackPressed(Activity activity);

    void fetchStartHousesData();

    void fetchForSaleHousesData();

    void fetchForRentHousesData();

    void fetchHolidayRentalHousesData();

    void selectHouse(Context activity, SimpleHouse item);
  }

  interface Model {
    void loadStartHouses(HouseRepositoryContract.GetStartHousesCallback callback);

    void loadForSaleHouses(HouseRepositoryContract.GetForSaleHousesCallback callback);

    void loadForRentHouses(HouseRepositoryContract.GetForRentHousesCallback callback);

    void loadHolidayRentalHouses(HouseRepositoryContract.GetHolidayRentalHousesCallback callback);

    void loadImages(int id_image, HouseRepository.GetImageFromHouseCallback callback);
  }

  interface Router extends AppRouter {
    void navigateToHomeDetailScreen(Context activity);

    void passDataToHomeDetailScreen(HomeDetailsState state);
  }
}
