package es.ulpgc.maikath101.kevin.homefindergc.data;

import android.arch.persistence.room.Room;
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

import es.ulpgc.maikath101.kevin.homefindergc.database.HouseDao;
import es.ulpgc.maikath101.kevin.homefindergc.database.HousesDatabase;
import es.ulpgc.maikath101.kevin.homefindergc.database.ImageDao;
import es.ulpgc.maikath101.kevin.homefindergc.database.RentHouseDao;
import es.ulpgc.maikath101.kevin.homefindergc.database.SellHouseDao;
import es.ulpgc.maikath101.kevin.homefindergc.database.Sell_typeDao;

public class HouseRepository implements HouseRepositoryContract {

  public static String TAG = HouseRepository.class.getSimpleName();

  public static final String JSON_FILE = "housesCatalog.json";
  public static final String HOUSES_ROOT = "houses";
  public static final String SELL_TYPE_ROOT = "sell_type";
  public static final String HOUSE_SELL_ROOT = "house_sell";
  public static final String HOUSE_RENT_ROOT = "house_rent";
  public static final String IMAGES_ROOT = "images";

  public static final String DB_FILE = "housesDatabase.db";

  private static HouseRepository instance = null;
  private Context context;
  private HousesDatabase database;

  public static HouseRepository getInstance(Context context) {
    if (instance == null) {
      instance = new HouseRepository(context);
    }
    return instance;
  }

  private HouseRepository(Context context) {
    this.context = context;

//    database = Room.databaseBuilder(
//            context, HousesDatabase.class, DB_FILE
//    ).build();

    database = HousesDatabase.getInstance(context);
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
      JSONArray jsonArrayHouses = jsonObject.getJSONArray(HOUSES_ROOT);
      JSONArray jsonArraySellType = jsonObject.getJSONArray(SELL_TYPE_ROOT);
      JSONArray jsonArrayHouseSell = jsonObject.getJSONArray(HOUSE_SELL_ROOT);
      JSONArray jsonArrayHouseRent = jsonObject.getJSONArray(HOUSE_RENT_ROOT);
      JSONArray jsonArrayImages = jsonObject.getJSONArray(IMAGES_ROOT);


      if (jsonArrayHouses.length() > 0) {

        final List<House> houses = Arrays.asList(gson.fromJson(jsonArrayHouses.toString(), House[].class));

        final List<Sell_type> sell_types = Arrays.asList(gson.fromJson(jsonArraySellType.toString(), Sell_type[].class));

        final List<SellHouse> sellHouses = Arrays.asList(gson.fromJson(jsonArrayHouseSell.toString(), SellHouse[].class));

        final List<RentHouse> rentHouses = Arrays.asList(gson.fromJson(jsonArrayHouseRent.toString(), RentHouse[].class));

        final List<Image> images = Arrays.asList(gson.fromJson(jsonArrayImages.toString(), Image[].class));


        for (House house : houses) {
          getHouseDao().insert(house);
        }

        for (Sell_type sell_type : sell_types) {
          getSell_typeDao().insert(sell_type);
        }

        for (SellHouse sellHouse : sellHouses) {
          getSellHouseDao().insert(sellHouse);
        }

        for (RentHouse rentHouse : rentHouses) {
          getRentHouseDao().insert(rentHouse);
        }

        for (Image image : images) {
          getImageDao().insert(image);
        }

        return true;
      }

    } catch (JSONException error) {
      Log.e(TAG, "error: " + error);
    }

    return false;
  }


  private HouseDao getHouseDao() {
    return database.getHouseDao();
  }

  private ImageDao getImageDao() {
    return database.getImageDao();
  }

  private RentHouseDao getRentHouseDao() {
    return database.getRentHouseDao();
  }

  private Sell_typeDao getSell_typeDao() {
    return database.getSell_typeDao();
  }

  private SellHouseDao getSellHouseDao() {
    return database.getSellHouseDao();
  }


  @Override
  public void loadHousesInformation(final boolean clearFirst, final FetchHousesInformationCallback callback) {
    AsyncTask.execute(new Runnable() {
      @Override
      public void run() {
        if (clearFirst) {
          database.clearAllTables();
        }

        boolean error = false;
        if (getHouseDao().getForSaleHouses().size() == 0) {
          error = !loadCatalogFromJSON(loadJSONFromAsset());
        }

        if (callback != null) {
          callback.onHousesInformationFetched(error);
        }
      }
    });
  }

  @Override
  public void getForSaleHouses(final GetForSaleHousesCallback callback) {
    AsyncTask.execute(new Runnable() {
      @Override
      public void run() {
        if (callback != null) {
          callback.setForSaleHouses(getHouseDao().getForSaleHouses());
        }
      }
    });
  }

  @Override
  public void getForRentHouses(final GetForRentHousesCallback callback) {
    AsyncTask.execute(new Runnable() {
      @Override
      public void run() {
        if (callback != null) {
          callback.setForRentHouses(getHouseDao().getForRentHouses());
        }
      }
    });
  }

  @Override
  public void getHolidayRentalHouses(final GetHolidayRentalHousesCallback callback) {
    AsyncTask.execute(new Runnable() {
      @Override
      public void run() {
        if (callback != null) {
          callback.setHolidayRentalHouses(getHouseDao().getHolidayRentalHouses());
        }
      }
    });
  }

  @Override
  public void getAllHouses(final GetAllHousesCallback callback) {
    AsyncTask.execute(new Runnable() {
      @Override
      public void run() {
        if (callback != null) {
          callback.setAllHouses(getHouseDao().getAllHouses());
        }
      }
    });
  }

  @Override
  public void getStartHouses(final GetStartHousesCallback callback) {
    AsyncTask.execute(new Runnable() {
      @Override
      public void run() {
        if (callback != null){
          callback.setStartHouses(getHouseDao().getStartHouses());
        }
      }
    });
  }

  @Override
  public void insertHouse(House house) {

  }

  @Override
  public void getImage(final int id, final GetImageFromHouseCallback callback) {
    AsyncTask.execute(new Runnable() {
      @Override
      public void run() {
        if (callback != null) {
          callback.setImage(getImageDao().getImage(id));
        }
      }
    });
  }

}
