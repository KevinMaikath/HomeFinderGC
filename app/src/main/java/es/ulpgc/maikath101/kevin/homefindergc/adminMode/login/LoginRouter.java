package es.ulpgc.maikath101.kevin.homefindergc.adminMode.login;

import android.app.Activity;
import android.content.Intent;
import android.content.Context;

import es.ulpgc.maikath101.kevin.homefindergc.adminMode.selection.SelectionActivity;
import es.ulpgc.maikath101.kevin.homefindergc.app.AppMediator;

public class LoginRouter implements LoginContract.Router {

  public static String TAG = LoginRouter.class.getSimpleName();

  private AppMediator mediator;

  public LoginRouter(AppMediator mediator) {
    this.mediator = mediator;
  }

  @Override
  public void navigateToNextScreen(Activity activity) {
    Context context = mediator.getApplicationContext();
    Intent intent = new Intent(context, SelectionActivity.class);
    activity.startActivity(intent);
  }
}
