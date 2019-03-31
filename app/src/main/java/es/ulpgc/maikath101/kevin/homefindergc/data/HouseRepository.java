package es.ulpgc.maikath101.kevin.homefindergc.data;

import android.content.Context;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HouseRepository implements HouseRepositoryContract {

  public static String TAG = HouseRepository.class.getSimpleName();

  public static final String JSON_FILE = "housesCatalog.json";
  public static final String JSON_ROOT = "categories";

  private static HouseRepository instance = null;
  private Context context;

  private List<HolidayRentalHouse> holidayRentalHouseList;
  private List<RentHouse> rentHouseList;
  private List<SaleHouse> saleHouseList;

  public static HouseRepository getInstance(Context context) {
    if (instance == null) {
      instance = new HouseRepository(context);
    }
    return instance;
  }

  private HouseRepository(Context context) {
    this.context = context;
    holidayRentalHouseList = new ArrayList<>();
    rentHouseList = new ArrayList<>();
    saleHouseList = new ArrayList<>();
  }

  private String loadJSONFromAsset() {
    //Log.e(TAG, "loadJSONFromAsset()");

    String json = null;

    try {

      InputStream is = context.getAssets().open(JSON_FILE);
      int size = is.available();
      byte[] buffer = new byte[size];
      is.read(buffer);
      is.close();
      json = new String(buffer, "UTF-8");

    } catch (IOException error) {
      Log.e(TAG, "error: " + error);
    }

    return json;
  }

  private boolean loadCatalogFromJSON(String json) {
    Log.e(TAG, "loadCatalogFromJSON()");

    GsonBuilder gsonBuilder = new GsonBuilder();
    Gson gson = gsonBuilder.create();

    try {

      JSONObject jsonObject = new JSONObject(json);
      JSONArray jsonArray = jsonObject.getJSONArray(JSON_ROOT);

      holidayRentalHouseList = new ArrayList();

      if (jsonArray.length() > 0) {

        final List<HolidayRentalHouse> holidayRentalHouses = Arrays.asList(
                gson.fromJson(jsonArray.toString(), HolidayRentalHouse[].class)
        );

        final List<RentHouse> rentHouses = Arrays.asList(gson.fromJson(jsonArray.toString(), RentHouse[].class));

        final List<SaleHouse> saleHouses = Arrays.asList(gson.fromJson(jsonArray.toString(), SaleHouse[].class));


        for (HolidayRentalHouse holidayRentalHouse : holidayRentalHouses) {
          insertHolidayRentalHouse(holidayRentalHouse);
        }

        for (RentHouse rentHouse : rentHouses) {
          insertRentHouse(rentHouse);
        }

        for (SaleHouse saleHouse : saleHouses) {
          insertSaleHouse(saleHouse);
        }

        return true;
      }

    } catch (JSONException error) {
      Log.e(TAG, "error: " + error);
    }

    return false;
  }

  private void insertSaleHouse(SaleHouse saleHouse) {
    this.saleHouseList.add(saleHouse);
  }

  private void insertRentHouse(RentHouse rentHouse) {
    this.rentHouseList.add(rentHouse);
  }

  private void insertHolidayRentalHouse(HolidayRentalHouse holidayRentalHouse) {
    this.holidayRentalHouseList.add(holidayRentalHouse);
  }


  @Override
  public void fetchHousesCatalog(FetchHousesCatalogCallback callback) {

  }

  @Override
  public void getOnSaleHousesList(FetchOnSaleHousesDataCallback callback) {

  }

  @Override
  public void getOnRentHousesList(FetchOnRentHousesDataCallback callback) {

  }

  @Override
  public void getOnHolidayRentalHousesList(FetchOnHolidayRentalHousesDataCallback callback) {

  }

  @Override
  public void getOnSaleHouseDetail(int id, FetchOnSaleHouseDetailCallback callback) {

  }

  @Override
  public void getOnRentHouseDetail(int id, FetchOnRentHouseDetailCallback callback) {

  }

  @Override
  public void getOnHolidayRentalHouseDetail(int id, FetchOnHolidayRentalHouseDetailCallback callback) {

  }
}
