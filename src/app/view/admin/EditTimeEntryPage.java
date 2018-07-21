package app.view.admin;

import javax.swing.*;

public class EditTimeEntryPage extends JFrame{

    private JPanel panel;
    private JButton abortButton;
    private JButton backButton;
    private JButton confirmButton;
    private JComboBox timeEntryComboBox;
    private JButton editButton;
    private JButton deleteButton;
    private JComboBox projectInTimeEntryEditComboBox;
    private JComboBox userInTimeEntryEditComboBox;
    private JTextField timeUsedTextField;
    private JTextField descriptionTextField;
    private JTextField dateAddedTextField;

    public EditTimeEntryPage(){
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

    public JButton getAbortButton() {
        return abortButton;
    }

    public void setAbortButton(JButton abortButton) {
        this.abortButton = abortButton;
    }

    public JButton getBackButton() {
        return backButton;
    }

    public void setBackButton(JButton backButton) {
        this.backButton = backButton;
    }

    public JButton getConfirmButton() {
        return confirmButton;
    }

    public void setConfirmButton(JButton confirmButton) {
        this.confirmButton = confirmButton;
    }

    public JComboBox getTimeEntryComboBox() {
        return timeEntryComboBox;
    }

    public void setTimeEntryComboBox(JComboBox timeEntryComboBox) {
        this.timeEntryComboBox = timeEntryComboBox;
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

    public JComboBox getProjectInTimeEntryEditComboBox() {
        return projectInTimeEntryEditComboBox;
    }

    public void setProjectInTimeEntryEditComboBox(JComboBox projectInTimeEntryEditComboBox) {
        this.projectInTimeEntryEditComboBox = projectInTimeEntryEditComboBox;
    }

    public JComboBox getUserInTimeEntryEditComboBox() {
        return userInTimeEntryEditComboBox;
    }

    public void setUserInTimeEntryEditComboBox(JComboBox userInTimeEntryEditComboBox) {
        this.userInTimeEntryEditComboBox = userInTimeEntryEditComboBox;
    }

    public JTextField getTimeUsedTextField() {
        return timeUsedTextField;
    }

    public void setTimeUsedTextField(JTextField timeUsedTextField) {
        this.timeUsedTextField = timeUsedTextField;
    }

    public JTextField getDescriptionTextField() {
        return descriptionTextField;
    }

    public void setDescriptionTextField(JTextField descriptionTextField) {
        this.descriptionTextField = descriptionTextField;
    }

    public JTextField getDateAddedTextField() {
        return dateAddedTextField;
    }

    public void setDateAddedTextField(JTextField dateAddedTextField) {
        this.dateAddedTextField = dateAddedTextField;
    }
}
