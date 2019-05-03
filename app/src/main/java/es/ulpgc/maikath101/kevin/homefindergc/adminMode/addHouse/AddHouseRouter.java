package es.ulpgc.maikath101.kevin.homefindergc.adminMode.addHouse;

import android.app.Activity;
import android.content.Intent;
import android.provider.MediaStore;

import es.ulpgc.maikath101.kevin.homefindergc.app.AppMediator;

public class AddHouseRouter implements AddHouseContract.Router {

  public static String TAG = AddHouseRouter.class.getSimpleName();

  private static final int PICK_IMAGE = 100;

  private AppMediator mediator;

  public AddHouseRouter(AppMediator mediator) {
    this.mediator = mediator;
  }


  @Override
  public void openGallery(Activity activity) {
    Intent gallery = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
    gallery.setFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
    activity.startActivityForResult(gallery, PICK_IMAGE);
  }
}
