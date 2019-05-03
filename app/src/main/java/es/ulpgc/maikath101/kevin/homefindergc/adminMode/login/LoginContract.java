package es.ulpgc.maikath101.kevin.homefindergc.adminMode.login;

import android.app.Activity;

import java.lang.ref.WeakReference;

public interface LoginContract {

  interface View {
    void injectPresenter(Presenter presenter);

    void wrongCredentials();

    Activity getActivity();
  }

  interface Presenter {
    void injectView(WeakReference<View> view);

    void injectModel(Model model);

    void injectRouter(Router router);

    void onSignInPressed(String user, String password);

    Activity getActivity();
  }

  interface Model {
    boolean checkCredentials(String user, String password);
  }

  interface Router {
    void navigateToNextScreen(Activity activity);

    LoginState getDataFromPreviousScreen();
  }
}
