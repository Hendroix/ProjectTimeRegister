package app.controller;

import app.model.DatabaseConnection;
import app.model.Users;
import app.view.SeeUsersPage;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SeeUsersPageController {

    private SeeUsersPage seeUsersPage;
    private JList userJList;
    private JButton backBtn;

    public SeeUsersPageController(){
        initComponents();
        initListeners();
        fillUserJList();
    }

    public void showSeeUsersPageController(){
        seeUsersPage.setVisible(true);
    }

    public void closeSeeUsersPageController(){
        seeUsersPage.setVisible(false);
        seeUsersPage.dispose();
    }

    private void initComponents(){
        seeUsersPage = new SeeUsersPage();
        userJList = seeUsersPage.getUserList();
        backBtn = seeUsersPage.getBackBtn();
    }

    private void initListeners(){
        backBtn.addActionListener(new backButton());
    }

    private class backButton implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            MainPageController mainPageController = new MainPageController();
            mainPageController.showMainPageController();
            closeSeeUsersPageController();
        }
    }

    private void fillUserJList(){
        DefaultListModel listModel = new DefaultListModel();
        for (Users u: DatabaseConnection.getUsersList()
             ) {
            listModel.addElement(u.toString());
        }
        userJList.setModel(listModel);
        updateSize();
    }

    private void updateSize(){
        seeUsersPage.setSize(500,500);
    }
}
