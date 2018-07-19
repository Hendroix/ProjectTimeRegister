package app.controller;

import app.view.*;
import app.model.*;

import javax.swing.*;
import java.awt.event.*;
import java.util.Arrays;

public class LoginPageController {

    private LoginPage loginPage;
    private JButton loginButton;
    private JTextField textFieldUserName;
    private JPasswordField textFieldPassWord;
    private JLabel labelUserFeedBack;

    public LoginPageController() {
        initComponents();
        initListeners();
    }

    public void showLoginPageWindow() {
        loginPage.setVisible(true);
    }

    public void closeLoginWindow(){
        loginPage.setVisible(false);
        loginPage.dispose();
    }

    private void initComponents() {
        loginPage = new LoginPage();

        loginButton = loginPage.getLoginButton();
        textFieldUserName = loginPage.getTextFieldUserName();
        textFieldPassWord = loginPage.getTextFieldPassWord();
        labelUserFeedBack = loginPage.getLabelUserFeedBack();

    }

    private void initListeners() {
        loginButton.addActionListener(new checkPasswordListner());
        textFieldUserName.addKeyListener(new enterKeyListener());
        textFieldPassWord.addKeyListener(new enterKeyListener());
    }

    private class checkPasswordListner implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            loginMethod();
        }
    }

    private class enterKeyListener extends KeyAdapter{
        @Override
        public void keyPressed(KeyEvent e) {
            if(e.getKeyCode() == KeyEvent.VK_ENTER){
                loginMethod();
            }
            if(e.getKeyCode() == KeyEvent.VK_ESCAPE){
                closeLoginWindow();
            }
        }
    }

    private void loginMethod(){
        String inputUserName = loginPage.getTextFieldUserName().getText().replaceAll("\\s+","");
        labelUserFeedBack.setText("You tried to login as " + inputUserName);
        if (!loginPage.getTextFieldUserName().getText().isEmpty()) {
            if (DatabaseConnection.userExists(inputUserName)) {
                if (loginPage.getTextFieldPassWord().getPassword().length > 0) {
                    Users checkUsers = DatabaseConnection.findUser(inputUserName);
                    if (checkPasswordAndUsername(checkUsers, loginPage.getTextFieldPassWord().getPassword())) {
                        labelUserFeedBack.setText("Logging in...");
                        resetTextBoxes();
                        main.logedInUser = checkUsers;
                        MainPageController mainPageController = new MainPageController();
                        mainPageController.showMainPageController();
                        closeLoginWindow();
                    } else {
                        labelUserFeedBack.setText("Password or username is incorrect.");
                    }
                } else {
                    labelUserFeedBack.setText("You need to type a password to login.");
                }
            } else {
                labelUserFeedBack.setText("Password or username is incorrect.");
            }
        }else{
            labelUserFeedBack.setText("You need to type a username to login.");
        }
    }

    private boolean checkPasswordAndUsername(Users checkUsers, char[] password) {
        if (checkPassword(password, checkUsers)) {
            return true;
        } else {
            return false;
        }
    }

    private boolean checkPassword(char[] userInput, Users Users) {
        boolean isCorrect;
        char[] correctPassword = Users.getUserPass().toCharArray();
        if (userInput.length != correctPassword.length) {
            return false;
        } else {
            isCorrect = Arrays.equals(userInput, correctPassword);
        }
        return isCorrect;
    }

    private void resetTextBoxes(){
        textFieldUserName.setText("");
        textFieldPassWord.setText("");
        labelUserFeedBack.setText("Login Page");
    }
}
