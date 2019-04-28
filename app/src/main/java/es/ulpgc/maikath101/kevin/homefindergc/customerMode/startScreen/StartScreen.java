package es.ulpgc.maikath101.kevin.homefindergc.customerMode.startScreen;

import java.lang.ref.WeakReference;

import android.support.v4.app.FragmentActivity;

import es.ulpgc.maikath101.kevin.homefindergc.app.AppMediator;
import es.ulpgc.maikath101.kevin.homefindergc.data.HouseRepository;

public class StartScreen {

  public static void configure(StartContract.View view) {

    WeakReference<FragmentActivity> context =
            new WeakReference<>((FragmentActivity) view);

    AppMediator mediator = (AppMediator) context.get().getApplication();
    StartState state = mediator.getStartState();

    HouseRepository repository = HouseRepository.getInstance(context.get());

    StartContract.Router router = new StartRouter(mediator);
    StartContract.Presenter presenter = new StartPresenter(state);
    StartContract.Model model = new StartModel(repository);
    presenter.injectModel(model);
    presenter.injectRouter(router);
    presenter.injectStartView(new WeakReference<>(view));

    view.injectPresenter(presenter);

  }
}
