package es.ulpgc.maikath101.kevin.homefindergc.customerMode.drawer;

import android.app.Activity;

import java.lang.ref.WeakReference;

import es.ulpgc.maikath101.kevin.homefindergc.app.AppRouter;

public interface DrawerContract {

  interface View{

    void injectPresenter(Presenter presenter);
  }

  interface Presenter{

    void injectView(WeakReference<View> view);

    void injectRouter(AppRouter router);

    void goToStart(Activity activity);

    void goToForSale(Activity activity);

    void goToForRent(Activity activity);

    void goToHolidayRental(Activity activity);

    void goToAboutUS(Activity activity);

    void goToContact(Activity activity);
  }

  interface Router extends AppRouter {

  }
}
