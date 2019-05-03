package es.ulpgc.maikath101.kevin.homefindergc.adminMode.selection;

import android.app.Activity;
import android.content.Context;
import android.util.Log;

import java.lang.ref.WeakReference;

public class SelectionPresenter implements SelectionContract.Presenter {

    public static String TAG = SelectionPresenter.class.getSimpleName();

    private WeakReference<SelectionContract.View> view;
    private SelectionViewModel viewModel;
    private SelectionContract.Model model;
    private SelectionContract.Router router;

    public SelectionPresenter(SelectionState state) {
        viewModel = state;
    }

    @Override
    public void injectView(WeakReference<SelectionContract.View> view) {
        this.view = view;
    }

    @Override
    public void injectModel(SelectionContract.Model model) {
        this.model = model;
    }

    @Override
    public void injectRouter(SelectionContract.Router router) {
        this.router = router;
    }

    @Override
    public void goToRemoveHouseScreen(Context activity) {
        router.navigateToRemoveHouseScreen(activity);
    }

    @Override
    public void goToAddHouseScreen(Context activity) {
        router.navigateToAddHouseScreen(activity);
    }


}
