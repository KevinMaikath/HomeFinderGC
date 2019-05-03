package es.ulpgc.maikath101.kevin.homefindergc.customerModeTests.drawer;

import android.app.Activity;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.lang.ref.WeakReference;


import es.ulpgc.maikath101.kevin.homefindergc.customerMode.drawer.DrawerActivity;
import es.ulpgc.maikath101.kevin.homefindergc.customerMode.drawer.DrawerContract;
import es.ulpgc.maikath101.kevin.homefindergc.customerMode.drawer.DrawerPresenter;

import static org.mockito.Mockito.ignoreStubs;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class DrawerPresenterMockitoTests {

  @Mock
  private DrawerContract.View viewMock;

  @Mock
  private DrawerContract.Router routerMock;

  private DrawerContract.Presenter presenter;


  @Before
  public void configureMockito() {

    // To inject the mocks in the test this method needs to be called
    MockitoAnnotations.initMocks(this);

    configureDrawerScreen();
  }

  private void configureDrawerScreen() {

    // Get a reference to the class under test
    presenter = new DrawerPresenter();

    presenter.injectView(new WeakReference<>(viewMock));
    presenter.injectRouter(routerMock);
  }

  @Test
  public void goToStart() {
    Activity activity = new DrawerActivity();

    presenter.goToStart(activity);

    verify(routerMock).navigateToStartScreen(activity);
  }

}