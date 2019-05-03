package es.ulpgc.maikath101.kevin.homefindergc.adminModeTests.addHouse;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.lang.ref.WeakReference;

import es.ulpgc.maikath101.kevin.homefindergc.adminMode.addHouse.AddHouseContract;
import es.ulpgc.maikath101.kevin.homefindergc.adminMode.addHouse.AddHousePresenter;
import es.ulpgc.maikath101.kevin.homefindergc.adminMode.addHouse.AddHouseState;
import es.ulpgc.maikath101.kevin.homefindergc.adminMode.login.LoginContract;
import es.ulpgc.maikath101.kevin.homefindergc.adminMode.login.LoginPresenter;
import es.ulpgc.maikath101.kevin.homefindergc.adminMode.login.LoginState;

import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class AddHousePresenterMockitoTests {


  private static final String HELLO_STRING = "Hello World!";
  private static final String BYE_STRING = "Bye World!";
  private static final String EMPTY_STRING = "";

  @Mock
  private AddHouseContract.Model modelMock;

  @Mock
  private AddHouseContract.View viewMock;

  @Mock
  private AddHouseContract.Router routerMock;

  private AddHouseContract.Presenter presenter;


  @Before
  public void configureMockito() {

    // To inject the mocks in the test this method needs to be called
    MockitoAnnotations.initMocks(this);
  }

  private void configureAddHouseScreen(AddHouseState state) {

    // Get a reference to the class under test
    presenter = new AddHousePresenter(state);

    presenter.injectView(new WeakReference<>(viewMock));
    presenter.injectModel(modelMock);
    presenter.injectRouter(routerMock);
  }

  @Test
  public void navigateToSelectionScreen() {
    // Given an initialized HelloPresenter
    // and a hello message as passed state to ByePresenter
    configureAddHouseScreen(new AddHouseState());

    //
  }

}