package es.ulpgc.maikath101.kevin.homefindergc.adminModeTests.removeHouse;

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

import es.ulpgc.maikath101.kevin.homefindergc.adminMode.login.LoginActivity;
import es.ulpgc.maikath101.kevin.homefindergc.adminMode.login.LoginContract;
import es.ulpgc.maikath101.kevin.homefindergc.adminMode.login.LoginPresenter;
import es.ulpgc.maikath101.kevin.homefindergc.adminMode.login.LoginState;
import es.ulpgc.maikath101.kevin.homefindergc.adminMode.removeHouse.RemoveHouseContract;
import es.ulpgc.maikath101.kevin.homefindergc.adminMode.removeHouse.RemoveHousePresenter;
import es.ulpgc.maikath101.kevin.homefindergc.adminMode.removeHouse.RemoveHouseState;
import es.ulpgc.maikath101.kevin.homefindergc.adminMode.removeHouse.RemoveHouseViewModel;
import es.ulpgc.maikath101.kevin.homefindergc.data.House;
import es.ulpgc.maikath101.kevin.homefindergc.data.HouseRepository;
import es.ulpgc.maikath101.kevin.homefindergc.data.HouseRepositoryContract;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class RemoveHousePresenterMockitoTests {

  @Captor
  private ArgumentCaptor<HouseRepositoryContract.OnHouseDeletedCallback> onHouseDeletedCallbackArgumentCaptor;

  @Captor
  private ArgumentCaptor<HouseRepositoryContract.GetAllHousesCallback> getAllHousesCallbackArgumentCaptor;

  @Captor
  private ArgumentCaptor<HouseRepositoryContract.GetImageFromHouseCallback> getImageFromHouseCallbackArgumentCaptor;

  @Mock
  private RemoveHouseContract.Model modelMock;

  @Mock
  private RemoveHouseContract.View viewMock;

  @Mock
  private RemoveHouseContract.Router routerMock;

  private RemoveHouseContract.Presenter presenter;

  @Before
  public void configureMockito() {

    // To inject the mocks in the test this method needs to be called
    MockitoAnnotations.initMocks(this);
  }

  private void configureRemoveHouseScreen(RemoveHouseState state) {

    // Get a reference to the class under test
    presenter = new RemoveHousePresenter(state);

    presenter.injectView(new WeakReference<>(viewMock));
    presenter.injectModel(modelMock);
    presenter.injectRouter(routerMock);
  }

  @Test
  public void removeHouseCompletely() {
    configureRemoveHouseScreen(new RemoveHouseState());

    presenter.removeHouse(1);

    verify(modelMock).removeHouse(eq(1), onHouseDeletedCallbackArgumentCaptor.capture());
    onHouseDeletedCallbackArgumentCaptor.getValue().houseDeleted();

    verify(viewMock,times(1)).houseDeleted();
  }

  @Test
  public void loadAllHouses() {
    configureRemoveHouseScreen(new RemoveHouseState());

    presenter.loadAllHouses();

    verify(modelMock).loadAllHouses(getAllHousesCallbackArgumentCaptor.capture());
    getAllHousesCallbackArgumentCaptor.getValue().setAllHouses(Mockito.<House>anyList());

    verify(viewMock, times(1)).displayData(Mockito.any(RemoveHouseViewModel.class));
  }


}