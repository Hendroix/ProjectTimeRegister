package app.controller.admin;

import app.controller.AdminPageController;
import app.model.DatabaseConnection;
import app.model.Project;
import app.model.TimeEntry;
import app.model.Users;
import app.view.admin.EditTimeEntryPage;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditTimeEntryPageController {

    private EditTimeEntryPage editTimeEntryPage;
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

    public EditTimeEntryPageController(){
        initComponents();
        initListeners();
        fillComboBoxes();
        editTimeEntryPage.setSize(1000,500);
    }

    public void showEditTimeEntryPageController(){
        editTimeEntryPage.setVisible(true);
    }

    public void closeEditTimeEntryPageController(){
        editTimeEntryPage.setVisible(false);
        editTimeEntryPage.dispose();
    }

    private void initComponents(){
        editTimeEntryPage = new EditTimeEntryPage();
        abortButton = editTimeEntryPage.getAbortButton();
        backButton = editTimeEntryPage.getBackButton();
        confirmButton = editTimeEntryPage.getConfirmButton();
        timeEntryComboBox = editTimeEntryPage.getTimeEntryComboBox();
        editButton = editTimeEntryPage.getEditButton();
        deleteButton = editTimeEntryPage.getDeleteButton();
        projectInTimeEntryEditComboBox = editTimeEntryPage.getProjectInTimeEntryEditComboBox();
        userInTimeEntryEditComboBox = editTimeEntryPage.getUserInTimeEntryEditComboBox();
        timeUsedTextField = editTimeEntryPage.getTimeUsedTextField();
        descriptionTextField = editTimeEntryPage.getDescriptionTextField();
        dateAddedTextField = editTimeEntryPage.getDateAddedTextField();
    }

    private void initListeners(){
        backButton.addActionListener(new backButton());
        abortButton.addActionListener(new abortButton());
        deleteButton.addActionListener(new deleteButton());
        confirmButton.addActionListener(new confirmButton());
        editButton.addActionListener(new editButton());
    }

    private class backButton implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            AdminPageController adminPageController = new AdminPageController();
            adminPageController.showAdminPageController();
            closeEditTimeEntryPageController();
        }
    }

    private class editButton implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            TimeEntry selectedTimEntry = (TimeEntry) timeEntryComboBox.getSelectedItem();
            projectInTimeEntryEditComboBox.setSelectedItem(selectedTimEntry.getProject());
            userInTimeEntryEditComboBox.setSelectedItem(selectedTimEntry.getUsers());
            timeUsedTextField.setText("" + selectedTimEntry.getTimeUsed());
            descriptionTextField.setText(selectedTimEntry.getDescription());
            dateAddedTextField.setText(selectedTimEntry.getDateAdded());
        }
    }

    private class deleteButton implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            if(timeEntryComboBox.getSelectedItem() != null){
                int dialogResults = JOptionPane.showConfirmDialog(null, "Are you sure you would like to delete TimeEntry: " + timeEntryComboBox.getSelectedItem());
                if(dialogResults == JOptionPane.YES_OPTION){
                    DatabaseConnection.deleteTimeEntry(((TimeEntry)timeEntryComboBox.getSelectedItem()).getEntryID());
                    fillComboBoxes();
                    clearTextFields();
                }
            }
        }
    }

    private class confirmButton implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            if(!dateAddedTextField.getText().isEmpty()  && !descriptionTextField.getText().isEmpty() && !timeUsedTextField.getText().isEmpty()){
                TimeEntry selectedTimeEntry = (TimeEntry) timeEntryComboBox.getSelectedItem();
                Project newProject = (Project) projectInTimeEntryEditComboBox.getSelectedItem();
                Double newTimeUsed = Double.parseDouble(timeUsedTextField.getText());
                String newDescription = descriptionTextField.getText();
                String newDateAdded = dateAddedTextField.getText();
                Users newUser = (Users)userInTimeEntryEditComboBox.getSelectedItem();
                TimeEntry updatedTimeEntry = new TimeEntry(selectedTimeEntry.getEntryID(),newProject,newTimeUsed,newDescription,newDateAdded, newUser);
                String msgString = "Are you sure you want to update this TimeEntry?" + '\n';
                Boolean edited = false;

                if(selectedTimeEntry.getProject() != newProject){
                    msgString += selectedTimeEntry.getProject() + " -> " + newProject + '\n';
                    edited = true;
                }
                else if(selectedTimeEntry.getUsers() != newUser){
                    msgString += selectedTimeEntry.getUsers() + " -> " + newUser + '\n';
                    edited = true;
                }
                else if(selectedTimeEntry.getTimeUsed() != newTimeUsed){
                    msgString += selectedTimeEntry.getTimeUsed() + " -> " + newTimeUsed + '\n';
                    edited = true;
                }
                else if(!selectedTimeEntry.getDateAdded().equals(newDateAdded)){
                    msgString += selectedTimeEntry.getDateAdded() + " -> " + newDateAdded + '\n';
                    edited = true;
                }
                else if(!selectedTimeEntry.getDescription().equals(newDescription)){

                    msgString += selectedTimeEntry.getDescription() + " -> " + newDescription + '\n';
                    edited = true;
                }
                if(edited){
                    int dialogResults = JOptionPane.showConfirmDialog(null, msgString);
                    if(dialogResults == JOptionPane.YES_OPTION){
                        DatabaseConnection.updateTimeEntry(updatedTimeEntry);
                        clearTextFields();
                        fillComboBoxes();
                    }
                }
                else{
                    JOptionPane.showMessageDialog(null,"Nothing is edited.");
                }
            }
            else{
                JOptionPane.showMessageDialog(null,"Nothing is selected for editing.");
            }
        }
    }

    private class abortButton implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            clearTextFields();
        }
    }

    private void fillComboBoxes(){
        timeEntryComboBox.removeAllItems();
        projectInTimeEntryEditComboBox.removeAllItems();
        userInTimeEntryEditComboBox.removeAllItems();
        for (TimeEntry te: DatabaseConnection.getTimeEntryList()
                ) {
            timeEntryComboBox.addItem(te);
        }

        for (Project p: DatabaseConnection.getProjectList()
             ) {
            projectInTimeEntryEditComboBox.addItem(p);
        }
        for (Users u: DatabaseConnection.getUsersList()
             ) {
            userInTimeEntryEditComboBox.addItem(u);
        }
    }

    private void clearTextFields(){
        dateAddedTextField.setText("");
        timeUsedTextField.setText("");
        descriptionTextField.setText("");
    }
}
