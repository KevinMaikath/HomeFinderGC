package es.ulpgc.maikath101.kevin.homefindergc.data;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HouseRepository implements HouseRepositoryContract {

  public static String TAG = HouseRepository.class.getSimpleName();

  public static final String JSON_FILE = "housesCatalog.json";
  public static final String JSON_RENT_HOUSES_ROOT = "forRentHouses";
  public static final String JSON_SALE_HOUSES_ROOT = "forSaleHouses";
  public static final String JSON_HOLIDAY_RENTAL_HOUSES_ROOT = "forHolidayRentalHouses";

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
      JSONArray jsonArrayRentHouses = jsonObject.getJSONArray(JSON_RENT_HOUSES_ROOT);
      JSONArray jsonArraySaleHouses = jsonObject.getJSONArray(JSON_SALE_HOUSES_ROOT);
      JSONArray jsonArrayHolidayRentalHouses = jsonObject.getJSONArray(JSON_HOLIDAY_RENTAL_HOUSES_ROOT);


      if (jsonArrayHolidayRentalHouses.length() > 0) {

        final List<HolidayRentalHouse> holidayRentalHouses = Arrays.asList(
                gson.fromJson(jsonArrayHolidayRentalHouses.toString(), HolidayRentalHouse[].class)
        );

        final List<RentHouse> rentHouses = Arrays.asList(gson.fromJson(jsonArrayRentHouses.toString(), RentHouse[].class));

        final List<SaleHouse> saleHouses = Arrays.asList(gson.fromJson(jsonArraySaleHouses.toString(), SaleHouse[].class));


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

  private SaleHouse getSaleHouseDetail(int id) {
    for (int i = 0; i < saleHouseList.size(); i++) {
      if (id == saleHouseList.get(i).getId()) {
        return saleHouseList.get(i);
      }
    }
    return null;
  }

  private RentHouse getRentHouseDetail(int id) {
    for (int i = 0; i < rentHouseList.size(); i++) {
      if (id == rentHouseList.get(i).getId()) {
        return rentHouseList.get(i);
      }
    }
    return null;
  }

  private HolidayRentalHouse getHolidayRentalDetail(int id) {
    for (int i = 0; i < holidayRentalHouseList.size(); i++) {
      if (id == holidayRentalHouseList.get(i).getId()) {
        return holidayRentalHouseList.get(i);
      }
    }
    return null;
  }


  @Override
  public void fetchHousesCatalog(final FetchHousesCatalogCallback callback) {
    AsyncTask.execute(new Runnable() {
      @Override
      public void run() {
        boolean error = !loadCatalogFromJSON(loadJSONFromAsset());

        if (callback != null) {
          callback.onHousesCatalogLoaded(error);
          Log.e(TAG, "Hay " + holidayRentalHouseList.size() + " holiday rental houses");
          Log.e(TAG, "Hay " + holidayRentalHouseList.get(1).getImagenes().size()+ " imagenes");
          Log.e(TAG, "Hay " + saleHouseList.size() + " sale houses");
          Log.e(TAG, "Hay " + rentHouseList.size() + " rent houses");
        }
      }
    });

  }

  @Override
  public void getOnSaleHousesList(final FetchOnSaleHousesDataCallback callback) {
    AsyncTask.execute(new Runnable() {
      @Override
      public void run() {
        if (callback != null) {
          callback.setOnSaleHouses(saleHouseList);
        }
      }
    });
  }

  @Override
  public void getOnRentHousesList(final FetchOnRentHousesDataCallback callback) {
    AsyncTask.execute(new Runnable() {
      @Override
      public void run() {
        if (callback != null) {
          callback.setOnRentHouses(rentHouseList);
        }
      }
    });
  }

  @Override
  public void getOnHolidayRentalHousesList(final FetchOnHolidayRentalHousesDataCallback callback) {
    AsyncTask.execute(new Runnable() {
      @Override
      public void run() {
        if (callback != null) {
          callback.setOnHolidayRentalHouses(holidayRentalHouseList);
        }
      }
    });
  }

  @Override
  public void getOnSaleHouseDetail(final int id, final FetchOnSaleHouseDetailCallback callback) {
    AsyncTask.execute(new Runnable() {
      @Override
      public void run() {
        if (callback != null) {
          callback.setOnSaleHouseDetail(getSaleHouseDetail(id));
        }
      }
    });
  }

  @Override
  public void getOnRentHouseDetail(final int id, final FetchOnRentHouseDetailCallback callback) {
    AsyncTask.execute(new Runnable() {
      @Override
      public void run() {
        if (callback != null) {
          callback.setOnRentHouseDetail(getRentHouseDetail(id));
        }
      }
    });
  }

  @Override
  public void getOnHolidayRentalHouseDetail(final int id, final FetchOnHolidayRentalHouseDetailCallback callback) {
    AsyncTask.execute(new Runnable() {
      @Override
      public void run() {
        if (callback != null) {
          callback.setOnHolidayRentalHouseDetail(getHolidayRentalDetail(id));
        }
      }
    });
  }
}
