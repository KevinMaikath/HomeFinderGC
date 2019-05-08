package es.ulpgc.maikath101.kevin.homefindergc.MockitoTests.customerModeTests.homeDetails;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.lang.ref.WeakReference;
import java.util.ArrayList;

import es.ulpgc.maikath101.kevin.homefindergc.customerMode.homeDetails.HomeDetailsActivity;
import es.ulpgc.maikath101.kevin.homefindergc.customerMode.homeDetails.HomeDetailsContract;
import es.ulpgc.maikath101.kevin.homefindergc.customerMode.homeDetails.HomeDetailsPresenter;
import es.ulpgc.maikath101.kevin.homefindergc.customerMode.homeDetails.HomeDetailsState;
import es.ulpgc.maikath101.kevin.homefindergc.data.House;
import es.ulpgc.maikath101.kevin.homefindergc.data.Image;
import es.ulpgc.maikath101.kevin.homefindergc.data.SellHouse;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class HomeDetailsPresenterMockitoTests {

  @Mock
  private HomeDetailsContract.Model modelMock;

  @Mock
  private HomeDetailsContract.View viewMock;

  @Mock
  private HomeDetailsContract.Router routerMock;

  private HomeDetailsContract.Presenter presenter;


  @Before
  public void configureMockito() {

    // To inject the mocks in the test this method needs to be called
    MockitoAnnotations.initMocks(this);
  }

  private void configureHomeDetailsScreen(HomeDetailsState state) {

    // Get a reference to the class under test
    presenter = new HomeDetailsPresenter(state);

    presenter.injectHomeDetailsView(new WeakReference<>(viewMock));
    presenter.injectModel(modelMock);
    presenter.injectRouter(routerMock);
  }


  @Test
  public void fetchDataWithViewModel() {
    HomeDetailsState state = new HomeDetailsState();
    state.current_house = new House(1, 1, 1, "",
            "", "", "", 1, "", false, 2,
            "", "", 3, "");
    state.image_list = new ArrayList<Image>();
    state.sellHouse = new SellHouse(1, 1, "");
    configureHomeDetailsScreen(state);

    presenter.fetchData();

    verify(modelMock).setHouse(state.current_house);
    verify(modelMock).setSellHouse(state.sellHouse);

    verify(viewMock).setImageList(state);
    verify(viewMock).displayData(state);
  }

  @Test
  public void summaryButtonClicked(){
    HomeDetailsState state = new HomeDetailsState();
    configureHomeDetailsScreen(state);

    presenter.summaryButtonClicked();

    verify(modelMock).getSummaryInfo();
    verify(viewMock).displayData(state);
  }

  @Test
  public void descriptionButtonClicked(){
    HomeDetailsState state = new HomeDetailsState();
    configureHomeDetailsScreen(state);
    when(modelMock.getHouse()).thenReturn( new House(1, 1, 1, "",
            "", "", "", 1, "", false, 2,
            "", "", 3, "") );

    presenter.descriptionButtonClicked();

    verify(modelMock).getHouse();
    verify(viewMock).displayData(state);
  }

  @Test
  public void locationButtonClicked(){
    HomeDetailsState state = new HomeDetailsState();
    configureHomeDetailsScreen(state);
    when(modelMock.getHouse()).thenReturn( new House(1, 1, 1, "",
            "", "", "", 1, "", false, 2,
            "", "", 3, "") );

    presenter.locationButtonClicked();

    verify(modelMock).getHouse();
    verify(viewMock).displayData(state);
  }

  @Test
  public void distributionButtonClicked(){
    HomeDetailsState state = new HomeDetailsState();
    configureHomeDetailsScreen(state);
    when(modelMock.getHouse()).thenReturn( new House(1, 1, 1, "",
            "", "", "", 1, "", false, 2,
            "", "", 3, "") );

    presenter.distributionButtonClicked();

    verify(modelMock).getHouse();
    verify(viewMock).displayData(state);
  }

}