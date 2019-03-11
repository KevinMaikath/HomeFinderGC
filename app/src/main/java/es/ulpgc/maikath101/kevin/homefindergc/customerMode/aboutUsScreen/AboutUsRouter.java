package es.ulpgc.maikath101.kevin.homefindergc.customerMode.aboutUsScreen;

import android.util.Log;
import android.content.Intent;
import android.content.Context;

public class AboutUsRouter implements AboutUsContract.Router {

    public static String TAG = AboutUsRouter.class.getSimpleName();

    private AppMediator mediator;

    public AboutUsRouter(AppMediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public void navigateToNextScreen() {
        Context context = mediator.getApplicationContext();
        Intent intent = new Intent(context, AboutUsActivity.class);
        context.startActivity(intent);
    }

    @Override
    public void passDataToNextScreen(AboutUsState state) {
        mediator.setAboutUsState(state);
    }

    @Override
    public AboutUsState getDataFromPreviousScreen() {
        AboutUsState state = mediator.getAboutUsState();
        return state;
    }
}
