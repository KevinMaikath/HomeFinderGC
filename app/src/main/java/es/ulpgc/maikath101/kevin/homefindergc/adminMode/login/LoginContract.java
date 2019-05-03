package es.ulpgc.maikath101.kevin.homefindergc.adminMode.login;

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

    void navigateToNextScreen();
  }

  interface Model {
    boolean checkCredentials(String user, String password);
  }

  interface Router {
    void navigateToNextScreen();

    LoginState getDataFromPreviousScreen();
  }
}
