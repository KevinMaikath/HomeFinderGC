package es.ulpgc.maikath101.kevin.homefindergc.adminMode.selection;

import java.lang.ref.WeakReference;

import android.support.v4.app.FragmentActivity;

import es.ulpgc.maikath101.kevin.homefindergc.app.AppMediator;

public class SelectionScreen {

    public static void configure(SelectionContract.View view) {

        WeakReference<FragmentActivity> context =
                new WeakReference<>((FragmentActivity) view);

        AppMediator mediator = (AppMediator) context.get().getApplication();
        SelectionState state = mediator.getSelectionState();

        SelectionContract.Router router = new SelectionRouter(mediator);
        SelectionContract.Presenter presenter = new SelectionPresenter(state);
        SelectionContract.Model model = new SelectionModel();
        presenter.injectModel(model);
        presenter.injectRouter(router);
        presenter.injectView(new WeakReference<>(view));

        view.injectPresenter(presenter);

    }
}
