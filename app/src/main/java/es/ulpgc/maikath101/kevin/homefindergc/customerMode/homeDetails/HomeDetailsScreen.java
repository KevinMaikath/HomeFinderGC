package es.ulpgc.maikath101.kevin.homefindergc.customerMode.homeDetails;

import java.lang.ref.WeakReference;

import android.support.v4.app.FragmentActivity;

import es.ulpgc.maikath101.kevin.homefindergc.app.AppMediator;
import es.ulpgc.maikath101.kevin.homefindergc.data.HouseRepository;

public class HomeDetailsScreen {

  public static void configure(HomeDetailsContract.View view) {

    WeakReference<FragmentActivity> context =
            new WeakReference<>((FragmentActivity) view);

    AppMediator mediator = (AppMediator) context.get().getApplication();
    HomeDetailsState state = mediator.getHomeDetailsState();

    HouseRepository repository = HouseRepository.getInstance(context.get());

    HomeDetailsContract.Router router = new HomeDetailsRouter(mediator);
    HomeDetailsContract.Presenter presenter = new HomeDetailsPresenter(state);
    HomeDetailsContract.Model model = new HomeDetailsModel(repository);
    presenter.injectModel(model);
    presenter.injectRouter(router);
    presenter.injectHomeDetailsView(new WeakReference<>(view));

    view.injectPresenter(presenter);

  }
}
