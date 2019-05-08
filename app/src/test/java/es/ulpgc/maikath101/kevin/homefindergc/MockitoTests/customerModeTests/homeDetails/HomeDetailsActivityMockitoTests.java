package es.ulpgc.maikath101.kevin.homefindergc.MockitoTests.customerModeTests.homeDetails;

import android.view.View;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import es.ulpgc.maikath101.kevin.homefindergc.customerMode.homeDetails.HomeDetailsActivity;
import es.ulpgc.maikath101.kevin.homefindergc.customerMode.homeDetails.HomeDetailsContract;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class HomeDetailsActivityMockitoTests {

  @Mock
  private View exampleView;

  @Mock
  private HomeDetailsContract.Presenter presenterMock;

  private HomeDetailsActivity homeDetailsActivity;


  @Before
  public void configureMockito() {
    // To inject the mocks in the test this method needs to be called
    MockitoAnnotations.initMocks(this);

    configureHomeDetailsScreen();
  }

  private void configureHomeDetailsScreen() {
    homeDetailsActivity = new HomeDetailsActivity();

    homeDetailsActivity.injectPresenter(presenterMock);
  }

  @Test
  public void onSummaryButtonClicked(){
    homeDetailsActivity.onSummaryButtonClicked(exampleView);

    verify(presenterMock).summaryButtonClicked();
  }

  @Test
  public void onDescriptionButtonClicked(){
    homeDetailsActivity.onDescriptionButtonClicked(exampleView);

    verify(presenterMock).descriptionButtonClicked();
  }

  @Test
  public void onLocationButtonClicked(){
    homeDetailsActivity.onLocationButtonClicked(exampleView);

    verify(presenterMock).locationButtonClicked();
  }

  @Test
  public void onDistributionButtonClicked(){
    homeDetailsActivity.onDistributionButtonClicked(exampleView);

    verify(presenterMock).distributionButtonClicked();
  }
}