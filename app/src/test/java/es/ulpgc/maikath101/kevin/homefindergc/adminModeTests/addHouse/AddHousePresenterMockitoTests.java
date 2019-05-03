package es.ulpgc.maikath101.kevin.homefindergc.adminModeTests.addHouse;

import android.net.Uri;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.lang.ref.WeakReference;

import es.ulpgc.maikath101.kevin.homefindergc.adminMode.addHouse.AddHouseActivity;
import es.ulpgc.maikath101.kevin.homefindergc.adminMode.addHouse.AddHouseContract;
import es.ulpgc.maikath101.kevin.homefindergc.adminMode.addHouse.AddHousePresenter;
import es.ulpgc.maikath101.kevin.homefindergc.adminMode.addHouse.AddHouseState;
import es.ulpgc.maikath101.kevin.homefindergc.adminMode.login.LoginContract;
import es.ulpgc.maikath101.kevin.homefindergc.adminMode.login.LoginPresenter;
import es.ulpgc.maikath101.kevin.homefindergc.adminMode.login.LoginState;
import es.ulpgc.maikath101.kevin.homefindergc.data.HouseRepositoryContract;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class AddHousePresenterMockitoTests {

  @Captor
  private ArgumentCaptor<HouseRepositoryContract.OnHouseCompleteleyInsertedCallback> houseCompleteleyInsertedCallbackArgumentCaptor;

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
  public void openGallery() {
    configureAddHouseScreen(new AddHouseState());

    AddHouseActivity activity = new AddHouseActivity();

    presenter.openGallery(activity);

    verify(routerMock, times(1)).openGallery(activity);
  }

  @Test
  public void fetchData() {
    AddHouseState viewModel = new AddHouseState();
    viewModel.imageUri = null;
    configureAddHouseScreen(viewModel);

    presenter.fetchData();

    verify(viewMock, times(1)).displayData(viewModel);
  }

  @Test
  public void doneButtonPressed() {
    configureAddHouseScreen(new AddHouseState());

    presenter.doneButtonPressed("", "", "", "", Uri.EMPTY);

    verify(modelMock).doneButtonPressed(eq(""),eq(""),eq(""),eq(""), eq(Uri.EMPTY),
            houseCompleteleyInsertedCallbackArgumentCaptor.capture());
    houseCompleteleyInsertedCallbackArgumentCaptor.getValue().houseInserted();

    verify(viewMock,times(1)).houseInsertedCorrectly();
  }

}