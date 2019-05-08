package es.ulpgc.maikath101.kevin.homefindergc.MockitoTests.adminModeTests.addHouse;

import android.net.Uri;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import es.ulpgc.maikath101.kevin.homefindergc.adminMode.addHouse.AddHouseContract;
import es.ulpgc.maikath101.kevin.homefindergc.adminMode.addHouse.AddHouseModel;
import es.ulpgc.maikath101.kevin.homefindergc.data.House;
import es.ulpgc.maikath101.kevin.homefindergc.data.HouseRepositoryContract;
import es.ulpgc.maikath101.kevin.homefindergc.data.Image;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class AddHouseModelMockitoTests {

  @Captor
  private ArgumentCaptor<HouseRepositoryContract.OnHouseInsertedCallback>
          onHouseInsertedCallbackArgumentCaptor;

  @Captor
  private ArgumentCaptor<HouseRepositoryContract.OnImageInsertedCallback>
          onImageInsertedCallbackArgumentCaptor;

  private AddHouseContract.Model model;

  private HouseRepositoryContract.OnHouseCompleteleyInsertedCallback onHouseCompleteleyInsertedCallback;

  private HouseRepositoryContract.OnHouseCompleteleyInsertedCallback callback
          = new HouseRepositoryContract.OnHouseCompleteleyInsertedCallback() {
    @Override
    public void houseInserted() {

    }
  };

  @Mock
  private AddHouseContract.View viewMock;

  @Mock
  private AddHouseContract.Router routerMock;

  @Mock
  private AddHouseContract.Presenter presenter;

  @Mock
  private HouseRepositoryContract repository;

  @Before
  public void configureMockito() {

    // To inject the mocks in the test this method needs to be called
    MockitoAnnotations.initMocks(this);

    model = new AddHouseModel(repository);
  }

}