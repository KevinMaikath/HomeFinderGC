package es.ulpgc.maikath101.kevin.homefindergc.customerModeTests.drawer;

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

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class DrawerPresenterMockitoTests {

  @Mock
  private DrawerContract.View viewMock;

  @Mock
  private DrawerContract.Router routerMock;

  @Mock
  private DrawerActivity drawerActivity;

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
    doNothing().when(drawerActivity).finish();
    presenter.goToStart(drawerActivity);

    verify(routerMock).navigateToStartScreen(drawerActivity);
  }

  @Test
  public void goToForSale() {
    doNothing().when(drawerActivity).finish();
    presenter.goToForSale(drawerActivity);

    verify(routerMock).navigateToForSaleScreen(drawerActivity);
  }

  @Test
  public void goToForRent() {
    doNothing().when(drawerActivity).finish();
    presenter.goToForRent(drawerActivity);

    verify(routerMock).navigateToForRentScreen(drawerActivity);
  }

  @Test
  public void goToHolidayRental() {
    doNothing().when(drawerActivity).finish();
    presenter.goToHolidayRental(drawerActivity);

    verify(routerMock).navigateToHolidayRentalScreen(drawerActivity);
  }

  @Test
  public void goToAboutUs() {
    doNothing().when(drawerActivity).finish();
    presenter.goToAboutUs(drawerActivity);

    verify(routerMock).navigateToAboutUsScreen(drawerActivity);
  }

  @Test
  public void goToContact() {
    doNothing().when(drawerActivity).finish();
    presenter.goToContact(drawerActivity);

    verify(routerMock).navigateToContactScreen(drawerActivity);
  }

  @Test
  public void onBackPressed() {
    doNothing().when(drawerActivity).finish();
    presenter.onBackPressed(drawerActivity);

    verify(routerMock).navigateToStartScreen(drawerActivity);
  }

}