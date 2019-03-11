package es.ulpgc.maikath101.kevin.homefindergc.customerMode.homeDetails;

import java.lang.ref.WeakReference;

import android.support.v4.app.FragmentActivity;

import es.ulpgc.maikath101.kevin.homefindergc.app.AppMediator;

public class HomeDetailsScreen {

    public static void configure(HomeDetailsContract.View view) {

        WeakReference<FragmentActivity> context =
                new WeakReference<>((FragmentActivity) view);

        AppMediator mediator = (AppMediator) context.get().getApplication();
        HomeDetailsState state = mediator.getHomeDetailsState();

        HomeDetailsContract.Router router = new HomeDetailsRouter(mediator);
        HomeDetailsContract.Presenter presenter = new HomeDetailsPresenter(state);
        HomeDetailsContract.Model model = new HomeDetailsModel();
        presenter.injectModel(model);
        presenter.injectRouter(router);
        presenter.injectView(new WeakReference<>(view));

        view.injectPresenter(presenter);

    }
}
