package es.ulpgc.maikath101.kevin.homefindergc.MockitoTests.customerModeTests.drawer;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.view.ActionProvider;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import es.ulpgc.maikath101.kevin.homefindergc.customerMode.drawer.DrawerActivity;
import es.ulpgc.maikath101.kevin.homefindergc.customerMode.drawer.DrawerContract;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class DrawerActivityMockitoTests {

  @Mock
  private DrawerContract.View viewMock;

  @Mock
  private DrawerContract.Router routerMock;

  private DrawerActivity drawerActivity;

  @Mock
  private DrawerContract.Presenter presenterMock;

  /**
   *  Clase que implementa la interfaz MenuItem, pero solo modifica el método de getItemId
   *  para poder hacer tests al onNavigationItemClicked
   */
  private class LocalMenuItem implements MenuItem{

    private int id = 0;

    public LocalMenuItem(int id){
      this.id = id;
    }

    @Override
    public int getItemId() {
      return id;
    }

    @Override
    public int getGroupId() {
      return 0;
    }

    @Override
    public int getOrder() {
      return 0;
    }

    @Override
    public MenuItem setTitle(CharSequence title) {
      return null;
    }

    @Override
    public MenuItem setTitle(int title) {
      return null;
    }

    @Override
    public CharSequence getTitle() {
      return null;
    }

    @Override
    public MenuItem setTitleCondensed(CharSequence title) {
      return null;
    }

    @Override
    public CharSequence getTitleCondensed() {
      return null;
    }

    @Override
    public MenuItem setIcon(Drawable icon) {
      return null;
    }

    @Override
    public MenuItem setIcon(int iconRes) {
      return null;
    }

    @Override
    public Drawable getIcon() {
      return null;
    }

    @Override
    public MenuItem setIntent(Intent intent) {
      return null;
    }

    @Override
    public Intent getIntent() {
      return null;
    }

    @Override
    public MenuItem setShortcut(char numericChar, char alphaChar) {
      return null;
    }

    @Override
    public MenuItem setNumericShortcut(char numericChar) {
      return null;
    }

    @Override
    public char getNumericShortcut() {
      return 0;
    }

    @Override
    public MenuItem setAlphabeticShortcut(char alphaChar) {
      return null;
    }

    @Override
    public char getAlphabeticShortcut() {
      return 0;
    }

    @Override
    public MenuItem setCheckable(boolean checkable) {
      return null;
    }

    @Override
    public boolean isCheckable() {
      return false;
    }

    @Override
    public MenuItem setChecked(boolean checked) {
      return null;
    }

    @Override
    public boolean isChecked() {
      return false;
    }

    @Override
    public MenuItem setVisible(boolean visible) {
      return null;
    }

    @Override
    public boolean isVisible() {
      return false;
    }

    @Override
    public MenuItem setEnabled(boolean enabled) {
      return null;
    }

    @Override
    public boolean isEnabled() {
      return false;
    }

    @Override
    public boolean hasSubMenu() {
      return false;
    }

    @Override
    public SubMenu getSubMenu() {
      return null;
    }

    @Override
    public MenuItem setOnMenuItemClickListener(OnMenuItemClickListener menuItemClickListener) {
      return null;
    }

    @Override
    public ContextMenu.ContextMenuInfo getMenuInfo() {
      return null;
    }

    @Override
    public void setShowAsAction(int actionEnum) {

    }

    @Override
    public MenuItem setShowAsActionFlags(int actionEnum) {
      return null;
    }

    @Override
    public MenuItem setActionView(View view) {
      return null;
    }

    @Override
    public MenuItem setActionView(int resId) {
      return null;
    }

    @Override
    public View getActionView() {
      return null;
    }

    @Override
    public MenuItem setActionProvider(ActionProvider actionProvider) {
      return null;
    }

    @Override
    public ActionProvider getActionProvider() {
      return null;
    }

    @Override
    public boolean expandActionView() {
      return false;
    }

    @Override
    public boolean collapseActionView() {
      return false;
    }

    @Override
    public boolean isActionViewExpanded() {
      return false;
    }

    @Override
    public MenuItem setOnActionExpandListener(OnActionExpandListener listener) {
      return null;
    }
}

  @Before
  public void configureMockito() {
    // To inject the mocks in the test this method needs to be called
    MockitoAnnotations.initMocks(this);

    configureDrawerScreen();
  }

  private void configureDrawerScreen() {
    // Get a reference to the class under test
    drawerActivity = new DrawerActivity();

    drawerActivity.injectPresenter(presenterMock);

    // NO SE PUEDE CREAR UN DRAWERLAYOUT
    // drawerActivity.setDrawerLayout(new DrawerLayout());
  }

  /**
  @Test
  public void onNavigationItemSelected() {
    MenuItem item = new LocalMenuItem(R.id.nav_inicio);

    drawerActivity.onNavigationItemSelected(item);

    verify(presenterMock).goToStart(drawerActivity);
  }
**/

}