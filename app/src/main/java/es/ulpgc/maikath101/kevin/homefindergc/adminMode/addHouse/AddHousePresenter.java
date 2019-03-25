package es.ulpgc.maikath101.kevin.homefindergc.adminMode.addHouse;

import android.util.Log;

import java.lang.ref.WeakReference;

public class AddHousePresenter implements AddHouseContract.Presenter {

  public static String TAG = AddHousePresenter.class.getSimpleName();

  private WeakReference<AddHouseContract.View> view;
  private AddHouseViewModel viewModel;
  private AddHouseContract.Model model;
  private AddHouseContract.Router router;

  public AddHousePresenter(AddHouseState state) {
    viewModel = state;
  }

  @Override
  public void injectView(WeakReference<AddHouseContract.View> view) {
    this.view = view;
  }

  @Override
  public void injectModel(AddHouseContract.Model model) {
    this.model = model;
  }

  @Override
  public void injectRouter(AddHouseContract.Router router) {
    this.router = router;
  }

  @Override
  public void fetchData() {
    // Log.e(TAG, "fetchData()");

    // set passed state

    // update the view
    view.get().displayData(viewModel);

  }


}
