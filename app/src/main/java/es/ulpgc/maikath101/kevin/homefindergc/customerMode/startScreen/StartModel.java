package es.ulpgc.maikath101.kevin.homefindergc.customerMode.startScreen;

import android.util.Log;

import java.lang.ref.WeakReference;

import android.support.v7.app.AppCompatActivity;
import android.support.v4.app.FragmentActivity;

import es.ulpgc.maikath101.kevin.homefindergc.data.HouseRepository;
import es.ulpgc.maikath101.kevin.homefindergc.data.HouseRepositoryContract;

public class StartModel implements StartContract.Model {

  public static String TAG = StartModel.class.getSimpleName();
  private HouseRepository repository;

  public StartModel(HouseRepository repository) {
    this.repository = repository;
  }


  @Override
  public void fetchJSONData(final HouseRepository.FetchOnSaleHousesDataCallback callback) {

    repository.fetchHousesCatalog(new HouseRepositoryContract.FetchHousesCatalogCallback() {
      @Override
      public void onHousesCatalogLoaded(boolean error) {
        if (!error) {
          repository.getOnSaleHousesList(callback);
        }
      }
    });
  }
}
