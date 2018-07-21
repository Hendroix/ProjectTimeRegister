package app.view.admin;

import javax.swing.*;

public class EditUserPage extends JFrame{

    private JPanel panel;
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

    public EditUserPage(){
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

    public JComboBox getUsersComboBox() {
        return usersComboBox;
    }

    public void setUsersComboBox(JComboBox usersComboBox) {
        this.usersComboBox = usersComboBox;
    }

    public JButton getDeleteSelectedButton() {
        return deleteSelectedButton;
    }

    public void setDeleteSelectedButton(JButton deleteSelectedButton) {
        this.deleteSelectedButton = deleteSelectedButton;
    }

    public JButton getEditSelectedButton() {
        return editSelectedButton;
    }

    public void setEditSelectedButton(JButton editSelectedButton) {
        this.editSelectedButton = editSelectedButton;
    }

    public JButton getAbortEditSelectedButton() {
        return abortEditSelectedButton;
    }

    public void setAbortEditSelectedButton(JButton abortEditSelectedButton) {
        this.abortEditSelectedButton = abortEditSelectedButton;
    }

    public JButton getConfirmEditSelectedButton() {
        return confirmEditSelectedButton;
    }

    public void setConfirmEditSelectedButton(JButton confirmEditSelectedButton) {
        this.confirmEditSelectedButton = confirmEditSelectedButton;
    }

    public JButton getBackButton() {
        return backButton;
    }

    public void setBackButton(JButton backButton) {
        this.backButton = backButton;
    }

    public JTextField getUsernameTextField() {
        return usernameTextField;
    }

    public void setUsernameTextField(JTextField usernameTextField) {
        this.usernameTextField = usernameTextField;
    }

    public JTextField getPasswordTextField() {
        return passwordTextField;
    }

    public void setPasswordTextField(JTextField passwordTextField) {
        this.passwordTextField = passwordTextField;
    }

    public JTextField getLastnameTextField() {
        return lastnameTextField;
    }

    public void setLastnameTextField(JTextField lastnameTextField) {
        this.lastnameTextField = lastnameTextField;
    }

    public JTextField getFirstnameTextField() {
        return firstnameTextField;
    }

    public void setFirstnameTextField(JTextField firstnameTextField) {
        this.firstnameTextField = firstnameTextField;
    }
}
