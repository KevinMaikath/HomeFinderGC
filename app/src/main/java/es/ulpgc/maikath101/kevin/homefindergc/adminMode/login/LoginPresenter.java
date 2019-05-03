package es.ulpgc.maikath101.kevin.homefindergc.adminMode.login;

import android.app.Activity;

import java.lang.ref.WeakReference;

public class LoginPresenter implements LoginContract.Presenter {

  public static String TAG = LoginPresenter.class.getSimpleName();

  private WeakReference<LoginContract.View> view;
  private LoginViewModel viewModel;
  private LoginContract.Model model;
  private LoginContract.Router router;

  public LoginPresenter(LoginState state) {
    viewModel = state;
  }

  @Override
  public void injectView(WeakReference<LoginContract.View> view) {
    this.view = view;
  }

  @Override
  public void injectModel(LoginContract.Model model) {
    this.model = model;
  }

  @Override
  public void injectRouter(LoginContract.Router router) {
    this.router = router;
  }

  @Override
  public void onSignInPressed(String user, String password) {
    boolean answer = model.checkCredentials(user, password);
    if (answer) {
      router.navigateToNextScreen(getActivity());
    } else {
      view.get().wrongCredentials();
    }
  }

  @Override
  public Activity getActivity(){
    return view.get().getActivity();
  }


}
