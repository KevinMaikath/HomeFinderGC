package es.ulpgc.maikath101.kevin.homefindergc.adminMode.removeHouse;

import java.lang.ref.WeakReference;
import java.util.ArrayList;

import es.ulpgc.maikath101.kevin.homefindergc.data.House;

interface RemoveHouseContract {

  interface View {
    void injectPresenter(Presenter presenter);

    void displayData(RemoveHouseViewModel viewModel);
  }

  interface Presenter {
    void injectView(WeakReference<View> view);

    void injectModel(Model model);

    void injectRouter(Router router);

    void fetchData();
  }

  interface Model {
    String fetchData();
  }

  interface Router {
    void navigateToNextScreen();

    void passDataToNextScreen(RemoveHouseState state);

    RemoveHouseState getDataFromPreviousScreen();

  }
}
