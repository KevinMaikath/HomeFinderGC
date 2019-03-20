package es.ulpgc.maikath101.kevin.homefindergc.customerMode.aboutUsScreen;

import es.ulpgc.maikath101.kevin.homefindergc.app.AppCustomerRouter;
import es.ulpgc.maikath101.kevin.homefindergc.app.AppMediator;

public class AboutUsRouter extends AppCustomerRouter implements AboutUsContract.Router {

    public static String TAG = AboutUsRouter.class.getSimpleName();


    public AboutUsRouter(AppMediator mediator) {
         super(mediator);
    }

}
