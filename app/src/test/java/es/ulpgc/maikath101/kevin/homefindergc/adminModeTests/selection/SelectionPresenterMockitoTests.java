
package es.ulpgc.maikath101.kevin.homefindergc.adminModeTests.selection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.lang.ref.WeakReference;

import es.ulpgc.maikath101.kevin.homefindergc.adminMode.selection.SelectionContract;
import es.ulpgc.maikath101.kevin.homefindergc.adminMode.selection.SelectionPresenter;
import es.ulpgc.maikath101.kevin.homefindergc.adminMode.selection.SelectionState;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class SelectionPresenterMockitoTests {

  @Mock
  private SelectionContract.Model modelMock;

  @Mock
  private SelectionContract.View viewMock;

  @Mock
  private SelectionContract.Router routerMock;

  private SelectionContract.Presenter presenter;


  @Before
  public void configureMockito() {

    // To inject the mocks in the test this method needs to be called
    MockitoAnnotations.initMocks(this);
  }

  private void configureSelectionScreen(SelectionState state) {

    // Get a reference to the class under test
    presenter = new SelectionPresenter(state);

    presenter.injectView(new WeakReference<>(viewMock));
    presenter.injectModel(modelMock);
    presenter.injectRouter(routerMock);
  }

}
