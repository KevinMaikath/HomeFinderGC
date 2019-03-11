package es.ulpgc.maikath101.kevin.homefindergc.customerMode.startScreen;

import android.util.Log;

import java.lang.ref.WeakReference;

public class StartPresenter implements StartContract.Presenter {

    public static String TAG = StartPresenter.class.getSimpleName();

    private WeakReference<StartContract.View> view;
    private StartViewModel viewModel;
    private StartContract.Model model;
    private StartContract.Router router;

    public StartPresenter(StartState state) {
        viewModel = state;
    }

    @Override
    public void injectView(WeakReference<StartContract.View> view) {
        this.view = view;
    }

    @Override
    public void injectModel(StartContract.Model model) {
        this.model = model;
    }

    @Override
    public void injectRouter(StartContract.Router router) {
        this.router = router;
    }

    @Override
    public void fetchData() {
        // Log.e(TAG, "fetchData()");

        // set passed state
        StartState state = router.getDataFromPreviousScreen();
        if (state != null) {
            viewModel.data = state.data;
        }

        if (viewModel.data == null) {
            // call the model
            String data = model.fetchData();

            // set initial state
            viewModel.data = data;
        }

        // update the view
        view.get().displayData(viewModel);

    }


}
