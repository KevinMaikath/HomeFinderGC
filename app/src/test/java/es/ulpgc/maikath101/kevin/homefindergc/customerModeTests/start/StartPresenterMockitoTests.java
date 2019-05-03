package es.ulpgc.maikath101.kevin.homefindergc.customerModeTests.start;

import android.app.Activity;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.lang.ref.WeakReference;
import java.util.List;

import es.ulpgc.maikath101.kevin.homefindergc.R;
import es.ulpgc.maikath101.kevin.homefindergc.customerMode.homeDetails.HomeDetailsState;
import es.ulpgc.maikath101.kevin.homefindergc.customerMode.startScreen.StartActivity;
import es.ulpgc.maikath101.kevin.homefindergc.customerMode.startScreen.StartContract;
import es.ulpgc.maikath101.kevin.homefindergc.customerMode.startScreen.StartPresenter;
import es.ulpgc.maikath101.kevin.homefindergc.customerMode.startScreen.StartState;
import es.ulpgc.maikath101.kevin.homefindergc.data.House;
import es.ulpgc.maikath101.kevin.homefindergc.data.HouseRepositoryContract;
import es.ulpgc.maikath101.kevin.homefindergc.data.SimpleHouse;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class StartPresenterMockitoTests {

  @Mock
  private StartContract.Model modelMock;

  @Mock
  private StartContract.View viewMock;

  @Mock
  private StartContract.Router routerMock;

  private StartContract.Presenter presenter;


  @Before
  public void configureMockito() {

    // To inject the mocks in the test this method needs to be called
    MockitoAnnotations.initMocks(this);
  }

  private void configureLoginScreen(StartState state) {

    // Get a reference to the class under test
    presenter = new StartPresenter(state);

    presenter.injectStartView(new WeakReference<>(viewMock));
    presenter.injectModel(modelMock);
    presenter.injectRouter(routerMock);
  }

  @Test
  public void checkCurrentScreenAsStart() {
    StartState state_start = new StartState();
    state_start.currentScreen = "Start";
    configureLoginScreen(state_start);

    // When start a new screen is requested

    presenter.checkCurrentScreen();

    // TODO EQUISDEE
  }

  @Test
  public void fetchData() {
    StartState state = new StartState();
    configureLoginScreen(state);

    presenter.fetchData();

    verify(viewMock).displayData(state);
  }

  @Test
  public void selectHouse() {
    StartState state = new StartState();
    configureLoginScreen(state);

    Activity activity = new StartActivity();

    SimpleHouse house = new SimpleHouse(111, "Ref", "name",
            "url", "price", 111, "uri");

    HomeDetailsState home_state = new HomeDetailsState();
    home_state.forSale = true;
    home_state.current_house_id = 111;

    presenter.selectHouse(activity, house);

    verify(routerMock).passDataToHomeDetailScreen(home_state);
    verify(routerMock).navigateToHomeDetailScreen(activity);
  }

  @Test
  public void navigateToSelectionScreenWrongCredentials() {

    configureLoginScreen(new StartState());
/**
 String user = "admi";
 String passwd = "1234";

 when(modelMock.checkCredentials(user,passwd)).thenReturn(false);
 presenter.onSignInPressed(user, passwd);

 verify(viewMock, times(1)).wrongCredentials();
 **/
  }
}