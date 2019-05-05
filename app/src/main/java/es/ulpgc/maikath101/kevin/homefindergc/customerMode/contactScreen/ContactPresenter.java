package es.ulpgc.maikath101.kevin.homefindergc.customerMode.contactScreen;

import android.app.Activity;
import android.content.Context;

import java.lang.ref.WeakReference;

import es.ulpgc.maikath101.kevin.homefindergc.customerMode.drawer.DrawerPresenter;

public class ContactPresenter extends DrawerPresenter implements ContactContract.Presenter {

  public static String TAG = ContactPresenter.class.getSimpleName();

  private WeakReference<ContactContract.View> view;
  private ContactViewModel viewModel;
  private ContactContract.Model model;
  private ContactContract.Router router;

  public ContactPresenter(ContactState state) {
    viewModel = state;
  }

  @Override
  public void injectContactView(WeakReference<ContactContract.View> view) {
    this.view = view;
  }

  @Override
  public void injectModel(ContactContract.Model model) {
    this.model = model;
  }

  @Override
  public void injectRouter(ContactContract.Router router) {
    this.router = router;
  }

  @Override
  public void fetchData() {
    // Log.e(TAG, "fetchData()");

    // set passed state

    // update the view
    view.get().displayData(viewModel);
  }

  @Override
  public void onSendButtonPressed(Context activity, String name, String telephone, String country,
                                  String zipcode, String address, String email,
                                  String subject, String bodyemail) {
    router.sendEmail(activity, name, telephone, country, zipcode, address, email, subject, bodyemail);
  }

}
