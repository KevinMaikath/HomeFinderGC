package es.ulpgc.maikath101.kevin.homefindergc.customerMode.aboutUsScreen;

public class AboutUsModel implements AboutUsContract.Model {

  public static String TAG = AboutUsModel.class.getSimpleName();

  public AboutUsModel() {

  }

  @Override
  public String fetchData() {
    // Log.e(TAG, "fetchData()");
    return "Hello";
  }
}
