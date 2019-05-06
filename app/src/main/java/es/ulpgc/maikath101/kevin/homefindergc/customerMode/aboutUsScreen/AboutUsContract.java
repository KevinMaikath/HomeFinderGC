package es.ulpgc.maikath101.kevin.homefindergc.customerMode.aboutUsScreen;

import es.ulpgc.maikath101.kevin.homefindergc.app.AppRouter;
import java.lang.ref.WeakReference;

interface AboutUsContract {

  interface View {
    void injectPresenter(Presenter presenter);

    void displayData(AboutUsViewModel viewModel);
  }

  interface Presenter {
    void injectAboutUsView(WeakReference<View> view);

    void injectModel(Model model);

    void injectRouter(Router router);

    void fetchData();
  }

  interface Model {
    String fetchData();
  }

  interface Router extends AppRouter {

  }
}
