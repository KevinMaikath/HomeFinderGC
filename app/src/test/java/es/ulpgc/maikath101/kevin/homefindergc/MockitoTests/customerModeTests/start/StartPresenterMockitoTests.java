package es.ulpgc.maikath101.kevin.homefindergc.MockitoTests.customerModeTests.start;

import android.app.Activity;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.lang.ref.WeakReference;

import es.ulpgc.maikath101.kevin.homefindergc.customerMode.homeDetails.HomeDetailsState;
import es.ulpgc.maikath101.kevin.homefindergc.customerMode.startScreen.StartActivity;
import es.ulpgc.maikath101.kevin.homefindergc.customerMode.startScreen.StartContract;
import es.ulpgc.maikath101.kevin.homefindergc.customerMode.startScreen.StartPresenter;
import es.ulpgc.maikath101.kevin.homefindergc.customerMode.startScreen.StartState;
import es.ulpgc.maikath101.kevin.homefindergc.data.SimpleHouse;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

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

  private void configureStartScreen(StartState state) {

    // Get a reference to the class under test
//    presenter = spy(new StartPresenter(state));
    presenter = new StartPresenter(state);


    presenter.injectStartView(new WeakReference<>(viewMock));
    presenter.injectModel(modelMock);
    presenter.injectRouter(routerMock);
  }

  @Test
  public void fetchData() {
    StartState state = new StartState();
    configureStartScreen(state);

    presenter.fetchData();

    verify(viewMock).displayData(state);
  }

  @Test
  public void checkCurrentScreenTrueChangedScreen() {
    StartState state = new StartState();
    state.changedScreen = true;
    configureStartScreen(state);

    presenter.checkCurrentScreen();

    verify(viewMock, times(0)).displayData(state);
  }

  @Test
  public void checkCurrentScreenFalseChangedScreen() {
    StartState state = new StartState();
    state.changedScreen = false;
    configureStartScreen(state);

    presenter.checkCurrentScreen();

    verify(viewMock).displayData(state);
  }

  @Test
  public void selectHouse() {
    StartState state = new StartState();
    configureStartScreen(state);

    Activity activity = new StartActivity();

    SimpleHouse house = new SimpleHouse(1, "Ref", "name",
            "url", "price", 111, "uri");

/**
 HomeDetailsState mockState = mock(HomeDetailsState.class);
 **/
    HomeDetailsState home_state = new HomeDetailsState();
    home_state.forSale = true;
    home_state.current_house_id = house.house_id;

    presenter.selectHouse(activity, house);

    //verify(routerMock).passDataToHomeDetailScreen(home_state);
    verify(routerMock).navigateToHomeDetailScreen(activity);
  }

  @Test
  public void onBackPressedStateIsStart() {
    StartActivity startActivity = mock(StartActivity.class);

    StartState state = new StartState();
    state.currentScreen = "Start";
    configureStartScreen(state);

    presenter.onBackPressed(startActivity);

    verify(startActivity).finish();
  }

  @Test
  public void onBackPressedStateIsNotStart() {
    StartActivity startActivity = mock(StartActivity.class);

    StartState state = new StartState();
    state.currentScreen = "For Sale";
    configureStartScreen(state);

    presenter.onBackPressed(startActivity);

    verify(startActivity, times(0)).finish();
  }

}