package es.ulpgc.maikath101.kevin.homefindergc.adminMode.addHouse;

import android.net.Uri;
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
  public void saveImageFromRotation(Uri imageUri) {
    viewModel.imageUri = imageUri;
  }

  @Override
  public void fetchData() {
    view.get().displayData(viewModel);
  }

}
