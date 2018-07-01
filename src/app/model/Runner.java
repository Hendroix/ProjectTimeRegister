package app.model;

import app.controller.SeeProjectPageController;

public class Runner {

    public static boolean consolePrint = false;

    public static void main(String[] args){

        DatabaseConnection.getAllProjects(consolePrint);
        DatabaseConnection.getAllUsers(consolePrint);
        DatabaseConnection.getAllTimeEntries(consolePrint);

        SeeProjectPageController seeProjectPageController = new SeeProjectPageController();
        seeProjectPageController.showSeeProjectPageController();
    }
}
