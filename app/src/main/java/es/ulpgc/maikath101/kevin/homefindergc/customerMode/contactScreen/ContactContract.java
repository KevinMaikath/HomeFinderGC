package es.ulpgc.maikath101.kevin.homefindergc.customerMode.contactScreen;

import java.lang.ref.WeakReference;

interface ContactContract {

    interface View {
        void injectPresenter(Presenter presenter);

        void displayData(ContactViewModel viewModel);
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

        void passDataToNextScreen(ContactState state);

        ContactState getDataFromPreviousScreen();
    }
}
