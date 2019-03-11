package es.ulpgc.maikath101.kevin.homefindergc.customerMode.aboutUsScreen;

import java.lang.ref.WeakReference;

import android.support.v4.app.FragmentActivity;

public class AboutUsScreen {

    public static void configure(AboutUsContract.View view) {

        WeakReference<FragmentActivity> context =
                new WeakReference<>((FragmentActivity) view);

        AppMediator mediator = (AppMediator) context.get().getApplication();
        AboutUsState state = mediator.getAboutUsState();

        AboutUsContract.Router router = new AboutUsRouter(mediator);
        AboutUsContract.Presenter presenter = new AboutUsPresenter(state);
        AboutUsContract.Model model = new AboutUsModel();
        presenter.injectModel(model);
        presenter.injectRouter(router);
        presenter.injectView(new WeakReference<>(view));

        view.injectPresenter(presenter);

    }
}
