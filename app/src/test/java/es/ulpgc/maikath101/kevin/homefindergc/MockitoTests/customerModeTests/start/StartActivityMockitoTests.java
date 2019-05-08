package es.ulpgc.maikath101.kevin.homefindergc.MockitoTests.customerModeTests.start;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import es.ulpgc.maikath101.kevin.homefindergc.customerMode.startScreen.StartActivity;
import es.ulpgc.maikath101.kevin.homefindergc.customerMode.startScreen.StartContract;
import es.ulpgc.maikath101.kevin.homefindergc.customerMode.startScreen.StartState;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class StartActivityMockitoTests {

  @Mock
  private StartContract.View viewMock;

  @Mock
  private StartContract.Presenter presenterMock;

  private StartActivity startActivity;


  @Before
  public void configureMockito() {
    // To inject the mocks in the test this method needs to be called
    MockitoAnnotations.initMocks(this);

    configureStartScreen();
  }

  private void configureStartScreen() {
    startActivity = new StartActivity();

    startActivity.injectPresenter(presenterMock);
  }

  @Test
  public void onBackPressed() {
    startActivity.onBackPressed();

    verify(presenterMock).onBackPressed(startActivity);
  }



}