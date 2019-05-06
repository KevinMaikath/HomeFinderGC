package es.ulpgc.maikath101.kevin.homefindergc.adminMode.addHouse;

import android.app.Activity;
import android.net.Uri;

import java.lang.ref.WeakReference;

import es.ulpgc.maikath101.kevin.homefindergc.data.HouseRepository;

public interface AddHouseContract {

  interface View {
    void injectPresenter(Presenter presenter);

    void displayData(AddHouseViewModel viewModel);

    void houseInsertedCorrectly();

    void finishActivity();
  }

  interface Presenter {
    void injectView(WeakReference<View> view);

    void injectModel(Model model);

    void injectRouter(Router router);

    void saveImageFromRotation(Uri imageUri);

    void fetchData();

    void doneButtonPressed(String name, String location, String price, String description, Uri imageUri);

    void openGallery(Activity activity);

    void removeHomeFromViewModel();
  }

  interface Model {
    void doneButtonPressed(String name, String location, String price, String description, Uri imageUri,
                           HouseRepository.OnHouseCompleteleyInsertedCallback callback);
  }

  interface Router {
    void openGallery(Activity activity);
  }
}
