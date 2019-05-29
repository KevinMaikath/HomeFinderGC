package es.ulpgc.maikath101.kevin.homefindergc.customerMode.contactScreen;

import android.content.Context;

import java.lang.ref.WeakReference;

import es.ulpgc.maikath101.kevin.homefindergc.app.AppRouter;

interface ContactContract {

  interface View {
    void injectPresenter(Presenter presenter);
  }

  interface Presenter {
    void injectContactView(WeakReference<View> view);

    void injectModel(Model model);

    void injectRouter(Router router);

    /**
     * Llama al router para enviar el correo con los parámetros:
     *
     * @param activity:  ContactActivity
     * @param name:      Nombre de la persona
     * @param telephone: Teléfono de la persona
     * @param country:   País de residencia
     * @param zipcode:   Código Postal
     * @param address:   Dirección
     * @param email:     Dirección de correo electrónico
     * @param subject:   Asunto del correo
     * @param bodyemail: Cuerpo o mensaje del correo
     */
    void onSendButtonPressed(Context activity, String name, String telephone, String country,
                             String zipcode, String address, String email,
                             String subject, String bodyemail);
  }

  interface Model {
  }

  interface Router extends AppRouter {
    /**
     * Construye y envía el email a través de la aplicación que seleccione el usuario.
     *
     * @param activity:  ContactActivity
     * @param name:      Nombre de la persona
     * @param telephone: Teléfono de la persona
     * @param country:   País de residencia
     * @param zipcode:   Código Postal
     * @param address:   Dirección
     * @param email:     Dirección de correo electrónico
     * @param subject:   Asunto del correo
     * @param bodyemail: Cuerpo o mensaje del correo
     */
    void sendEmail(Context activity, String name, String telephone, String country,
                   String zipcode, String address, String email,
                   String subject, String bodyemail);
  }
}
