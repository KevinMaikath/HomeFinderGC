package es.ulpgc.maikath101.kevin.homefindergc.adminModeTests.removeHouse;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.lang.ref.WeakReference;

import es.ulpgc.maikath101.kevin.homefindergc.adminMode.login.LoginActivity;
import es.ulpgc.maikath101.kevin.homefindergc.adminMode.login.LoginContract;
import es.ulpgc.maikath101.kevin.homefindergc.adminMode.login.LoginPresenter;
import es.ulpgc.maikath101.kevin.homefindergc.adminMode.login.LoginState;
import es.ulpgc.maikath101.kevin.homefindergc.adminMode.removeHouse.RemoveHouseContract;
import es.ulpgc.maikath101.kevin.homefindergc.adminMode.removeHouse.RemoveHousePresenter;
import es.ulpgc.maikath101.kevin.homefindergc.adminMode.removeHouse.RemoveHouseState;
import es.ulpgc.maikath101.kevin.homefindergc.data.HouseRepositoryContract;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class RemoveHousePresenterMockitoTests {

  @Captor
  private ArgumentCaptor<HouseRepositoryContract.OnHouseDeletedCallback> onHouseDeletedCallbackArgumentCaptor;

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
  public void removeHouse() {
    configureRemoveHouseScreen(new RemoveHouseState());

    presenter.removeHouse(1);

    verify(modelMock).removeHouse(eq(1), onHouseDeletedCallbackArgumentCaptor.capture());
    onHouseDeletedCallbackArgumentCaptor.getValue().houseDeleted();

    verify(viewMock,times(1)).houseDeleted();
  }


}