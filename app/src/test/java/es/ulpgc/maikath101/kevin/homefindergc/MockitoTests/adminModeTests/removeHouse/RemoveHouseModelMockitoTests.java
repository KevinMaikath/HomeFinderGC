package es.ulpgc.maikath101.kevin.homefindergc.MockitoTests.adminModeTests.removeHouse;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.lang.ref.WeakReference;
import java.util.List;

import es.ulpgc.maikath101.kevin.homefindergc.adminMode.removeHouse.RemoveHouseContract;
import es.ulpgc.maikath101.kevin.homefindergc.adminMode.removeHouse.RemoveHouseModel;
import es.ulpgc.maikath101.kevin.homefindergc.adminMode.removeHouse.RemoveHousePresenter;
import es.ulpgc.maikath101.kevin.homefindergc.adminMode.removeHouse.RemoveHouseState;
import es.ulpgc.maikath101.kevin.homefindergc.adminMode.removeHouse.RemoveHouseViewModel;
import es.ulpgc.maikath101.kevin.homefindergc.data.House;
import es.ulpgc.maikath101.kevin.homefindergc.data.HouseRepositoryContract;
import es.ulpgc.maikath101.kevin.homefindergc.data.Image;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class RemoveHouseModelMockitoTests {

  @Captor
  private ArgumentCaptor<HouseRepositoryContract.FetchHousesInformationCallback> fetchHousesInformationCallbackArgumentCaptor;

  private RemoveHouseContract.Model model;

  @Mock
  private HouseRepositoryContract repository;

  private HouseRepositoryContract.GetAllHousesCallback callback
          = new HouseRepositoryContract.GetAllHousesCallback() {
    @Override
    public void setAllHouses(List<House> houses) {

    }
  };

  private HouseRepositoryContract.GetImageFromHouseCallback callbackImage
          = new HouseRepositoryContract.GetImageFromHouseCallback() {
    @Override
    public void setImage(Image image) {

    }
  };

  private HouseRepositoryContract.OnHouseDeletedCallback callbackDelete
          = new HouseRepositoryContract.OnHouseDeletedCallback() {
    @Override
    public void houseDeleted() {

    }
  };

  @Before
  public void configureMockito() {

    // To inject the mocks in the test this method needs to be called
    MockitoAnnotations.initMocks(this);
  }

  private void configureRemoveHouseScreen() {

    // Get a reference to the class under test
    model = new RemoveHouseModel(repository);
  }

  @Test
  public void loadAllHouses() {
    configureRemoveHouseScreen();

    model.loadAllHouses(callback);
    verify(repository).loadHousesInformation(eq(true)
            , fetchHousesInformationCallbackArgumentCaptor.capture());
    fetchHousesInformationCallbackArgumentCaptor.getValue().onHousesInformationFetched(false);
    verify(repository).getAllHouses(callback);
  }

  @Test
  public void loadAllHousesWithError() {
    configureRemoveHouseScreen();

    model.loadAllHouses(callback);
    verify(repository).loadHousesInformation(eq(true)
            , fetchHousesInformationCallbackArgumentCaptor.capture());
    fetchHousesInformationCallbackArgumentCaptor.getValue().onHousesInformationFetched(true);
    verify(repository,times(0)).getAllHouses(callback);
  }

  @Test
  public void loadImages() {
    configureRemoveHouseScreen();

    model.loadImages(1, callbackImage);

    verify(repository).getImage(1, callbackImage);
  }

  @Test
  public void removeHouse() {
    configureRemoveHouseScreen();

    model.removeHouse(1, callbackDelete);

    verify(repository).deleteHouse(1, callbackDelete);

  }




}