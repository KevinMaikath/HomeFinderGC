package es.ulpgc.maikath101.kevin.homefindergc.adminMode.login;

import java.lang.ref.WeakReference;

import android.support.v4.app.FragmentActivity;

import es.ulpgc.maikath101.kevin.homefindergc.app.AppMediator;

public class LoginScreen {


  /**
   * Configuración del Activity
   * @param view
   */
  public static void configure(LoginContract.View view) {

    WeakReference<FragmentActivity> context =
            new WeakReference<>((FragmentActivity) view);

    AppMediator mediator = (AppMediator) context.get().getApplication();
    LoginState state = mediator.getLoginState();

    LoginContract.Router router = new LoginRouter(mediator);
    LoginContract.Presenter presenter = new LoginPresenter(state);
    LoginContract.Model model = new LoginModel();
    presenter.injectModel(model);
    presenter.injectRouter(router);
    presenter.injectView(new WeakReference<>(view));

    view.injectPresenter(presenter);

  }
}
