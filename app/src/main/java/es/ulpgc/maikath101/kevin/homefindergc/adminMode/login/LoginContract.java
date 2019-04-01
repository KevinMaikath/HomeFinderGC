package es.ulpgc.maikath101.kevin.homefindergc.adminMode.login;

import android.view.View;

import java.lang.ref.WeakReference;

public interface LoginContract {

    interface View {
        void injectPresenter(Presenter presenter);

        void wrongCredentials();
    }

    interface Presenter {
        void injectView(WeakReference<View> view);

        void injectModel(Model model);

        void injectRouter(Router router);

        void onSignInPressed(String user, String password);
    }

    interface Model {
        boolean checkCredentials(String user, String password);
    }

    interface Router {
        void navigateToNextScreen();

        void passDataToNextScreen(LoginState state);

        LoginState getDataFromPreviousScreen();
    }
}
