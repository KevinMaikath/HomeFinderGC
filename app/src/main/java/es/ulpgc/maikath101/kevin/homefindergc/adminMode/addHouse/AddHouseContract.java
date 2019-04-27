package es.ulpgc.maikath101.kevin.homefindergc.adminMode.addHouse;

import android.net.Uri;

import java.lang.ref.WeakReference;

interface AddHouseContract {

  interface View {
    void injectPresenter(Presenter presenter);

    void displayData(AddHouseViewModel viewModel);
  }

  interface Presenter {
    void injectView(WeakReference<View> view);

    void injectModel(Model model);

    void injectRouter(Router router);

    void saveImageFromRotation(Uri imageUri);

    void fetchData();

    void doneButtonPressed(String name, String location, String price, String description, Uri imageUri);
  }

  interface Model {
    void doneButtonPressed(String name, String location, String price, String description, Uri imageUri);
  }

  interface Router {

    void passDataToNextScreen(AddHouseState state);

    void openGallery();
  }
}
