package app.view.admin;

import javax.swing.*;

public class EditProjectPage extends JFrame {

    private JPanel panel;
    private JButton confirmButton;
    private JButton backButton;
    private JButton abortButton;
    private JComboBox projectComboBox;
    private JButton editButton;
    private JButton deleteButton;
    private JTextField enddateTextField;
    private JTextField nameTextField;
    private JTextField timeusedTextField;
    private JTextField startdateTextField;
    private JTextField descriptionTextField;

    public EditProjectPage(){
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

    public JButton getConfirmButton() {
        return confirmButton;
    }

    public void setConfirmButton(JButton confirmButton) {
        this.confirmButton = confirmButton;
    }

    public JButton getBackButton() {
        return backButton;
    }

    public void setBackButton(JButton backButton) {
        this.backButton = backButton;
    }

    public JButton getAbortButton() {
        return abortButton;
    }

    public void setAbortButton(JButton abortButton) {
        this.abortButton = abortButton;
    }

    public JComboBox getProjectComboBox() {
        return projectComboBox;
    }

    public void setProjectComboBox(JComboBox projectComboBox) {
        this.projectComboBox = projectComboBox;
    }

    public JButton getEditButton() {
        return editButton;
    }

    public void setEditButton(JButton editButton) {
        this.editButton = editButton;
    }

    public JButton getDeleteButton() {
        return deleteButton;
    }

    public void setDeleteButton(JButton deleteButton) {
        this.deleteButton = deleteButton;
    }

    public JTextField getEnddateTextField() {
        return enddateTextField;
    }

    public void setEnddateTextField(JTextField enddateTextField) {
        this.enddateTextField = enddateTextField;
    }

    public JTextField getNameTextField() {
        return nameTextField;
    }

    public void setNameTextField(JTextField nameTextField) {
        this.nameTextField = nameTextField;
    }

    public JTextField getTimeusedTextField() {
        return timeusedTextField;
    }

    public void setTimeusedTextField(JTextField timeusedTextField) {
        this.timeusedTextField = timeusedTextField;
    }

    public JTextField getStartdateTextField() {
        return startdateTextField;
    }

    public void setStartdateTextField(JTextField startdateTextField) {
        this.startdateTextField = startdateTextField;
    }

    public JTextField getDescriptionTextField() {
        return descriptionTextField;
    }

    public void setDescriptionTextField(JTextField descriptionTextField) {
        this.descriptionTextField = descriptionTextField;
    }
}
