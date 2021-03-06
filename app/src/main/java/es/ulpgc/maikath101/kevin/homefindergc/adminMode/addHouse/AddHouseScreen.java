package es.ulpgc.maikath101.kevin.homefindergc.adminMode.addHouse;

import android.support.v4.app.FragmentActivity;

import es.ulpgc.maikath101.kevin.homefindergc.app.AppMediator;
import es.ulpgc.maikath101.kevin.homefindergc.data.HouseRepository;
import es.ulpgc.maikath101.kevin.homefindergc.data.HouseRepositoryContract;

import java.lang.ref.WeakReference;

public class AddHouseScreen {

  /**
   * Configuración del Activity
   * @param view
   */
  public static void configure(AddHouseContract.View view) {

    WeakReference<FragmentActivity> context =
            new WeakReference<>((FragmentActivity) view);

    AppMediator mediator = (AppMediator) context.get().getApplication();
    AddHouseState state = mediator.getAddHouseState();

    HouseRepositoryContract repository = HouseRepository.getInstance(context.get());
    AddHouseContract.Router router = new AddHouseRouter(mediator);
    AddHouseContract.Presenter presenter = new AddHousePresenter(state);
    AddHouseContract.Model model = new AddHouseModel(repository);
    presenter.injectModel(model);
    presenter.injectRouter(router);
    presenter.injectView(new WeakReference<>(view));

    view.injectPresenter(presenter);

  }
}
