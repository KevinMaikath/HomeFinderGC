package es.ulpgc.maikath101.kevin.homefindergc.customerMode.contactScreen;

import android.content.Intent;
import android.content.Context;

import es.ulpgc.maikath101.kevin.homefindergc.app.AppMediator;

public class ContactRouter implements ContactContract.Router {

    public static String TAG = ContactRouter.class.getSimpleName();

    private AppMediator mediator;

    public ContactRouter(AppMediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public void navigateToNextScreen() {
        Context context = mediator.getApplicationContext();
        Intent intent = new Intent(context, ContactActivity.class);
        context.startActivity(intent);
    }

    @Override
    public void passDataToNextScreen(ContactState state) {
        mediator.setContactState(state);
    }

    @Override
    public ContactState getDataFromPreviousScreen() {
        ContactState state = mediator.getContactState();
        return state;
    }
}
