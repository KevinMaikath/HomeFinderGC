package es.ulpgc.maikath101.kevin.homefindergc.customerMode.homeDetails;

import android.util.Log;
import android.content.Intent;
import android.content.Context;

public class HomeDetailsRouter implements HomeDetailsContract.Router {

    public static String TAG = HomeDetailsRouter.class.getSimpleName();

    private AppMediator mediator;

    public HomeDetailsRouter(AppMediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public void navigateToNextScreen() {
        Context context = mediator.getApplicationContext();
        Intent intent = new Intent(context, HomeDetailsActivity.class);
        context.startActivity(intent);
    }

    @Override
    public void passDataToNextScreen(HomeDetailsState state) {
        mediator.setHomeDetailsState(state);
    }

    @Override
    public HomeDetailsState getDataFromPreviousScreen() {
        HomeDetailsState state = mediator.getHomeDetailsState();
        return state;
    }
}
