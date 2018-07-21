package app.controller.admin;

import app.controller.AdminPageController;
import app.model.DatabaseConnection;
import app.model.Users;
import app.view.admin.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class newUserPageController {

    private newUserPage newUserPage;
    private JTextField userNameComboBox;
    private JTextField firstNameComboBox;
    private JTextField lastNameComboBox;
    private JTextField passwordComboBox;
    private JButton backButton;
    private JButton createButton;

    public newUserPageController() {
        initComponents();
        initListeners();
    }

    public void showNewUserPageController(){
        newUserPage.setVisible(true);
    }

    public void closeNewUserPageController(){
        newUserPage.setVisible(false);
        newUserPage.dispose();
    }

    private void initComponents(){
        newUserPage = new newUserPage();
        userNameComboBox = newUserPage.getUserNameComboBox();
        firstNameComboBox = newUserPage.getFirstNameComboBox();
        lastNameComboBox = newUserPage.getLastNameComboBox();
        passwordComboBox = newUserPage.getPasswordComboBox();
        backButton = newUserPage.getBackButton();
        createButton = newUserPage.getCreateButton();
    }

    private void initListeners(){
        backButton.addActionListener(new backButton());
        createButton.addActionListener(new createButton());
    }

    private class backButton implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            AdminPageController adminPageController = new AdminPageController();
            adminPageController.showAdminPageController();
            closeNewUserPageController();
        }
    }

    private class createButton implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            if(checkInfoFromuserNameComboBox()){
                String userName = userNameComboBox.getText();
                if(checkInfoFromfirstNameComboBox()){
                    String firstName = firstNameComboBox.getText();
                    if(checkInfoFromlastNameComboBox()){
                        String lastName = lastNameComboBox.getText();
                        if(checkInfoFrompasswordComboBox()){
                            String password = passwordComboBox.getText();
                            Users newUser = new Users(userName,firstName,lastName,password);
                            System.out.println(newUser);
                            //DatabaseConnection.addUser(newUser);
                        }
                    }
                }
            }
        }
    }

    private boolean checkInfoFromuserNameComboBox(){
        String userName = userNameComboBox.getText();
        if(!userName.isEmpty()){
            return true;
        }
        return false;
    }

    private boolean checkInfoFromfirstNameComboBox(){
        String firstName = firstNameComboBox.getText();
        if(!firstName.isEmpty()){
            return true;
        }
        return false;
    }

    private boolean checkInfoFromlastNameComboBox(){
        String lastName = lastNameComboBox.getText();
        if(!lastName.isEmpty() ){
            return true;
        }
        return false;
    }

    private boolean checkInfoFrompasswordComboBox(){
        String password = passwordComboBox.getText();
        if(!password.isEmpty()){
            return true;
        }
        return false;
    }
}
