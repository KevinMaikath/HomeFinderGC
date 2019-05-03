package es.ulpgc.maikath101.kevin.homefindergc.adminMode.removeHouse;

import es.ulpgc.maikath101.kevin.homefindergc.app.AppMediator;

public class RemoveHouseRouter implements RemoveHouseContract.Router {

  public static String TAG = RemoveHouseRouter.class.getSimpleName();

  private AppMediator mediator;

  public RemoveHouseRouter(AppMediator mediator) {
    this.mediator = mediator;
  }

}
