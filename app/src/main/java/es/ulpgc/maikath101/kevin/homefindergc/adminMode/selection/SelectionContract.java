package es.ulpgc.maikath101.kevin.homefindergc.adminMode.selection;

import java.lang.ref.WeakReference;

interface SelectionContract {

    interface View {
        void injectPresenter(Presenter presenter);
    }

    interface Presenter {
        void injectView(WeakReference<View> view);

        void injectModel(Model model);

        void injectRouter(Router router);

        void goToRemoveHouseScreen();

        void goToAddHouseScreen();
    }

    interface Model {
    }

    interface Router {
        void navigateToRemoveHouseScreen();

        void navigateToAddHouseScreen();
    }
}
