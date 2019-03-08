package es.ulpgc.maikath101.kevin.homefindergc.app;

import android.app.Application;

import es.ulpgc.maikath101.kevin.homefindergc.adminMode.login.LoginState;
import es.ulpgc.maikath101.kevin.homefindergc.adminMode.selection.SelectionState;

public class AppMediator extends Application {
    private LoginState loginState;
    private SelectionState selectionState;
    public  AppMediator(){
        loginState = new LoginState();
        selectionState = new SelectionState();
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
}
