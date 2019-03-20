package es.ulpgc.maikath101.kevin.homefindergc.customerMode.homeDetails;

import java.lang.ref.WeakReference;

public class HomeDetailsPresenter implements HomeDetailsContract.Presenter {

  public static String TAG = HomeDetailsPresenter.class.getSimpleName();

  private WeakReference<HomeDetailsContract.View> view;
  private HomeDetailsViewModel viewModel;
  private HomeDetailsContract.Model model;
  private HomeDetailsContract.Router router;

  public HomeDetailsPresenter(HomeDetailsState state) {
    viewModel = state;
  }

  @Override
  public void injectView(WeakReference<HomeDetailsContract.View> view) {
    this.view = view;
  }

  @Override
  public void injectModel(HomeDetailsContract.Model model) {
    this.model = model;
  }

  @Override
  public void injectRouter(HomeDetailsContract.Router router) {
    this.router = router;
  }

  @Override
  public void fetchData() {
    // Log.e(TAG, "fetchData()");

    // set passed state
    // HomeDetailsState state = router.getDataFromPreviousScreen();

    // update the view
    view.get().displayData(viewModel);

  }


}
