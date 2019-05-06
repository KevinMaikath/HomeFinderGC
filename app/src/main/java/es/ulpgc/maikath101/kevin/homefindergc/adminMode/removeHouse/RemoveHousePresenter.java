package es.ulpgc.maikath101.kevin.homefindergc.adminMode.removeHouse;

import es.ulpgc.maikath101.kevin.homefindergc.data.House;
import es.ulpgc.maikath101.kevin.homefindergc.data.HouseRepositoryContract;
import es.ulpgc.maikath101.kevin.homefindergc.data.Image;
import es.ulpgc.maikath101.kevin.homefindergc.data.SimpleHouse;

import android.util.Log;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;


public class RemoveHousePresenter implements RemoveHouseContract.Presenter {

  public static String TAG = RemoveHousePresenter.class.getSimpleName();

  private WeakReference<RemoveHouseContract.View> view;
  private RemoveHouseViewModel viewModel;
  private RemoveHouseContract.Model model;
  private RemoveHouseContract.Router router;

  public RemoveHousePresenter(RemoveHouseState state) {
    viewModel = state;
  }

  @Override
  public void injectView(WeakReference<RemoveHouseContract.View> view) {
    this.view = view;
  }

  @Override
  public void injectModel(RemoveHouseContract.Model model) {
    this.model = model;
  }

  @Override
  public void injectRouter(RemoveHouseContract.Router router) {
    this.router = router;
  }

  @Override
  public void loadAllHouses() {
    model.loadAllHouses(new HouseRepositoryContract.GetAllHousesCallback() {
      @Override
      public void setAllHouses(final List<House> houses) {
        // viewModel.houses = houses;

        final ArrayList<SimpleHouse> list = new ArrayList<>();
        for (int i = 0; i < houses.size(); i++) {
          final int finalI = i;
          model.loadImages(houses.get(i).main_image,
                  new HouseRepositoryContract.GetImageFromHouseCallback() {
                    @Override
                    public void setImage(Image image) {
                      if (image != null) {
                        SimpleHouse house = new SimpleHouse(houses.get(finalI).id_house,
                                houses.get(finalI).refNumber, houses.get(finalI).name,
                                image.url, houses.get(finalI).price, houses.get(finalI).id_sell_type,
                                image.imageUri);
                        Log.e(TAG, String.valueOf(image.url));
                        list.add(house);
                      }
                      //viewModel.simpleHouses.add(house);
                    }
                  });
        }
        viewModel.simpleHouses = list;
        Log.e(TAG, String.valueOf(viewModel.simpleHouses.size()));
        view.get().displayData(viewModel);
      }
    });

  }

  @Override
  public void removeHouse(int id_house) {
    model.removeHouse(id_house, new HouseRepositoryContract.OnHouseDeletedCallback() {
      @Override
      public void houseDeleted() {
        view.get().houseDeleted();
      }
    });
  }


}
