package es.ulpgc.maikath101.kevin.homefindergc.customerMode.startScreen;

import android.app.Activity;
import android.content.Intent;
import android.content.Context;

import es.ulpgc.maikath101.kevin.homefindergc.app.AppCustomerRouter;
import es.ulpgc.maikath101.kevin.homefindergc.app.AppMediator;
import es.ulpgc.maikath101.kevin.homefindergc.customerMode.homeDetails.HomeDetailsActivity;
import es.ulpgc.maikath101.kevin.homefindergc.customerMode.homeDetails.HomeDetailsState;

public class StartRouter extends AppCustomerRouter implements StartContract.Router {

  public static String TAG = StartRouter.class.getSimpleName();

  public StartRouter(AppMediator mediator) {
    super(mediator);
  }

  @Override
  public void navigateToHomeDetailScreen(Context activity) {
    Context context = mediator.getApplicationContext();
    Intent intent = new Intent(context, HomeDetailsActivity.class);
    activity.startActivity(intent);
  }

  @Override
  public void passDataToHomeDetailScreen(HomeDetailsState state) {
    mediator.setHomeDetailsState(state);
  }

}
