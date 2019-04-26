package es.ulpgc.maikath101.kevin.homefindergc.adminMode.removeHouse;

import java.lang.ref.WeakReference;
import java.util.List;

import es.ulpgc.maikath101.kevin.homefindergc.data.House;
import es.ulpgc.maikath101.kevin.homefindergc.data.HouseRepositoryContract;

interface RemoveHouseContract {

  interface View {
    void injectPresenter(Presenter presenter);

    void displayData(RemoveHouseViewModel viewModel);
  }

  interface Presenter {
    void injectView(WeakReference<View> view);

    void injectModel(Model model);

    void injectRouter(Router router);

    void loadAllHouses();
  }

  interface Model {
    String fetchData();

    void loadAllHouses(HouseRepositoryContract.GetAllHousesCallback callback);
  }

  interface Router {
    RemoveHouseState getDataFromPreviousScreen();

  }
}
