package app.controller.admin;

import app.controller.AdminPageController;
import app.model.DatabaseConnection;
import app.model.Users;
import app.view.AdminPage;
import app.view.admin.EditUserPage;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditUserPageController {

    private EditUserPage editUserPage;
    private JComboBox usersComboBox;
    private JButton deleteSelectedButton;
    private JButton editSelectedButton;
    private JButton abortEditSelectedButton;
    private JButton confirmEditSelectedButton;
    private JButton backButton;
    private JTextField usernameTextField;
    private JTextField passwordTextField;
    private JTextField lastnameTextField;
    private JTextField firstnameTextField;

    public EditUserPageController(){
        initComponents();
        initListeners();
        fillUsersComboBox();
    }

    public void showEditUserPageController(){
        editUserPage.setVisible(true);
    }

    public void closeEditUserPageController(){
        editUserPage.setVisible(false);
        editUserPage.dispose();
    }

    private void initComponents(){
        editUserPage = new EditUserPage();
        usersComboBox = editUserPage.getUsersComboBox();
        deleteSelectedButton = editUserPage.getDeleteSelectedButton();
        editSelectedButton = editUserPage.getEditSelectedButton();
        abortEditSelectedButton = editUserPage.getAbortEditSelectedButton();
        confirmEditSelectedButton = editUserPage.getConfirmEditSelectedButton();
        backButton = editUserPage.getBackButton();
        usernameTextField = editUserPage.getUsernameTextField();
        passwordTextField = editUserPage.getPasswordTextField();
        lastnameTextField = editUserPage.getLastnameTextField();
        firstnameTextField = editUserPage.getFirstnameTextField();
    }

    private void initListeners(){
        backButton.addActionListener(new backButton());
        deleteSelectedButton.addActionListener(new deleteSelectedButton());
        editSelectedButton.addActionListener(new editSelectedButton());
        abortEditSelectedButton.addActionListener(new abortEditSelectedButton());
        confirmEditSelectedButton.addActionListener(new confirmEditSelectedButton());
    }

    private class backButton implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            AdminPageController adminPageController = new AdminPageController();
            adminPageController.showAdminPageController();
            closeEditUserPageController();
        }
    }

    private class deleteSelectedButton implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("DELETING");
        }
    }

    private class editSelectedButton implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("EDITING");
        }
    }

    private class abortEditSelectedButton implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("ABORTING");
        }
    }

    private class confirmEditSelectedButton implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("CONFIRMING");
        }
    }

    private void fillUsersComboBox(){
        for (Users u: DatabaseConnection.getUsersList()
             ) {
                usersComboBox.addItem(u);
        }
    }
}
