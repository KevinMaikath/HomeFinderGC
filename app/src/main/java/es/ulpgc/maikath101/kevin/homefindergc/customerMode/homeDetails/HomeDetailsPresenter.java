package es.ulpgc.maikath101.kevin.homefindergc.customerMode.homeDetails;

import android.app.Activity;

import java.lang.ref.WeakReference;
import java.util.List;

import es.ulpgc.maikath101.kevin.homefindergc.customerMode.drawer.DrawerPresenter;
import es.ulpgc.maikath101.kevin.homefindergc.data.House;
import es.ulpgc.maikath101.kevin.homefindergc.data.HouseRepositoryContract;
import es.ulpgc.maikath101.kevin.homefindergc.data.Image;
import es.ulpgc.maikath101.kevin.homefindergc.data.RentHouse;
import es.ulpgc.maikath101.kevin.homefindergc.data.SellHouse;

public class HomeDetailsPresenter extends DrawerPresenter implements HomeDetailsContract.Presenter {

  public static String TAG = HomeDetailsPresenter.class.getSimpleName();

  private WeakReference<HomeDetailsContract.View> view;
  private HomeDetailsViewModel viewModel;
  private HomeDetailsContract.Model model;
  private HomeDetailsContract.Router router;

  public HomeDetailsPresenter(HomeDetailsState state) {
    viewModel = state;
  }

  @Override
  public void injectHomeDetailsView(WeakReference<HomeDetailsContract.View> view) {
    this.view = view;
  }

  @Override
  public void injectModel(HomeDetailsContract.Model model) {
    this.model = model;
  }

  @Override
  public void injectRouter(HomeDetailsContract.Router router) {
    this.router = router;
  }

  @Override
  public void fetchData() {
    // Log.e(TAG, "fetchData()");
    HomeDetailsState state = router.getDataFromStartScreen();
    if (viewModel.current_house != null) {
      model.setHouse(viewModel.current_house);

      if (viewModel.sellHouse != null) {
        model.setSellHouse(viewModel.sellHouse);
      } else if (viewModel.rentHouse != null) {
        model.setRentHouse(viewModel.rentHouse);
      }

      view.get().setImageList(viewModel);
      view.get().displayData(viewModel);

    } else if (state != null) {
      if (state.forSale) {
        model.loadSellHouseInfo(state.current_house_id, new HouseRepositoryContract.LoadCompleteSellHouseInfoCallback() {

          @Override
          public void setCompleteSellInfo(House house, List<Image> images, SellHouse sellHouse) {
            model.setHouse(house);
            model.setSellHouse(sellHouse);

            viewModel.current_house = house;
            viewModel.image_list = images;
            viewModel.current_image = viewModel.image_list.get(0);
            viewModel.sellHouse = sellHouse;

            viewModel.dataShown = model.getSummaryInfo();
            view.get().setImageList(viewModel);
            view.get().displayData(viewModel);
          }
        });
      } else {
        model.loadRentHouseInfo(state.current_house_id, new HouseRepositoryContract.LoadCompleteRentHouseInfoCallback() {

          @Override
          public void setCompleteRentInfo(House house, List<Image> images, RentHouse rentHouse) {
            model.setHouse(house);
            model.setRentHouse(rentHouse);

            viewModel.current_house = house;
            viewModel.image_list = images;
            viewModel.current_image = viewModel.image_list.get(0);
            viewModel.rentHouse = rentHouse;

            viewModel.dataShown = model.getSummaryInfo();
            view.get().setImageList(viewModel);
            view.get().displayData(viewModel);
          }
        });
      }
    }

  }

  @Override
  public void summaryButtonClicked() {
    viewModel.dataShown = model.getSummaryInfo();
    view.get().displayData(viewModel);
  }

  @Override
  public void descriptionButtonClicked() {
    viewModel.dataShown = model.getHouse().description;
    view.get().displayData(viewModel);
  }

  @Override
  public void locationButtonClicked() {
    viewModel.dataShown = model.getHouse().location;
    view.get().displayData(viewModel);
  }

  @Override
  public void distributionButtonClicked() {
    viewModel.dataShown = model.getHouse().distribution;
    view.get().displayData(viewModel);
  }

  @Override
  public void imageClicked(Image image) {
    viewModel.current_image = image;
    view.get().displayData(viewModel);
  }


  @Override
  public void onBackPressed(Activity activity) {
    activity.finish();
  }

}
