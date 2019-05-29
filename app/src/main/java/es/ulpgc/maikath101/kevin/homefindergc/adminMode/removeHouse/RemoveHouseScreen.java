package es.ulpgc.maikath101.kevin.homefindergc.adminMode.removeHouse;

import android.support.v4.app.FragmentActivity;

import es.ulpgc.maikath101.kevin.homefindergc.app.AppMediator;
import es.ulpgc.maikath101.kevin.homefindergc.data.HouseRepository;
import es.ulpgc.maikath101.kevin.homefindergc.data.HouseRepositoryContract;

import java.lang.ref.WeakReference;

public class RemoveHouseScreen {

  /**
   * Configuración del Activity
   * @param view
   */
  public static void configure(RemoveHouseContract.View view) {

    WeakReference<FragmentActivity> context =
            new WeakReference<>((FragmentActivity) view);

    AppMediator mediator = (AppMediator) context.get().getApplication();
    RemoveHouseState state = mediator.getRemoveHouseState();

    HouseRepositoryContract repository = HouseRepository.getInstance(context.get());
    RemoveHouseContract.Router router = new RemoveHouseRouter(mediator);
    RemoveHouseContract.Presenter presenter = new RemoveHousePresenter(state);
    RemoveHouseContract.Model model = new RemoveHouseModel(repository);
    presenter.injectModel(model);
    presenter.injectRouter(router);
    presenter.injectView(new WeakReference<>(view));

    view.injectPresenter(presenter);

  }
}
