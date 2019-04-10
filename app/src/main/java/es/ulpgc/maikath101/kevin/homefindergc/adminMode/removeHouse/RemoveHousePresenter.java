package es.ulpgc.maikath101.kevin.homefindergc.adminMode.removeHouse;

import android.util.Log;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

import es.ulpgc.maikath101.kevin.homefindergc.data.HolidayRentalHouse;
import es.ulpgc.maikath101.kevin.homefindergc.data.House;
import es.ulpgc.maikath101.kevin.homefindergc.data.ImageHouse;

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
  public void fetchData() {
    // Log.e(TAG, "fetchData()");

    // set passed state
    // viewModel.houses = model.getHousess();
    // update the view
    List<House> houses = new ArrayList<>();
    houses.add(0,new HolidayRentalHouse("","","",1,"",2,
            "",true,2,false,"","",20
    ,new ArrayList<ImageHouse>(),""));

    viewModel.houses = houses;
    view.get().displayData(viewModel);
  }


}
