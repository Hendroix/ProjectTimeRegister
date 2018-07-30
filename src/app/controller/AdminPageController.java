package app.controller;

import app.view.AdminPage;
import app.controller.admin.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class AdminPageController {

    private AdminPage adminPage;
    private JButton newProjectButton;
    private JButton editProjectButton;
    private JButton newUserButton;
    private JButton editUserButton;
    private JButton changeTimeEntryButton;
    private JButton backButton;

    public AdminPageController(){
        initComponents();
        initListeners();
    }

    public void showAdminPageController(){
        adminPage.setVisible(true);
    }

    public void closeAdminPageController(){
        adminPage.setVisible(false);
        adminPage.dispose();
    }

    private void initComponents(){
        adminPage = new AdminPage();
        newProjectButton = adminPage.getNewProjectButton();
        editProjectButton = adminPage.getEditProjectButton();
        newUserButton = adminPage.getNewUserButton();
        editUserButton = adminPage.getEditUserButton();
        changeTimeEntryButton = adminPage.getChangeTimeEntryButton();
        backButton = adminPage.getBackButton();
    }

    private void initListeners(){
        adminPage.getPanel().addKeyListener(new keyListeners());
        newProjectButton.addActionListener(new newProject());
        editProjectButton.addActionListener(new editProject());
        newUserButton.addActionListener(new newUser());
        editUserButton.addActionListener(new editUser());
        changeTimeEntryButton.addActionListener(new changeTimeEntry());
        backButton.addActionListener(new backButton());
    }

    private class keyListeners extends KeyAdapter{
        @Override
        public void keyPressed(KeyEvent e) {

            if(e.isControlDown()){
                if(e.getKeyCode() == KeyEvent.VK_P){
                    editProjectButton.doClick();
                }
                if(e.getKeyCode() == KeyEvent.VK_U){
                    editUserButton.doClick();
                }
            }
            else{
                if(e.getKeyCode() == KeyEvent.VK_P){
                    newProjectButton.doClick();
                }
                if(e.getKeyCode() == KeyEvent.VK_U){
                    newUserButton.doClick();
                }
                if(e.getKeyCode() == KeyEvent.VK_T){
                    changeTimeEntryButton.doClick();
                }
                if(e.getKeyCode() == KeyEvent.VK_B){
                    backButton.doClick();
                }
            }
        }
    }

    private class newProject implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            NewProjectPageController newProjectPageController = new NewProjectPageController();
            newProjectPageController.showNewProjcetPageController();
            closeAdminPageController();
        }
    }

    private class editProject implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            EditProjectPageController editProjectPageController = new EditProjectPageController();
            editProjectPageController.showEditProjectPageController();
            closeAdminPageController();
        }
    }

    private class newUser implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            NewUserPageController newUserPageController = new NewUserPageController();
            newUserPageController.showNewUserPageController();
            closeAdminPageController();
        }
    }

    private class editUser implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            EditUserPageController editUserPageController = new EditUserPageController();
            editUserPageController.showEditUserPageController();
            closeAdminPageController();
        }
    }

    private class changeTimeEntry implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            EditTimeEntryPageController editTimeEntryPageController = new EditTimeEntryPageController();
            editTimeEntryPageController.showEditTimeEntryPageController();
            closeAdminPageController();
        }
    }

    private class backButton implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            MainPageController mainPageController = new MainPageController();
            mainPageController.showMainPageController();
            closeAdminPageController();
        }
    }

}
