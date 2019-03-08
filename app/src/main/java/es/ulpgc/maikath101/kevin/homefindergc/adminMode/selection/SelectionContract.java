package es.ulpgc.maikath101.kevin.homefindergc.adminMode.selection;

import java.lang.ref.WeakReference;

interface SelectionContract {

    interface View {
        void injectPresenter(Presenter presenter);

        void displayData(SelectionViewModel viewModel);
    }

    interface Presenter {
        void injectView(WeakReference<View> view);

        void injectModel(Model model);

        void injectRouter(Router router);

        void fetchData();
    }

    interface Model {
        String fetchData();
    }

    interface Router {
        void navigateToNextScreen();

        void passDataToNextScreen(SelectionState state);

        SelectionState getDataFromPreviousScreen();
    }
}
