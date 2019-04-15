package es.ulpgc.maikath101.kevin.homefindergc.adminModeTests.login;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.lang.ref.WeakReference;

import es.ulpgc.maikath101.kevin.homefindergc.adminMode.login.LoginContract;
import es.ulpgc.maikath101.kevin.homefindergc.adminMode.login.LoginPresenter;
import es.ulpgc.maikath101.kevin.homefindergc.adminMode.login.LoginState;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class LoginPresenterMockitoTests {


  private static final String HELLO_STRING = "Hello World!";
  private static final String BYE_STRING = "Bye World!";
  private static final String EMPTY_STRING = "";

  @Mock
  private LoginContract.Model modelMock;

  @Mock
  private LoginContract.View viewMock;

  @Mock
  private LoginContract.Router routerMock;

  private LoginContract.Presenter presenter;


  @Before
  public void configureMockito() {

    // To inject the mocks in the test this method needs to be called
    MockitoAnnotations.initMocks(this);
  }

  private void configureLoginScreen(LoginState state) {

    // Get a reference to the class under test
    presenter = new LoginPresenter(state);

    presenter.injectView(new WeakReference<>(viewMock));
    presenter.injectModel(modelMock);
    presenter.injectRouter(routerMock);
  }

  @Test
  public void navigateToSelectionScreen() {
    // Given an initialized HelloPresenter
    // and a hello message as passed state to ByePresenter
    configureLoginScreen(new LoginState());

    // When start a new screen is requested
    presenter.navigateToNextScreen();


    // Then router is called to pass the state and start the new screen
    verify(routerMock, times(1)).navigateToNextScreen();
    verify(routerMock, never()).getDataFromPreviousScreen();
  }

}