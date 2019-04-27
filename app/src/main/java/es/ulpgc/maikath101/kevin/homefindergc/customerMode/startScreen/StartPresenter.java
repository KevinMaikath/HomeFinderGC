package es.ulpgc.maikath101.kevin.homefindergc.customerMode.startScreen;

import android.util.Log;

import java.lang.ref.WeakReference;
import java.util.List;

import es.ulpgc.maikath101.kevin.homefindergc.R;
import es.ulpgc.maikath101.kevin.homefindergc.data.House;
import es.ulpgc.maikath101.kevin.homefindergc.data.HouseRepositoryContract;

public class StartPresenter implements StartContract.Presenter {

  public static String TAG = StartPresenter.class.getSimpleName();

  private WeakReference<StartContract.View> view;
  private StartViewModel viewModel;
  private StartState state;
  private StartContract.Model model;
  private StartContract.Router router;

  public StartPresenter(StartState state) {
    viewModel = state;
    this.state = state;
  }

  @Override
  public void injectView(WeakReference<StartContract.View> view) {
    this.view = view;
  }

  @Override
  public void injectModel(StartContract.Model model) {
    this.model = model;
  }

  @Override
  public void injectRouter(StartContract.Router router) {
    this.router = router;
  }

  @Override
  public void fetchData() {
    // Log.e(TAG, "fetchData()");

    /**
     // set passed state
     StartState state = router.getDataFromPreviousScreen();
     if (state != null) {
     viewModel.data = state.data;
     }

     if (viewModel.data == null) {
     // call the model
     String data = model.fetchData();

     // set initial state
     viewModel.data = data;
     }
     **/
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
  public void goToHomeDetail() {
    router.navigateToHomeDetailScreen();
  }

  @Override
  public void fetchForSaleHousesData() {
// TODO   ajustar al nuevo repositorio
// model.fetchJSONData(new HouseRepositoryContract.FetchOnSaleHousesDataCallback() {
//      @Override
//      public void setOnSaleHouses(List<SaleHouse> saleHouses) {
//        viewModel.saleHouseList = saleHouses;
//
//        view.get().displayData(viewModel);
//      }
//    });
  }

  @Override
  public void fetchStartHousesData() {
    Log.e(TAG, "fetchData()");
    model.loadStartHouses(new HouseRepositoryContract.GetStartHousesCallback() {
      @Override
      public void setStartHouses(List<House> houses) {
        viewModel.houseList = houses;
        Log.e(TAG, "---------------CASAS GUARDADAS CORRECTAMENTE------------------");
        view.get().displayData(viewModel);
      }
    });
  }

  @Override
  public void fetchForRentHousesData() {

  }

  @Override
  public void fetchHolidayRentalHousesData() {

  }

  @Override
  public void checkCurrentScreen() {
    switch (state.currentScreen) {
      case "Start":
        viewModel.topText = R.string.start_label;
        // view.get().displayOnSaleHousesList(viewModel);
        break;
      case "ForSale":
        viewModel.topText = R.string.for_sale_label;
        // view.get().displayOnSaleHousesList(viewModel);
        break;
      case "ForRent":
        viewModel.topText = R.string.for_rent_label;
        // view.get().displayOnRentHousesList(viewModel);
        break;
      case "HolidayRental":
        viewModel.topText = R.string.holiday_rental_label;
        // view.get().displayOnHolidayRentalHousesList(viewModel);
        break;
    }
  }

  @Override
  public void selectHouse(House item) {
    //  TODO  pasar el item a homeDetail
    //  passDataTo...
    router.navigateToHomeDetailScreen();
  }
}
