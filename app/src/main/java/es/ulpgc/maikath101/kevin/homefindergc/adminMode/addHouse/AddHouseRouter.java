package es.ulpgc.maikath101.kevin.homefindergc.adminMode.addHouse;

import android.provider.MediaStore;
import android.util.Log;
import android.content.Intent;
import android.content.Context;

import es.ulpgc.maikath101.kevin.homefindergc.app.AppMediator;

import static android.support.v4.app.ActivityCompat.startActivityForResult;

public class AddHouseRouter implements AddHouseContract.Router {

  public static String TAG = AddHouseRouter.class.getSimpleName();



  private AppMediator mediator;

  public AddHouseRouter(AppMediator mediator) {
    this.mediator = mediator;
  }

  @Override
  public void navigateToNextScreen() {
    Context context = mediator.getApplicationContext();
    Intent intent = new Intent(context, AddHouseActivity.class);
    context.startActivity(intent);
  }

  @Override
  public void passDataToNextScreen(AddHouseState state) {
    mediator.setAddHouseState(state);
  }

  @Override
  public AddHouseState getDataFromPreviousScreen() {
    AddHouseState state = mediator.getAddHouseState();
    return state;
  }

  @Override
  public void openGallery() {
    /*Context context = mediator.getApplicationContext();
    Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
    context.startActivity(intent);*/


  }
}
