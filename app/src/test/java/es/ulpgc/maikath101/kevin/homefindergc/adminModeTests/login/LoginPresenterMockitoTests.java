package es.ulpgc.maikath101.kevin.homefindergc.adminModeTests.login;

import android.app.Activity;

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

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class LoginPresenterMockitoTests {

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
  public void navigateToSelectionScreenRightCredentials() {
    configureLoginScreen(new LoginState());

    // When start a new screen is requested
    String user = "admin";
    String passwd = "1234";
    LoginActivity activity = new LoginActivity();

    when(modelMock.checkCredentials(user,passwd)).thenReturn(true);
    when(presenter.getActivity()).thenReturn(activity);

    presenter.onSignInPressed(user, passwd);

    verify(routerMock, times(1)).navigateToNextScreen(activity);
  }

  @Test
  public void navigateToSelectionScreenWrongCredentials() {

    configureLoginScreen(new LoginState());

    String user = "admi";
    String passwd = "1234";

    when(modelMock.checkCredentials(user,passwd)).thenReturn(false);
    presenter.onSignInPressed(user, passwd);

    verify(viewMock, times(1)).wrongCredentials();
  }

  @Test
  public void noNavigateWhenButtonNotPressed() {
    configureLoginScreen(new LoginState());

    LoginActivity activity = new LoginActivity();

    verify(routerMock, times(0)).navigateToNextScreen(activity);


  }
}