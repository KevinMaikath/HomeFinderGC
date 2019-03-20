package es.ulpgc.maikath101.kevin.homefindergc.app;

import android.content.Context;
import android.content.Intent;

import es.ulpgc.maikath101.kevin.homefindergc.customerMode.aboutUsScreen.AboutUsActivity;
import es.ulpgc.maikath101.kevin.homefindergc.customerMode.contactScreen.ContactActivity;
import es.ulpgc.maikath101.kevin.homefindergc.customerMode.startScreen.StartActivity;

public class AppCustomerRouter implements AppRouter{

    protected AppMediator mediator;

    public AppCustomerRouter(AppMediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public void navigateToStartScreen() {
        Context context = mediator.getApplicationContext();
        Intent intent = new Intent(context, StartActivity.class);
        //cambiar estado a Start
        context.startActivity(intent);
    }

    @Override
    public void navigateToForSaleScreen() {
        Context context = mediator.getApplicationContext();
        Intent intent = new Intent(context, StartActivity.class);
        //cambiar estado a For Sale
        context.startActivity(intent);
    }

    @Override
    public void navigateToForRentScreen() {
        Context context = mediator.getApplicationContext();
        Intent intent = new Intent(context, StartActivity.class);
        //cambiar estado a For Rent
        context.startActivity(intent);
    }

    @Override
    public void navigateToHolidayRentalScreen() {
        Context context = mediator.getApplicationContext();
        Intent intent = new Intent(context, StartActivity.class);
        //cambiar estado a Holiday Rental
        context.startActivity(intent);
    }

    @Override
    public void navigateToAboutUsScreen() {
        Context context = mediator.getApplicationContext();
        Intent intent = new Intent(context, AboutUsActivity.class);
        context.startActivity(intent);
    }

    @Override
    public void navigateToContactScreen() {
        Context context = mediator.getApplicationContext();
        Intent intent = new Intent(context, ContactActivity.class);
        context.startActivity(intent);
    }

}
