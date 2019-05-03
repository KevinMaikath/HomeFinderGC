package es.ulpgc.maikath101.kevin.homefindergc.adminMode.removeHouse;

import java.lang.ref.WeakReference;
import java.util.List;

import es.ulpgc.maikath101.kevin.homefindergc.data.House;
import es.ulpgc.maikath101.kevin.homefindergc.data.HouseRepository;
import es.ulpgc.maikath101.kevin.homefindergc.data.HouseRepositoryContract;

interface RemoveHouseContract {

  interface View {
    void injectPresenter(Presenter presenter);

    void displayData(RemoveHouseViewModel viewModel);

    void houseDeleted();
  }

  interface Presenter {
    void injectView(WeakReference<View> view);

    void injectModel(Model model);

    void injectRouter(Router router);

    void loadAllHouses();

    void removeHouse(int id_house);
  }

  interface Model {
    String fetchData();

    void loadAllHouses(HouseRepositoryContract.GetAllHousesCallback callback);

    void loadImages(int id_image, HouseRepository.GetImageFromHouseCallback callback);

    void removeHouse(int id_house, HouseRepository.OnHouseDeletedCallback callback);
  }

  interface Router {
  }
}
