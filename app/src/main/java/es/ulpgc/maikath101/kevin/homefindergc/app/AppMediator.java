package es.ulpgc.maikath101.kevin.homefindergc.app;

import android.app.Application;

import es.ulpgc.maikath101.kevin.homefindergc.adminMode.login.LoginState;
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
    public  AppMediator(){
        loginState = new LoginState();
        selectionState = new SelectionState();
        //
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
}
