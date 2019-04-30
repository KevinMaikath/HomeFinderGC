package es.ulpgc.maikath101.kevin.homefindergc.customerMode.startScreen;

import android.util.Log;
import android.widget.ArrayAdapter;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

import es.ulpgc.maikath101.kevin.homefindergc.R;
import es.ulpgc.maikath101.kevin.homefindergc.customerMode.drawer.DrawerPresenter;
import es.ulpgc.maikath101.kevin.homefindergc.data.House;
import es.ulpgc.maikath101.kevin.homefindergc.data.HouseRepositoryContract;
import es.ulpgc.maikath101.kevin.homefindergc.data.Image;
import es.ulpgc.maikath101.kevin.homefindergc.data.SimpleHouse;

public class StartPresenter extends DrawerPresenter implements StartContract.Presenter {

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
  public void injectStartView(WeakReference<StartContract.View> view) {
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
  @Override
  public void goToHomeDetail() {
    router.navigateToHomeDetailScreen();
  }

  @Override
  public void fetchForSaleHousesData() {
    Log.e(TAG, "fetchData()");
    model.loadForSaleHouses(new HouseRepositoryContract.GetForSaleHousesCallback() {
      @Override
      public void setForSaleHouses(final List<House> houses) {
        //viewModel.simpleHouseList = houses;
        final ArrayList<SimpleHouse> simpleHouses = new ArrayList<>();
        for (int i = 0; i < houses.size(); i++){
          final int finalI = i;
          model.loadImages(houses.get(i).main_image,new HouseRepositoryContract.GetImageFromHouseCallback() {
            @Override
            public void setImage(Image image) {
              SimpleHouse house = new SimpleHouse(houses.get(finalI).refNumber, houses.get(finalI).name,
                      image.url, houses.get(finalI).price);
              Log.e(TAG, String.valueOf(image.url));
              simpleHouses.add(house);
              //viewModel.simpleHouses.add(house);
            }
          });
        }
        viewModel.simpleHouseList = simpleHouses;
        view.get().displayData(viewModel);
      }
    });
  }

  @Override
  public void fetchStartHousesData() {
    Log.e(TAG, "fetchData()");
    model.loadStartHouses(new HouseRepositoryContract.GetStartHousesCallback() {
      @Override
      public void setStartHouses(final List<House> houses) {
        //viewModel.simpleHouseList = houses;
        final ArrayList<SimpleHouse> simpleHouses = new ArrayList<>();
        for (int i = 0; i < houses.size(); i++){
          final int finalI = i;
          model.loadImages(houses.get(i).main_image,new HouseRepositoryContract.GetImageFromHouseCallback() {
            @Override
            public void setImage(Image image) {
              SimpleHouse house = new SimpleHouse(houses.get(finalI).refNumber, houses.get(finalI).name,
                      image.url, houses.get(finalI).price);
              Log.e(TAG, String.valueOf(image.url));
              simpleHouses.add(house);
              //viewModel.simpleHouses.add(house);
            }
          });
        }
        viewModel.simpleHouseList = simpleHouses;
        view.get().displayData(viewModel);
      }
    });
  }

  @Override
  public void fetchForRentHousesData() {
    Log.e(TAG, "fetchData()");
    model.loadForRentHouses(new HouseRepositoryContract.GetForRentHousesCallback() {
      @Override
      public void setForRentHouses(final List<House> houses) {
        //viewModel.simpleHouseList = houses;
        final ArrayList<SimpleHouse> simpleHouses = new ArrayList<>();
        for (int i = 0; i < houses.size(); i++){
          final int finalI = i;
          model.loadImages(houses.get(i).main_image,new HouseRepositoryContract.GetImageFromHouseCallback() {
            @Override
            public void setImage(Image image) {
              SimpleHouse house = new SimpleHouse(houses.get(finalI).refNumber, houses.get(finalI).name,
                      image.url, houses.get(finalI).price);
              Log.e(TAG, String.valueOf(image.url));
              simpleHouses.add(house);
              //viewModel.simpleHouses.add(house);
            }
          });
        }
        viewModel.simpleHouseList = simpleHouses;
        view.get().displayData(viewModel);
      }
    });
  }

  @Override
  public void fetchHolidayRentalHousesData() {
    Log.e(TAG, "fetchData()");
    model.loadHolidayRentalHouses(new HouseRepositoryContract.GetHolidayRentalHousesCallback() {
      @Override
      public void setHolidayRentalHouses(final List<House> houses) {
        //viewModel.simpleHouseList = houses;
        final ArrayList<SimpleHouse> simpleHouses = new ArrayList<>();
        for (int i = 0; i < houses.size(); i++){
          final int finalI = i;
          model.loadImages(houses.get(i).main_image,new HouseRepositoryContract.GetImageFromHouseCallback() {
            @Override
            public void setImage(Image image) {
              SimpleHouse house = new SimpleHouse(houses.get(finalI).refNumber, houses.get(finalI).name,
                      image.url, houses.get(finalI).price);
              Log.e(TAG, String.valueOf(image.url));
              simpleHouses.add(house);
              //viewModel.simpleHouses.add(house);
            }
          });
        }
        viewModel.simpleHouseList = simpleHouses;
        view.get().displayData(viewModel);
      }
    });
  }

  @Override
  public void checkCurrentScreen() {
    switch (state.currentScreen) {
      case "Start":
        viewModel.topText = R.string.start_label;
        fetchStartHousesData();
        break;
      case "ForSale":
        viewModel.topText = R.string.for_sale_label;
        fetchForSaleHousesData();
        break;
      case "ForRent":
        viewModel.topText = R.string.for_rent_label;
        fetchForRentHousesData();
        break;
      case "HolidayRental":
        viewModel.topText = R.string.holiday_rental_label;
        fetchHolidayRentalHousesData();
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
