package es.ulpgc.maikath101.kevin.homefindergc.adminMode.login;

import android.view.View;

import java.lang.ref.WeakReference;

public interface LoginContract {

    interface View {
        void injectPresenter(Presenter presenter);

        void displayData(LoginViewModel viewModel);
    }

    interface Presenter {
        void injectView(WeakReference<View> view);

        void injectModel(Model model);

        void injectRouter(Router router);

        void fetchData();

        void onSignInPressed();
    }

    interface Model {
        String fetchData();
    }

    interface Router {
        void navigateToNextScreen();

        void passDataToNextScreen(LoginState state);

        LoginState getDataFromPreviousScreen();
    }
}
