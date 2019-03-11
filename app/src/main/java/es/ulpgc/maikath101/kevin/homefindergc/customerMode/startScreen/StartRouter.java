package es.ulpgc.maikath101.kevin.homefindergc.customerMode.startScreen;

import android.util.Log;
import android.content.Intent;
import android.content.Context;

public class StartRouter implements StartContract.Router {

    public static String TAG = StartRouter.class.getSimpleName();

    private AppMediator mediator;

    public StartRouter(AppMediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public void navigateToNextScreen() {
        Context context = mediator.getApplicationContext();
        Intent intent = new Intent(context, StartActivity.class);
        context.startActivity(intent);
    }

    @Override
    public void passDataToNextScreen(StartState state) {
        mediator.setStartState(state);
    }

    @Override
    public StartState getDataFromPreviousScreen() {
        StartState state = mediator.getStartState();
        return state;
    }
}
