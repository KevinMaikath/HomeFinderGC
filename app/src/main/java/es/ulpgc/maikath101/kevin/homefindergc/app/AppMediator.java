package es.ulpgc.maikath101.kevin.homefindergc.app;

import android.app.Application;

import es.ulpgc.maikath101.kevin.homefindergc.adminMode.addHouse.AddHouseState;
import es.ulpgc.maikath101.kevin.homefindergc.adminMode.login.LoginState;
import es.ulpgc.maikath101.kevin.homefindergc.adminMode.removeHouse.RemoveHouseState;
import es.ulpgc.maikath101.kevin.homefindergc.adminMode.selection.SelectionState;
import es.ulpgc.maikath101.kevin.homefindergc.customerMode.aboutUsScreen.AboutUsState;
import es.ulpgc.maikath101.kevin.homefindergc.customerMode.contactScreen.ContactState;
import es.ulpgc.maikath101.kevin.homefindergc.customerMode.homeDetails.HomeDetailsState;
import es.ulpgc.maikath101.kevin.homefindergc.customerMode.startScreen.StartState;

public class AppMediator extends Application {

  private LoginState loginState;
  private SelectionState selectionState;
  private StartState startState;
  private HomeDetailsState homeDetailsState;
  private AboutUsState aboutUsState;
  private ContactState contactState;
  private AddHouseState addHouseState;
  private RemoveHouseState removeHouseState;

  public AppMediator() {
    loginState = new LoginState();
    selectionState = new SelectionState();
    removeHouseState = new RemoveHouseState();
    startState = new StartState();
    homeDetailsState = new HomeDetailsState();
    aboutUsState = new AboutUsState();
    contactState = new ContactState();
    addHouseState = new AddHouseState();
  }

  public void setLoginState(LoginState state) {
    this.loginState = state;
  }

  public LoginState getLoginState() {
    return loginState;
  }

  public void setSelectionState(SelectionState state) {
    this.selectionState = state;
  }

  public SelectionState getSelectionState() {
    return selectionState;
  }

  public void setStartState(StartState state) {
    this.startState = state;
  }

  public StartState getStartState() {
    return startState;
  }

  public void setHomeDetailsState(HomeDetailsState state) {
    this.homeDetailsState = state;
  }

  public HomeDetailsState getHomeDetailsState() {
    return homeDetailsState;
  }

  public void setAboutUsState(AboutUsState state) {
    this.aboutUsState = state;
  }

  public AboutUsState getAboutUsState() {
    return aboutUsState;
  }

  public void setContactState(ContactState state) {
    this.contactState = state;
  }

  public ContactState getContactState() {
    return contactState;
  }

  public void setAddHouseState(AddHouseState state) {
    this.addHouseState = state;
  }

  public AddHouseState getAddHouseState() {
    return addHouseState;
  }

  public void setRemoveHouseState(RemoveHouseState state) {
    this.removeHouseState = state;
  }

  public RemoveHouseState getRemoveHouseState() {
    return removeHouseState;
  }

  public void changeStartScreenLayout(String layout){
    startState.currentScreen = layout;
  }
}
