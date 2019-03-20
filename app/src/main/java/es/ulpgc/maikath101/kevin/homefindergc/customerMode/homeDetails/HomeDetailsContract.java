package es.ulpgc.maikath101.kevin.homefindergc.customerMode.homeDetails;

import java.lang.ref.WeakReference;

import es.ulpgc.maikath101.kevin.homefindergc.app.AppRouter;

interface HomeDetailsContract {

    interface View {
        void injectPresenter(Presenter presenter);

        void displayData(HomeDetailsViewModel viewModel);
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

    interface Router extends AppRouter {
        int getDataFromStartScreen();
    }
}
