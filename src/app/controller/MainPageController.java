package app.controller;

import javax.swing.*;

import app.model.DatabaseConnection;
import app.model.main;
import app.view.MainPage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainPageController {

    private MainPage mainPage;
    private JButton usersButton;
    private JButton logoutButton;
    private JButton projectButton;
    private JButton timeEntryButton;
    private JButton newEntryButton;
    private JButton adminButton;
    private boolean consolePrint = false;
    private static boolean firstLoad = true;

    public MainPageController(){
        initComponents();
        initListeners();

        if(firstLoad){
            System.out.println("Getting information from the database...");
            DatabaseConnection.getAllProjects(consolePrint);
            DatabaseConnection.getAllUsers(consolePrint);
            DatabaseConnection.getAllTimeEntries(consolePrint);
            firstLoad = false;
        }
    }

    public void showMainPageController(){
        mainPage.setVisible(true);
    }

    public void closeMainPageController(){
        mainPage.setVisible(false);
        mainPage.dispose();
    }

    public void initComponents(){
        mainPage = new MainPage();

        usersButton = mainPage.getUsersButton();
        logoutButton = mainPage.getLogoutButton();
        projectButton = mainPage.getProjectButton();
        timeEntryButton = mainPage.getTimeEntryButton();
        newEntryButton = mainPage.getNewEntryButton();
        adminButton = mainPage.getAdminButton();
        if(main.logedInUser != null){

            if(main.logedInUser.getUserName().equals("Hendroix")){
                adminButton.setVisible(true);
            }
        }
        else{
            adminButton.setVisible(false);
        }
    }

    public void initListeners(){
        usersButton.addActionListener(new gotoUsersPage());
        logoutButton.addActionListener(new logout());
        projectButton.addActionListener(new gotoProjectPage());
        timeEntryButton.addActionListener(new gotoTimeEntryPage());
        newEntryButton.addActionListener(new gotoNewEntryPage());
        adminButton.addActionListener(new adminPage());
    }

    private class gotoUsersPage implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            SeeUsersPageController seeUsersPageController = new SeeUsersPageController();
            seeUsersPageController.showSeeUsersPageController();
            closeMainPageController();
        }
    }

    private class gotoProjectPage implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            SeeProjectPageController seeProjectPageController = new SeeProjectPageController();
            seeProjectPageController.showSeeProjectPageController();
            closeMainPageController();
        }
    }

    private class gotoTimeEntryPage implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            SeeTimeEntryPageController seeTimeEntryPageController = new SeeTimeEntryPageController();
            seeTimeEntryPageController.showSeeTimeEntryPageController();
            closeMainPageController();

        }
    }

    private class gotoNewEntryPage implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            AddNewPageController addNewPageController = new AddNewPageController();
            addNewPageController.showAddNewPageController();
            closeMainPageController();
        }
    }

    private class logout implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            LoginPageController loginPageController = new LoginPageController();
            loginPageController.showLoginPageWindow();
            closeMainPageController();
        }
    }

    private class adminPage implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            AdminPageController adminPageController = new AdminPageController();
            adminPageController.showAdminPageController();
            closeMainPageController();
        }
    }

}
