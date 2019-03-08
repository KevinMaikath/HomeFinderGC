package es.ulpgc.maikath101.kevin.homefindergc.adminMode.selection;

import android.util.Log;
import android.content.Intent;
import android.content.Context;

import es.ulpgc.maikath101.kevin.homefindergc.app.AppMediator;

public class SelectionRouter implements SelectionContract.Router {

    public static String TAG = SelectionRouter.class.getSimpleName();

    private AppMediator mediator;

    public SelectionRouter(AppMediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public void navigateToNextScreen() {
        Context context = mediator.getApplicationContext();
        Intent intent = new Intent(context, SelectionActivity.class);
        context.startActivity(intent);
    }

    @Override
    public void passDataToNextScreen(SelectionState state) {
        mediator.setSelectionState(state);
    }

    @Override
    public SelectionState getDataFromPreviousScreen() {
        SelectionState state = mediator.getSelectionState();
        return state;
    }
}
