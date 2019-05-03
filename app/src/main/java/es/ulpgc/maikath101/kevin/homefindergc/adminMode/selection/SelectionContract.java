package es.ulpgc.maikath101.kevin.homefindergc.adminMode.selection;

import android.app.Activity;
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

        void goToRemoveHouseScreen(Context activity);

        void goToAddHouseScreen(Context activity);
    }

    interface Model {
    }

    interface Router {
        void navigateToRemoveHouseScreen(Context activity);

        void navigateToAddHouseScreen(Context activity);
    }
}
