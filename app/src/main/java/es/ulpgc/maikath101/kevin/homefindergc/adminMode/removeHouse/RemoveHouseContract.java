package es.ulpgc.maikath101.kevin.homefindergc.adminMode.removeHouse;

import java.lang.ref.WeakReference;
import java.util.List;

import es.ulpgc.maikath101.kevin.homefindergc.data.House;
import es.ulpgc.maikath101.kevin.homefindergc.data.HouseRepository;
import es.ulpgc.maikath101.kevin.homefindergc.data.HouseRepositoryContract;

public interface RemoveHouseContract {

  interface View {
    void injectPresenter(Presenter presenter);

    void displayData(RemoveHouseViewModel viewModel);

    /**
     * Se vuelven a cargar todas las viviendas cuando una casa ha sido eliminada
     */
    void houseDeleted();
  }

  interface Presenter {
    void injectView(WeakReference<View> view);

    void injectModel(Model model);

    void injectRouter(Router router);

    /**
     * Se cargan todas las viviendas cuando se carga el Activity o cuando se elimina alguna
     */
    void loadAllHouses();

    /**
     * Llama al modelo para eliminar la vivienda con el id_house
     * @param id_house: Id de la vivienda a eliminar
     */
    void removeHouse(int id_house);
  }

  interface Model {

    /**
     * Se llama al repositorio para cargar todas las viviendas
     * @param callback: Método que llama el modelo cuando acaba de cargar las viviendas
     */
    void loadAllHouses(HouseRepositoryContract.GetAllHousesCallback callback);

    /**
     * Se cargan las imágenes de una vivienda
     * @param id_image: Id de la vivienda para cargar su imagen principal
     * @param callback: Método que llama el modelo cuando acaba de cargar las imágenes
     */
    void loadImages(int id_image, HouseRepository.GetImageFromHouseCallback callback);

    /**
     * Se elimina la vivienda con el id_house
     * @param id_house: Id de la vivienda a eliminar
     * @param callback: Método que llama el modelo cuando ha eliminado la vivienda
     */
    void removeHouse(int id_house, HouseRepository.OnHouseDeletedCallback callback);
  }

  interface Router {
  }
}
