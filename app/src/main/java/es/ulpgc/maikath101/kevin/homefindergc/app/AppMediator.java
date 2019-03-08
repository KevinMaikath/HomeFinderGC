package es.ulpgc.maikath101.kevin.homefindergc.app;

import android.app.Application;

import es.ulpgc.maikath101.kevin.homefindergc.adminMode.login.LoginState;

public class AppMediator extends Application {
    private LoginState loginState;

    public  AppMediator(){
        loginState = new LoginState();
    }

    public void setLoginState(LoginState state) {
        this.loginState = state;
    }

    public LoginState getLoginState() {
        return loginState;
    }
}
