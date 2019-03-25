package es.ulpgc.maikath101.kevin.homefindergc.adminMode.removeHouse;

import android.util.Log;
import android.content.Intent;
import android.content.Context;

import es.ulpgc.maikath101.kevin.homefindergc.app.AppMediator;

public class RemoveHouseRouter implements RemoveHouseContract.Router {

  public static String TAG = RemoveHouseRouter.class.getSimpleName();

  private AppMediator mediator;

  public RemoveHouseRouter(AppMediator mediator) {
    this.mediator = mediator;
  }

  @Override
  public void navigateToNextScreen() {
    Context context = mediator.getApplicationContext();
    Intent intent = new Intent(context, RemoveHouseActivity.class);
    context.startActivity(intent);
  }

  @Override
  public void passDataToNextScreen(RemoveHouseState state) {
    mediator.setRemoveHouseState(state);
  }

  @Override
  public RemoveHouseState getDataFromPreviousScreen() {
    RemoveHouseState state = mediator.getRemoveHouseState();
    return state;
  }
}
