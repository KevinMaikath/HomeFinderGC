package es.ulpgc.maikath101.kevin.homefindergc.adminMode.removeHouse;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

import es.ulpgc.maikath101.kevin.homefindergc.data.House;
import es.ulpgc.maikath101.kevin.homefindergc.data.HouseRepositoryContract;

public class RemoveHousePresenter implements RemoveHouseContract.Presenter {

  public static String TAG = RemoveHousePresenter.class.getSimpleName();

  private WeakReference<RemoveHouseContract.View> view;
  private RemoveHouseViewModel viewModel;
  private RemoveHouseContract.Model model;
  private RemoveHouseContract.Router router;

  public RemoveHousePresenter(RemoveHouseState state) {
    viewModel = state;
  }

  @Override
  public void injectView(WeakReference<RemoveHouseContract.View> view) {
    this.view = view;
  }

  @Override
  public void injectModel(RemoveHouseContract.Model model) {
    this.model = model;
  }

  @Override
  public void injectRouter(RemoveHouseContract.Router router) {
    this.router = router;
  }

  @Override
  public void loadAllHouses() {
    model.loadAllHouses(new HouseRepositoryContract.GetAllHousesCallback() {
      @Override
      public void setAllHouses(List<House> houses) {
        viewModel.houses = houses;

        view.get().displayData(viewModel);
      }
    });

  }


}
