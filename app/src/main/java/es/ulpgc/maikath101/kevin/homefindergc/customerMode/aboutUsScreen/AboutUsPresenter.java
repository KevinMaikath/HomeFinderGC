package es.ulpgc.maikath101.kevin.homefindergc.customerMode.aboutUsScreen;

import android.util.Log;

import java.lang.ref.WeakReference;

public class AboutUsPresenter implements AboutUsContract.Presenter {

  public static String TAG = AboutUsPresenter.class.getSimpleName();

  private WeakReference<AboutUsContract.View> view;
  private AboutUsViewModel viewModel;
  private AboutUsContract.Model model;
  private AboutUsContract.Router router;

  public AboutUsPresenter(AboutUsState state) {
    viewModel = state;
  }

  @Override
  public void injectView(WeakReference<AboutUsContract.View> view) {
    this.view = view;
  }

  @Override
  public void injectModel(AboutUsContract.Model model) {
    this.model = model;
  }

  @Override
  public void injectRouter(AboutUsContract.Router router) {
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
