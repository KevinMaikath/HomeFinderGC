package es.ulpgc.maikath101.kevin.homefindergc.customerMode.homeDetails;

public class HomeDetailsModel implements HomeDetailsContract.Model {

  public static String TAG = HomeDetailsModel.class.getSimpleName();

  private String summary_info = "Información de resumen";
  private String description_info = "Descripción de la casa";
  private String location_info = "Información sobre la localización";
  private String distribution_info = "Información sobre la distribución";

  public HomeDetailsModel() {

  }

  @Override
  public String fetchData() {
    // Log.e(TAG, "fetchData()");
    return "Hello";
  }

  @Override
  public String changeToSummaryInfo() {
    return summary_info;
  }

  @Override
  public String changeToDescriptionInfo() {
    return description_info;
  }

  @Override
  public String changeToLocationInfo() {
    return location_info;
  }

  @Override
  public String changeToDistributionInfo() {
    return distribution_info;
  }
}
