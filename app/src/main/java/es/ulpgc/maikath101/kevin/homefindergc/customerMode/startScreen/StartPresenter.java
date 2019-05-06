package es.ulpgc.maikath101.kevin.homefindergc.customerMode.startScreen;

import android.app.Activity;
import android.content.Context;
import android.util.Log;

import es.ulpgc.maikath101.kevin.homefindergc.R;
import es.ulpgc.maikath101.kevin.homefindergc.customerMode.drawer.DrawerPresenter;
import es.ulpgc.maikath101.kevin.homefindergc.customerMode.homeDetails.HomeDetailsState;
import es.ulpgc.maikath101.kevin.homefindergc.data.House;
import es.ulpgc.maikath101.kevin.homefindergc.data.HouseRepositoryContract;
import es.ulpgc.maikath101.kevin.homefindergc.data.Image;
import es.ulpgc.maikath101.kevin.homefindergc.data.SimpleHouse;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

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

    // update the view
    view.get().displayData(viewModel);

  }

  @Override
  public void fetchForSaleHousesData() {
    Log.e(TAG, "fetchData()");
    viewModel.topText = R.string.for_sale_label;
    model.loadForSaleHouses(new HouseRepositoryContract.GetForSaleHousesCallback() {
      @Override
      public void setForSaleHouses(final List<House> houses) {
        final ArrayList<SimpleHouse> simpleHouses = new ArrayList<>();
        for (int i = 0; i < houses.size(); i++) {
          final int finalI = i;
          model.loadImages(houses.get(i).main_image,
                  new HouseRepositoryContract.GetImageFromHouseCallback() {
                    @Override
                    public void setImage(Image image) {
                      SimpleHouse house = new SimpleHouse(houses.get(finalI).id_house,
                              houses.get(finalI).refNumber, houses.get(finalI).name,
                              image.url, houses.get(finalI).price, houses.get(finalI).id_sell_type,
                              image.imageUri);
                      Log.e(TAG, String.valueOf(image.url));
                      simpleHouses.add(house);
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
    viewModel.topText = R.string.start_label;
    model.loadStartHouses(new HouseRepositoryContract.GetStartHousesCallback() {
      @Override
      public void setStartHouses(final List<House> houses) {
        final ArrayList<SimpleHouse> simpleHouses = new ArrayList<>();
        for (int i = 0; i < houses.size(); i++) {
          final int finalI = i;
          model.loadImages(houses.get(i).main_image,
                  new HouseRepositoryContract.GetImageFromHouseCallback() {
            @Override
            public void setImage(Image image) {
              SimpleHouse house = new SimpleHouse(houses.get(finalI).id_house,
                      houses.get(finalI).refNumber, houses.get(finalI).name,
                      image.url, houses.get(finalI).price, houses.get(finalI).id_sell_type,
                      image.imageUri);
              Log.e(TAG, String.valueOf(image.url));
              simpleHouses.add(house);
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
    viewModel.topText = R.string.for_rent_label;
    model.loadForRentHouses(new HouseRepositoryContract.GetForRentHousesCallback() {
      @Override
      public void setForRentHouses(final List<House> houses) {
        //viewModel.simpleHouseList = houses;
        final ArrayList<SimpleHouse> simpleHouses = new ArrayList<>();
        for (int i = 0; i < houses.size(); i++) {
          final int finalI = i;
          model.loadImages(houses.get(i).main_image, new HouseRepositoryContract.GetImageFromHouseCallback() {
            @Override
            public void setImage(Image image) {
              SimpleHouse house = new SimpleHouse(houses.get(finalI).id_house,
                      houses.get(finalI).refNumber, houses.get(finalI).name,
                      image.url, houses.get(finalI).price, houses.get(finalI).id_sell_type,
                      image.imageUri);
              Log.e(TAG, String.valueOf(image.url));
              simpleHouses.add(house);
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
    viewModel.topText = R.string.holiday_rental_label;
    model.loadHolidayRentalHouses(new HouseRepositoryContract.GetHolidayRentalHousesCallback() {
      @Override
      public void setHolidayRentalHouses(final List<House> houses) {
        final ArrayList<SimpleHouse> simpleHouses = new ArrayList<>();
        for (int i = 0; i < houses.size(); i++) {
          final int finalI = i;
          model.loadImages(houses.get(i).main_image, new
                  HouseRepositoryContract.GetImageFromHouseCallback() {
            @Override
            public void setImage(Image image) {
              SimpleHouse house = new SimpleHouse(houses.get(finalI).id_house,
                      houses.get(finalI).refNumber, houses.get(finalI).name,
                      image.url, houses.get(finalI).price, houses.get(finalI).id_sell_type,
                      image.imageUri);
              Log.e(TAG, String.valueOf(image.url));
              simpleHouses.add(house);
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
    if (state.changedScreen) {
      switch (state.currentScreen) {
        case "Start":
          fetchStartHousesData();
          break;
        case "ForSale":
          fetchForSaleHousesData();
          break;
        case "ForRent":
          fetchForRentHousesData();
          break;
        case "HolidayRental":
          fetchHolidayRentalHousesData();
          break;
      }
      state.changedScreen = false;
    } else {
      view.get().displayData(viewModel);
    }
  }

  @Override
  public void selectHouse(Context activity, SimpleHouse item) {
    HomeDetailsState state = new HomeDetailsState();
    state.forSale = checkForSale(item);
    state.current_house_id = item.house_id;
    router.passDataToHomeDetailScreen(state);
    router.navigateToHomeDetailScreen(activity);
  }

  private boolean checkForSale(SimpleHouse house) {
    if (house.sell_type_id == 111) {
      return true;
    } else {
      return false;
    }
  }

  @Override
  public void onBackPressed(Activity activity) {
    if (state.currentScreen.equals("Start")) {
      activity.finish();
    } else {
      state.currentScreen = "Start";
      state.changedScreen = true;
      fetchStartHousesData();
    }
  }

}
