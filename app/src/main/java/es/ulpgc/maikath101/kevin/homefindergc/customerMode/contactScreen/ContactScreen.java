package es.ulpgc.maikath101.kevin.homefindergc.customerMode.contactScreen;

import java.lang.ref.WeakReference;

import android.support.v4.app.FragmentActivity;

import es.ulpgc.maikath101.kevin.homefindergc.app.AppMediator;

public class ContactScreen {

  /**
   * Configuración del Activity
   * @param view
   */
  public static void configure(ContactContract.View view) {

    WeakReference<FragmentActivity> context =
            new WeakReference<>((FragmentActivity) view);

    AppMediator mediator = (AppMediator) context.get().getApplication();
    ContactState state = mediator.getContactState();

    ContactContract.Router router = new ContactRouter(mediator);
    ContactContract.Presenter presenter = new ContactPresenter(state);
    ContactContract.Model model = new ContactModel();
    presenter.injectModel(model);
    presenter.injectRouter(router);
    presenter.injectContactView(new WeakReference<>(view));

    view.injectPresenter(presenter);

  }
}
