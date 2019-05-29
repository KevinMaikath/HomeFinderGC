package es.ulpgc.maikath101.kevin.homefindergc.customerMode.aboutUsScreen;

import es.ulpgc.maikath101.kevin.homefindergc.app.AppRouter;
import java.lang.ref.WeakReference;

/**
 * Esta pantalla no posee ningún método ni realiza ninguna función. Solo presenta información
 * que se encuentra en R.values.strings.xml
 */
interface AboutUsContract {

  interface View {
    void injectPresenter(Presenter presenter);
  }

  interface Presenter {
    void injectAboutUsView(WeakReference<View> view);

    void injectModel(Model model);

    void injectRouter(Router router);
  }

  interface Model {
  }

  interface Router extends AppRouter {

  }
}
