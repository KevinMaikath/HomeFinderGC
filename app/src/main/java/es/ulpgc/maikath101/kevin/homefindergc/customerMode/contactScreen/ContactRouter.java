package es.ulpgc.maikath101.kevin.homefindergc.customerMode.contactScreen;

import android.content.Intent;
import android.content.Context;

import es.ulpgc.maikath101.kevin.homefindergc.app.AppCustomerRouter;
import es.ulpgc.maikath101.kevin.homefindergc.app.AppMediator;

public class ContactRouter extends AppCustomerRouter implements ContactContract.Router {

  public static String TAG = ContactRouter.class.getSimpleName();

  public ContactRouter(AppMediator mediator) {
    super(mediator);
  }

}
