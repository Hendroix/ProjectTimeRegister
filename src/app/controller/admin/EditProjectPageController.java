package app.controller.admin;

import app.controller.AdminPageController;
import app.model.DatabaseConnection;
import app.model.Project;
import app.view.admin.EditProjectPage;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class EditProjectPageController {

    private EditProjectPage editProjectPage;
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
    private String selectedProjectNameFromComboBox;

    public EditProjectPageController(){
        initComponents();
        initListeners();
        fillProjectComboBox();
    }

    public void showEditProjectPageController(){
        editProjectPage.setVisible(true);
    }

    public void closeEditProjectPageController(){
        editProjectPage.setVisible(false);
        editProjectPage.dispose();
    }

    private void initComponents(){
        editProjectPage = new EditProjectPage();
        confirmButton = editProjectPage.getConfirmButton();
        backButton = editProjectPage.getBackButton();
        abortButton = editProjectPage.getAbortButton();
        projectComboBox = editProjectPage.getProjectComboBox();
        editButton = editProjectPage.getEditButton();
        deleteButton = editProjectPage.getDeleteButton();
        enddateTextField = editProjectPage.getEnddateTextField();
        nameTextField = editProjectPage.getNameTextField();
        nameTextField.setEditable(false);
        timeusedTextField = editProjectPage.getTimeusedTextField();
        timeusedTextField.setEditable(false);
        startdateTextField = editProjectPage.getStartdateTextField();
        descriptionTextField = editProjectPage.getDescriptionTextField();
    }

    private void initListeners(){
        backButton.addActionListener(new backButton());
        abortButton.addActionListener(new abortButton());
        editButton.addActionListener(new editButton());
        deleteButton.addActionListener(new deleteButton());
        confirmButton.addActionListener(new confirmButton());

    }

    private class backButton implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            AdminPageController adminPageController = new AdminPageController();
            adminPageController.showAdminPageController();
            closeEditProjectPageController();
        }
    }

    private class confirmButton implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            if(!nameTextField.getText().isEmpty()){
                String projectName = nameTextField.getText();
                if(!timeusedTextField.getText().isEmpty() && checkTimeUsed()){
                    Double timeUsed = Double.parseDouble(timeusedTextField.getText());
                    if(!startdateTextField.getText().isEmpty() && checkDate(startdateTextField.getText())){
                        String startDate = startdateTextField.getText();
                        if(!descriptionTextField.getText().isEmpty()){
                            String projectDescription = descriptionTextField.getText();
                            if(!enddateTextField.getText().isEmpty() && checkDate(enddateTextField.getText())){
                                String endDate = enddateTextField.getText();
                                Project updatedProject = new Project(projectName, projectDescription, timeUsed, startDate, endDate);
                                String oldProjectName = selectedProjectNameFromComboBox;
                                System.out.println(updatedProject);
                                int dialogResults = JOptionPane.showConfirmDialog(null, "Are you sure you would like to update the User: " + projectComboBox.getSelectedItem());
                                if(JOptionPane.YES_OPTION == dialogResults){
                                    DatabaseConnection.updateProject(updatedProject, oldProjectName);
                                }
                            }else{
                                JOptionPane.showMessageDialog(null,"Incorrect format for end date. Please enter in YYYY-MM-DD.");
                            }
                        }else{
                            JOptionPane.showMessageDialog(null,"Please enter a description.");
                        }
                    }else{
                        JOptionPane.showMessageDialog(null,"Incorrect format for start date. Please enter in YYYY-MM-DD.");
                    }
                }else{
                    JOptionPane.showMessageDialog(null,"Time used in either not a number or you used a comma(,). Should be in 'X.XX' format.");
                }
            }else{
                JOptionPane.showMessageDialog(null,"Please enter a projcet name.");
            }
        }
    }

    private class deleteButton implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            if (projectComboBox.getSelectedItem() != null) {
                int dialogResults = JOptionPane.showConfirmDialog(null, "Are you sure you would like to delete Project: " + projectComboBox.getSelectedItem() + ". This will also remove all the timeentries for this project. ");
                if (dialogResults == JOptionPane.YES_OPTION) {
                    DatabaseConnection.deleteTimeEntryByProject(DatabaseConnection.findProject(projectComboBox.getSelectedItem().toString()).getName());
                    projectComboBox.removeItem(projectComboBox.getSelectedItem());
                    clearTextFields();
                }
            } else {
                JOptionPane.showMessageDialog(null, "Select an item from the comboBox");
            }
        }
    }

    private class abortButton implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            clearTextFields();
        }
    }

    private class editButton implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            Project selectedProject = DatabaseConnection.findProject(projectComboBox.getSelectedItem().toString());
            nameTextField.setText(selectedProject.getName());
            selectedProjectNameFromComboBox = selectedProject.getName();
            timeusedTextField.setText(""+selectedProject.getTimeUsed());
            startdateTextField.setText(selectedProject.getStartDate());
            descriptionTextField.setText(selectedProject.getDescription());
            enddateTextField.setText(selectedProject.getEndDate());

        }
    }

    private void fillProjectComboBox(){
        for (Project p: DatabaseConnection.getProjectList()
             ) {
                projectComboBox.addItem(p.getName());
        }
    }

    private void clearTextFields(){
        enddateTextField.setText("");
        nameTextField.setText("");
        timeusedTextField.setText("");
        startdateTextField.setText("");
        descriptionTextField.setText("");
    }

    private boolean checkTimeUsed(){
        try{
            Double.parseDouble(timeusedTextField.getText());
            return true;
        }catch (NumberFormatException ex){
            ex.printStackTrace();
            return false;
        }
    }

    private boolean checkDate(String checkText){
        try{
        DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
        dateFormat.setLenient(false);
        dateFormat.parse(checkText);
        return true;
    }catch (ParseException e){

        return false;
    }
    }
}
