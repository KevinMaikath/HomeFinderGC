package es.ulpgc.maikath101.kevin.homefindergc.adminMode.selection;

import android.util.Log;
import android.content.Intent;
import android.content.Context;

import es.ulpgc.maikath101.kevin.homefindergc.adminMode.addHouse.AddHouseActivity;
import es.ulpgc.maikath101.kevin.homefindergc.adminMode.removeHouse.RemoveHouseActivity;
import es.ulpgc.maikath101.kevin.homefindergc.app.AppMediator;

public class SelectionRouter implements SelectionContract.Router {

    public static String TAG = SelectionRouter.class.getSimpleName();

    private AppMediator mediator;

    public SelectionRouter(AppMediator mediator) {
        this.mediator = mediator;
    }


    @Override
    public void navigateToRemoveHouseScreen() {
        Context context = mediator.getApplicationContext();
        Intent intent = new Intent(context, RemoveHouseActivity.class);
        context.startActivity(intent);
    }

    @Override
    public void navigateToAddHouseScreen() {
        Context context = mediator.getApplicationContext();
        Intent intent = new Intent(context, AddHouseActivity.class);
        context.startActivity(intent);
    }
}
