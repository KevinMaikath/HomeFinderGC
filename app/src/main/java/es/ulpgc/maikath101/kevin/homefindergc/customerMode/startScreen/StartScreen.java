package es.ulpgc.maikath101.kevin.homefindergc.customerMode.startScreen;

import java.lang.ref.WeakReference;

import android.support.v4.app.FragmentActivity;

import es.ulpgc.maikath101.kevin.homefindergc.app.AppMediator;

public class StartScreen {

  public static void configure(StartContract.View view) {

    WeakReference<FragmentActivity> context =
            new WeakReference<>((FragmentActivity) view);

    AppMediator mediator = (AppMediator) context.get().getApplication();
    StartState state = mediator.getStartState();

    StartContract.Router router = new StartRouter(mediator);
    StartContract.Presenter presenter = new StartPresenter(state);
    StartContract.Model model = new StartModel();
    presenter.injectModel(model);
    presenter.injectRouter(router);
    presenter.injectView(new WeakReference<>(view));

    view.injectPresenter(presenter);

  }
}
