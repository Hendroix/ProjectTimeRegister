package app.controller;

import javax.swing.*;

import app.model.DatabaseConnection;
import app.model.main;
import app.view.MainPage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

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
            DatabaseConnection.gatherInfoFromDatabase(consolePrint);
            System.out.println("TimeEntries:    " + DatabaseConnection.getTimeEntryList().size());
            System.out.println("Projects:       " + DatabaseConnection.getProjectList().size());
            System.out.println("Users:          " + DatabaseConnection.getUsersList().size());
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
            if(main.logedInUser.getUserName().equalsIgnoreCase("Hendroix")){

            }
            else{
                mainPage.remove(adminButton);
            }
        }
        else{
            mainPage.remove(adminButton);
        }
    }

    public void initListeners(){
        mainPage.getMainJPanel().addKeyListener(new KeyListeners());
        usersButton.addActionListener(new gotoUsersPage());
        logoutButton.addActionListener(new logout());
        projectButton.addActionListener(new gotoProjectPage());
        timeEntryButton.addActionListener(new gotoTimeEntryPage());
        newEntryButton.addActionListener(new gotoNewEntryPage());
        adminButton.addActionListener(new adminPage());
    }

    private class KeyListeners extends KeyAdapter{
        @Override
        public void keyPressed(KeyEvent e) {
            if(e.getKeyCode() == KeyEvent.VK_E || e.getKeyCode() == KeyEvent.VK_N){
                newEntryButton.doClick();
            }
            if(e.getKeyCode() == KeyEvent.VK_T){
                timeEntryButton.doClick();
            }
            if(e.getKeyCode() == KeyEvent.VK_P){
                projectButton.doClick();
            }
            if(e.getKeyCode() == KeyEvent.VK_U){
                usersButton.doClick();
            }
            if(e.getKeyCode() == KeyEvent.VK_L){
                logoutButton.doClick();
            }
            if(e.getKeyCode() == KeyEvent.VK_A){
                if(adminButton.isVisible()){
                 adminButton.doClick();
                }
            }
        }
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
            main.logedInUser = null;
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
