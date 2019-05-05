package es.ulpgc.maikath101.kevin.homefindergc.customerMode.contactScreen;

import android.content.Context;

import java.lang.ref.WeakReference;

import es.ulpgc.maikath101.kevin.homefindergc.app.AppRouter;

interface ContactContract {

  interface View {
    void injectPresenter(Presenter presenter);

    void displayData(ContactViewModel viewModel);
  }

  interface Presenter {
    void injectContactView(WeakReference<View> view);

    void injectModel(Model model);

    void injectRouter(Router router);

    void fetchData();

    void onSendButtonPressed(Context activity, String name, String telephone, String country,
                             String zipcode, String address, String email,
                             String subject, String bodyemail);
  }

  interface Model {
    String fetchData();
  }

  interface Router extends AppRouter {
    void sendEmail(Context activity, String name, String telephone, String country,
                             String zipcode, String address, String email,
                             String subject, String bodyemail);
  }
}
