package app.view;

import javax.swing.*;

public class LoginPage extends JFrame{

    private JPanel panel1;
    private JButton loginButton;
    private JTextField textFieldUserName;
    private JPasswordField textFieldPassWord;
    private JLabel labelUserFeedBack;

    public LoginPage(){
        setSize(500,500);
        setContentPane(panel1);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public JButton getLoginButton() {
        return loginButton;
    }

    public void setLoginButton(JButton loginButton) {
        this.loginButton = loginButton;
    }

    public JTextField getTextFieldUserName() {
        return textFieldUserName;
    }

    public void setTextFieldUserName(JTextField textFieldUserName) {
        this.textFieldUserName = textFieldUserName;
    }

    public JPasswordField getTextFieldPassWord() {
        return textFieldPassWord;
    }

    public void setTextFieldPassWord(JPasswordField textFieldPassWord) {
        this.textFieldPassWord = textFieldPassWord;
    }

    public JLabel getLabelUserFeedBack() {
        return labelUserFeedBack;
    }

    public void setLabelUserFeedBack(JLabel labelUserFeedBack) {
        this.labelUserFeedBack = labelUserFeedBack;
    }
}
