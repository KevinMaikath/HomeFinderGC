package es.ulpgc.maikath101.kevin.homefindergc.customerMode.drawer;

import android.support.v4.app.FragmentActivity;

import java.lang.ref.WeakReference;

import es.ulpgc.maikath101.kevin.homefindergc.app.AppCustomerRouter;
import es.ulpgc.maikath101.kevin.homefindergc.app.AppMediator;
import es.ulpgc.maikath101.kevin.homefindergc.app.AppRouter;

public class DrawerScreen {

  /**
   * Configuración del Activity
   * @param view
   */
  public static void configure(DrawerContract.View view) {

    WeakReference<FragmentActivity> context =
            new WeakReference<>((FragmentActivity) view);

    AppMediator mediator = (AppMediator) context.get().getApplication();


    AppRouter router = new AppCustomerRouter(mediator);
    DrawerContract.Presenter presenter = new DrawerPresenter();
    presenter.injectRouter(router);
    presenter.injectView(new WeakReference<>(view));

    view.injectPresenter(presenter);

  }

}
