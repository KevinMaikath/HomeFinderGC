package es.ulpgc.maikath101.kevin.homefindergc.adminMode.addHouse;

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

    void fetchData();

    void openGallery();
  }

  interface Model {
    String fetchData();
  }

  interface Router {
    void navigateToNextScreen();

    void passDataToNextScreen(AddHouseState state);

    AddHouseState getDataFromPreviousScreen();

    void openGallery();
  }
}
