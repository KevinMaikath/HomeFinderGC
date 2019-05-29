package es.ulpgc.maikath101.kevin.homefindergc.customerMode.homeDetails;

import es.ulpgc.maikath101.kevin.homefindergc.app.AppRouter;
import es.ulpgc.maikath101.kevin.homefindergc.data.House;
import es.ulpgc.maikath101.kevin.homefindergc.data.HouseRepositoryContract;
import es.ulpgc.maikath101.kevin.homefindergc.data.Image;
import es.ulpgc.maikath101.kevin.homefindergc.data.RentHouse;
import es.ulpgc.maikath101.kevin.homefindergc.data.SellHouse;

import java.lang.ref.WeakReference;


public interface HomeDetailsContract {

  interface View {
    void injectPresenter(Presenter presenter);

    void displayData(HomeDetailsViewModel viewModel);

    void setImageList(HomeDetailsViewModel viewModel);
  }

  interface Presenter {
    void injectHomeDetailsView(WeakReference<View> view);

    void injectModel(Model model);

    void injectRouter(Router router);

    void fetchData();

    /**
     * Le pide al modelo la informacion de resumen de la casa y la carga en el viewModel
     */
    void summaryButtonClicked();

    /**
     * Le pide al modelo la informacion de descripcion de la casa y la carga en el viewModel
     */
    void descriptionButtonClicked();

    /**
     * Le pide al modelo la informacion de ubicacion de la casa y la carga en el viewModel
     */
    void locationButtonClicked();

    /**
     * Le pide al modelo la informacion de distribucion de la casa y la carga en el viewModel
     */
    void distributionButtonClicked();

    /**
     * Cambia la imagen principal de la Activity por la imagen pasada por parametros
     *
     * @param image Nueva imagen principal
     */
    void imageClicked(Image image);
  }

  interface Model {

    /**
     * Formatea la informacion de resumen necesaria de la casa que tiene el modelo
     *
     * @return String con la informacion de resumen
     */
    String getSummaryInfo();

    /**
     * Metodo Getter de la casa del modelo
     *
     * @return House del modelo
     */
    House getHouse();

    /**
     * Metodo Setter del sellHouse del modelo
     *
     * @param sellHouse
     */
    void setSellHouse(SellHouse sellHouse);

    /**
     * Metodo Setter del rentHouse del modelo
     *
     * @param rentHouse
     */
    void setRentHouse(RentHouse rentHouse);

    /**
     * Metodo Setter del House del modelo
     *
     * @param house
     */
    void setHouse(House house);

    /**
     * Le pide al repositorio que cargue un SellHouse segun su id y que lo pase a traves
     * de un callback
     *
     * @param current_house_id                  ID de la casa a la que corresponde el SellHouse
     * @param loadCompleteSellHouseInfoCallback Callback a traves de el cual el repositorio
     *                                          devuelve el SellHouse
     */
    void loadSellHouseInfo(int current_house_id,
                           HouseRepositoryContract.LoadCompleteSellHouseInfoCallback
                                   loadCompleteSellHouseInfoCallback);

    /**
     * Le pide al repositorio que cargue un RentHouse segun su id y que lo pase a traves
     * de un callback
     *
     * @param current_house_id                  ID de la casa a la que corresponde el SellHouse
     * @param loadCompleteRentHouseInfoCallback Callback a traves de el cual el repositorio
     *                                          devuelve el RentHouse
     */
    void loadRentHouseInfo(int current_house_id,
                           HouseRepositoryContract.LoadCompleteRentHouseInfoCallback
                                   loadCompleteRentHouseInfoCallback);
  }

  interface Router extends AppRouter {
    HomeDetailsState getDataFromStartScreen();
  }
}
