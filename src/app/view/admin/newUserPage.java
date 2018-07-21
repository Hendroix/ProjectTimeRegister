package app.view.admin;

import javax.swing.*;

public class newUserPage extends JFrame{

    private JPanel panel;
    private JButton backButton;
    private JButton createButton;
    private JTextField firstNameComboBox;
    private JTextField passwordComboBox;
    private JTextField lastNameComboBox;
    private JTextField userNameComboBox;

    public newUserPage(){
        setSize(500,500);
        setContentPane(panel);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public JPanel getPanel() {
        return panel;
    }

    public void setPanel(JPanel panel) {
        this.panel = panel;
    }

    public JButton getBackButton() {
        return backButton;
    }

    public void setBackButton(JButton backButton) {
        this.backButton = backButton;
    }

    public JButton getCreateButton() {
        return createButton;
    }

    public void setCreateButton(JButton createButton) {
        this.createButton = createButton;
    }

    public JTextField getFirstNameComboBox() {
        return firstNameComboBox;
    }

    public void setFirstNameComboBox(JTextField firstNameComboBox) {
        this.firstNameComboBox = firstNameComboBox;
    }

    public JTextField getPasswordComboBox() {
        return passwordComboBox;
    }

    public void setPasswordComboBox(JTextField passwordComboBox) {
        this.passwordComboBox = passwordComboBox;
    }

    public JTextField getLastNameComboBox() {
        return lastNameComboBox;
    }

    public void setLastNameComboBox(JTextField lastNameComboBox) {
        this.lastNameComboBox = lastNameComboBox;
    }

    public JTextField getUserNameComboBox() {
        return userNameComboBox;
    }

    public void setUserNameComboBox(JTextField userNameComboBox) {
        this.userNameComboBox = userNameComboBox;
    }
}
