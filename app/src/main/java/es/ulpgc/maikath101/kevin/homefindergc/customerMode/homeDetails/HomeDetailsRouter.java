package es.ulpgc.maikath101.kevin.homefindergc.customerMode.homeDetails;

import android.util.Log;
import android.content.Intent;
import android.content.Context;

import es.ulpgc.maikath101.kevin.homefindergc.app.AppCustomerRouter;
import es.ulpgc.maikath101.kevin.homefindergc.app.AppMediator;

public class HomeDetailsRouter extends AppCustomerRouter implements HomeDetailsContract.Router {

  public static String TAG = HomeDetailsRouter.class.getSimpleName();

  public HomeDetailsRouter(AppMediator mediator) {
    super(mediator);
  }

  @Override
  public HomeDetailsState getDataFromStartScreen() {
    return mediator.getHomeDetailsState();
  }

}
