package es.ulpgc.maikath101.kevin.homefindergc.customerMode.drawer;

import java.lang.ref.WeakReference;

import es.ulpgc.maikath101.kevin.homefindergc.app.AppRouter;

public interface DrawerContract {

  interface View{

    void injectPresenter(Presenter presenter);
  }

  interface Presenter{

    void injectView(WeakReference<View> view);

    void injectRouter(AppRouter router);

    void goToStart();

    void goToForSale();

    void goToForRent();

    void goToHolidayRental();

    void goToAboutUS();

    void goToContact();
  }

  interface Router extends AppRouter {

  }
}
