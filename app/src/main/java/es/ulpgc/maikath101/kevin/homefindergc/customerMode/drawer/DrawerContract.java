package es.ulpgc.maikath101.kevin.homefindergc.customerMode.drawer;

import android.app.Activity;

import java.lang.ref.WeakReference;

import es.ulpgc.maikath101.kevin.homefindergc.app.AppRouter;

public interface DrawerContract {

  interface View {

    void injectPresenter(Presenter presenter);
  }

  interface Presenter {

    void injectView(WeakReference<View> view);

    void injectRouter(AppRouter router);

    /**
     * Le pide al router que pase a la pantalla de Start y termina la activity actual
     * @param activity Activity pasada al router y que será terminada
     */
    void goToStart(Activity activity);

    /**
     * Le pide al router que pase a la pantalla de ForSale y termina la activity actual
     * @param activity Activity pasada al router y que será terminada
     */
    void goToForSale(Activity activity);

    /**
     * Le pide al router que pase a la pantalla de ForRent y termina la activity actual
     * @param activity Activity pasada al router y que será terminada
     */
    void goToForRent(Activity activity);

    /**
     * Le pide al router que pase a la pantalla de HolidayRental y termina la activity actual
     * @param activity Activity pasada al router y que será terminada
     */
    void goToHolidayRental(Activity activity);

    /**
     * Le pide al router que pase a la pantalla de AboutUs y termina la activity actual
     * @param activity Activity pasada al router y que será terminada
     */
    void goToAboutUs(Activity activity);

    /**
     * Le pide al router que pase a la pantalla de Contact y termina la activity actual
     * @param activity Activity pasada al router y que será terminada
     */
    void goToContact(Activity activity);

    /**
     * Le pide al router que pase a la pantalla de Start y termina la activity actual
     * @param activity Activity pasada al router y que será terminada
     */
    void onBackPressed(Activity activity);
  }

  interface Router extends AppRouter {

  }
}
