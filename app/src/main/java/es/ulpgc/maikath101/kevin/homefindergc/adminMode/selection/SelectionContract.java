package es.ulpgc.maikath101.kevin.homefindergc.adminMode.selection;

import android.content.Context;

import java.lang.ref.WeakReference;

public interface SelectionContract {

  interface View {
    void injectPresenter(Presenter presenter);
  }

  interface Presenter {
    void injectView(WeakReference<View> view);

    void injectModel(Model model);

    void injectRouter(Router router);

    /**
     * Llama al router para navegar a la pantalla RemoveHouse
     * @param activity: SelectionActivity
     */
    void goToRemoveHouseScreen(Context activity);

    /**
     * Llama al router para navegar a la pantalla AddHouse
     * @param activity: SelectionActivity
     */
    void goToAddHouseScreen(Context activity);
  }

  interface Model {
  }

  interface Router {

    /**
     * Navega a la pantalla RemoveHouse
     * @param activity: SelectionActivity
     */
    void navigateToRemoveHouseScreen(Context activity);

    /**
     * Navega a la pantalla AddHouse
     * @param activity: SelectionActivity
     */
    void navigateToAddHouseScreen(Context activity);
  }
}
