package es.ulpgc.maikath101.kevin.homefindergc.adminMode.addHouse;

import android.net.Uri;
import android.util.Log;

import java.lang.ref.WeakReference;

import es.ulpgc.maikath101.kevin.homefindergc.data.HouseRepositoryContract;

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

  @Override
  public void doneButtonPressed(String name, String location, String price, String description,
                                Uri imageUri) {
    model.doneButtonPressed(name, location, price, description, imageUri,
            new HouseRepositoryContract.OnHouseCompleteleyInsertedCallback() {
      @Override
      public void houseInserted() {
        view.get().houseInsertedCorrectly();
      }
    });
  }


}
