package app.model;

import app.controller.LoginPageController;

public class Runner {

    public static void main(String[] args){
        LoginPageController loginPageController = new LoginPageController();
        loginPageController.showLoginPageWindow();
    }
}
