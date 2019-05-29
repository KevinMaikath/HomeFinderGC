package es.ulpgc.maikath101.kevin.homefindergc.customerMode.startScreen;

import android.app.Activity;
import android.content.Context;

import es.ulpgc.maikath101.kevin.homefindergc.app.AppRouter;
import es.ulpgc.maikath101.kevin.homefindergc.customerMode.homeDetails.HomeDetailsState;
import es.ulpgc.maikath101.kevin.homefindergc.data.HouseRepository;
import es.ulpgc.maikath101.kevin.homefindergc.data.HouseRepositoryContract;
import es.ulpgc.maikath101.kevin.homefindergc.data.SimpleHouse;

import java.lang.ref.WeakReference;

public interface StartContract {

  interface View {
    void injectPresenter(Presenter presenter);

    void displayData(StartViewModel viewModel);
  }

  interface Presenter {
    void injectStartView(WeakReference<View> view);

    void injectModel(Model model);

    void injectRouter(Router router);

    void fetchData();

    /**
     * Comprueba el estado, de forma que se presente por pantalla
     * una lista de casas u otra
     */
    void checkCurrentScreen();

    void onBackPressed(Activity activity);

    /**
     * Pide la lista de casas correspondiente para la pantalla de Inicio
     * y la fija en el viewModel
     */
    void fetchStartHousesData();

    /**
     * Pide la lista de casas correspondiente para la pantalla de Se Vende
     * y la fija en el viewModel
     */
    void fetchForSaleHousesData();

    /**
     * Pide la lista de casas correspondiente para la pantalla de Se Alquila
     * y la fija en el viewModel
     */
    void fetchForRentHousesData();

    /**
     * Pide la lista de casas correspondiente para la pantalla de Alquiler Vacacional
     * y la fija en el viewModel
     */
    void fetchHolidayRentalHousesData();

    /**
     * Indica al router que se ha hecho click en una casa, pasandole el id de dicha casa
     *
     * @param activity Activity en la que se hace click
     * @param item     Casa específica en la que se ha hecho click
     */
    void selectHouse(Context activity, SimpleHouse item);
  }

  interface Model {

    /**
     * Pide al repositorio que cargue la lista de casas correspondiente a la pantalla de Start
     * y las devuelva a traves de un callback
     *
     * @param callback Callback a traves del cual el repositorio devuelve la lista de casas
     */
    void loadStartHouses(HouseRepositoryContract.GetStartHousesCallback callback);

    /**
     * Pide al repositorio que cargue la lista de casas correspondiente a la pantalla de ForSale
     * y las devuelva a traves de un callback
     *
     * @param callback Callback a traves del cual el repositorio devuelve la lista de casas
     */
    void loadForSaleHouses(HouseRepositoryContract.GetForSaleHousesCallback callback);

    /**
     * Pide al repositorio que cargue la lista de casas correspondiente a la pantalla de ForRent
     * y las devuelva a traves de un callback
     *
     * @param callback Callback a traves del cual el repositorio devuelve la lista de casas
     */
    void loadForRentHouses(HouseRepositoryContract.GetForRentHousesCallback callback);

    /**
     * Pide al repositorio que cargue la lista de casas correspondiente a la pantalla de
     * HolidayRental y las devuelva a traves de un callback
     *
     * @param callback Callback a traves del cual el repositorio devuelve la lista de casas
     */
    void loadHolidayRentalHouses(HouseRepositoryContract.GetHolidayRentalHousesCallback callback);

    /**
     * Pide al repositorio que cargue una imagen por su id_image y la devuelva a traves
     * de un callback
     *
     * @param id_image ID de la imagen en concreto
     * @param callback Callback a traves del cual el repositorio devuelve la imagen
     */
    void loadImages(int id_image, HouseRepository.GetImageFromHouseCallback callback);
  }

  interface Router extends AppRouter {
    void navigateToHomeDetailScreen(Context activity);

    void passDataToHomeDetailScreen(HomeDetailsState state);
  }
}
