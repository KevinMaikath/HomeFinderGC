package es.ulpgc.maikath101.kevin.homefindergc.customerModeTests.homeDetails;

import android.app.Activity;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.lang.ref.WeakReference;
import java.util.ArrayList;

import es.ulpgc.maikath101.kevin.homefindergc.customerMode.homeDetails.HomeDetailsContract;
import es.ulpgc.maikath101.kevin.homefindergc.customerMode.homeDetails.HomeDetailsPresenter;
import es.ulpgc.maikath101.kevin.homefindergc.customerMode.homeDetails.HomeDetailsState;
import es.ulpgc.maikath101.kevin.homefindergc.data.House;
import es.ulpgc.maikath101.kevin.homefindergc.data.Image;
import es.ulpgc.maikath101.kevin.homefindergc.data.SellHouse;

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

  private void configureStartScreen(HomeDetailsState state) {

    // Get a reference to the class under test
    presenter = new HomeDetailsPresenter(state);

    presenter.injectHomeDetailsView(new WeakReference<>(viewMock));
    presenter.injectModel(modelMock);
    presenter.injectRouter(routerMock);
  }

  // No encontramos la manera de realizar el test correctamente
  @Test
  public void fetchDataWithViewModel() {
    HomeDetailsState state = new HomeDetailsState();
    state.current_house = new House(1, 1, 1, "",
            "", "", "", 1, "", false, 2,
            "", "", 3, "");
    state.image_list = new ArrayList<Image>();
    state.sellHouse = new SellHouse(1, 1, "");
    configureStartScreen(state);

    // When start a new screen is requested
    when(modelMock.getSummaryInfo()).thenReturn("Summary");

    presenter.fetchData();

    verify(modelMock).setHouse(state.current_house);
    verify(modelMock).setSellHouse(state.sellHouse);
    verify(modelMock).getSummaryInfo();

    verify(viewMock).setImageList(state);
    verify(viewMock).displayData(state);
  }

}