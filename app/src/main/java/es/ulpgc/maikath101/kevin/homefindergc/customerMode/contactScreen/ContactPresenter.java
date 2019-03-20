package es.ulpgc.maikath101.kevin.homefindergc.customerMode.contactScreen;

import java.lang.ref.WeakReference;

public class ContactPresenter implements ContactContract.Presenter {

  public static String TAG = ContactPresenter.class.getSimpleName();

  private WeakReference<ContactContract.View> view;
  private ContactViewModel viewModel;
  private ContactContract.Model model;
  private ContactContract.Router router;

  public ContactPresenter(ContactState state) {
    viewModel = state;
  }

  @Override
  public void injectView(WeakReference<ContactContract.View> view) {
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


}
