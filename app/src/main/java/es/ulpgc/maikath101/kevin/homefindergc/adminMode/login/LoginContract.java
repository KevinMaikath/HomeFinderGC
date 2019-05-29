package es.ulpgc.maikath101.kevin.homefindergc.adminMode.login;

import android.app.Activity;

import java.lang.ref.WeakReference;

public interface LoginContract {

  interface View {
    void injectPresenter(Presenter presenter);

    /**
     * Se muestra un mensaje cuando las credenciales son incorrectas
     */
    void wrongCredentials();

    /**
     * Método necesario para el router para pasar de pantalla
     *
     * @return Activity (LoginActivity)
     */
    Activity getActivity();
  }

  interface Presenter {
    void injectView(WeakReference<View> view);

    void injectModel(Model model);

    void injectRouter(Router router);

    /**
     * Llama al modelo para comprobar las credenciales
     *
     * @param user:     Usuario
     * @param password: Contraseña
     */
    void onSignInPressed(String user, String password);

    /**
     * Consigue el activity (LoginActivity)
     *
     * @return LoginActivity
     */
    Activity getActivity();
  }

  interface Model {
    /**
     * Comprueba que las credenciales son correctas
     *
     * @param user:     Usuario
     * @param password: Contraseña
     * @return: True si son correctas. False si son incorrectas
     */
    boolean checkCredentials(String user, String password);
  }

  interface Router {

    /**
     * Pasa a la siguiente pantalla --> SelectionActivity
     *
     * @param activity
     */
    void navigateToNextScreen(Activity activity);
  }
}
