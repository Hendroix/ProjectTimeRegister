package app.controller;

import app.model.DatabaseConnection;
import app.model.Project;
import app.model.TimeEntry;
import app.model.Users;
import app.view.AddNewPage;

import javax.swing.*;
import javax.xml.crypto.Data;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.Date;

public class AddNewPageController {

    private AddNewPage addNewPage;
    private JComboBox projectComboBox;
    private JTextField timeUsedTextField;
    private JTextField descriptionTextField;
    private JTextField dateTextField;
    private JComboBox userComboBox;
    private JButton createBtn;
    private JButton backBtn;

    public AddNewPageController(){
        initComponents();
        initListeners();
        fillComboBoxes();
        setCurrentDate();
    }

    public void showAddNewPageController(){
        addNewPage.setVisible(true);
    }

    public void closeAddNewPageController(){
        addNewPage.setVisible(false);
        addNewPage.dispose();
    }

    private void initComponents(){
        addNewPage = new AddNewPage();
        projectComboBox = addNewPage.getProjectComboBox();
        timeUsedTextField = addNewPage.getTimeUsedTextField();
        descriptionTextField = addNewPage.getDescriptionTextField();
        dateTextField = addNewPage.getDateTextField();
        userComboBox = addNewPage.getUserComboBox();
        createBtn = addNewPage.getCreateBtn();
        backBtn = addNewPage.getBackBtn();
    }

    private void initListeners(){
        backBtn.addActionListener(new backButton());
        createBtn.addActionListener(new addNewTimeEntryEntry());
    }

    private class backButton implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e){
            MainPageController mainPageController = new MainPageController();
            mainPageController.showMainPageController();
            closeAddNewPageController();
        }
    }

    private class addNewTimeEntryEntry implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            addNewTimeEntryEntry();
        }
    }

    private void fillComboBoxes(){

        for (Project p: DatabaseConnection.getProjectList()
             ) {
            projectComboBox.addItem(p.getName());
        }
        for (Users u: DatabaseConnection.getUsersList()
             ) {
            userComboBox.addItem(u.getUserName());
        }
        updateSize();
    }

    private void setCurrentDate(){
        LocalDate today = LocalDate.now();
        String monthString, dayString;
        int year = today.getYear();
        int month = today.getMonthValue();
        int day = today.getDayOfMonth();
        if(month < 10){
            monthString = "0" + month;
        }
        else{
            monthString = "" + month;
        }
        if(day < 10){
            dayString = "0" + day;
        }
        else{
            dayString = "" + day;
        }

        String currentDateString = year + "-" + monthString + "-" + dayString;
        dateTextField.setText(currentDateString);
    }

    private void updateSize(){
        addNewPage.setSize(500,500);
    }

    private void addNewTimeEntryEntry(){
        if(DatabaseConnection.projectExists(projectComboBox.getSelectedItem().toString())){
            Project timeEntryProject = DatabaseConnection.findProject(projectComboBox.getSelectedItem().toString());
            if(DatabaseConnection.userExists(userComboBox.getSelectedItem().toString())){
                Users timeEntryUser = DatabaseConnection.findUser(userComboBox.getSelectedItem().toString());
                if(checkDateString(dateTextField.getText())){
                    String date = correctDateString(dateTextField.getText());
                    if(checkTimeUsed(timeUsedTextField.getText())){
                        Double timeUsed = correctTimeUsed(timeUsedTextField.getText());
                        String description = checkDescription(descriptionTextField.getText());
                        DatabaseConnection.addTimeEntry(new TimeEntry(0,timeEntryProject, timeUsed, description, date, timeEntryUser));
                    }
                    else{
                        JOptionPane.showMessageDialog(addNewPage, "Invalid Time entered, need to be a number or number followed by descimal: 'XX' or 'XX.X'");
                    }
                }
                else{
                    JOptionPane.showMessageDialog(addNewPage, "Invalid Date format, please input date in this format: 'YYYY-MM-DD'");
                }
            }
            else{
                JOptionPane.showMessageDialog(addNewPage, "Invalid Users, please select a user from the ComboBox");
            }
        }
        else{
            JOptionPane.showMessageDialog(addNewPage, "Invalid Project, please select a project from the ComboBox.");
        }
    }

    private boolean checkDateString(String input){
        String inputArray[] = input.split("-");
        if(inputArray.length == 3){
            int year = Integer.parseInt(inputArray[0]);
            int month = Integer.parseInt(inputArray[1]);
            int day = Integer.parseInt(inputArray[2]);
            if(year > 1900 && month > 0 && month <= 12 && day > 0 && day < 31){
                return true;
            }
        }
        return false;
    }

    private String correctDateString(String input){
        String inputArray[] = input.split("-");
        String monthString, dayString;
        int year = Integer.parseInt(inputArray[0]);
        int month = Integer.parseInt(inputArray[1]);
        int day = Integer.parseInt(inputArray[2]);
        if(month < 10){
            monthString = "0" + month;
        }
        else{
            monthString = "" + month;
        }
        if(day < 10){
            dayString = "0" + day;
        }
        else{
            dayString = "" + day;
        }
        return year + "-" + monthString + "-" + dayString;
    }

    private boolean checkTimeUsed(String input){
        try {
            Double.parseDouble(input);
            return true;
        }
        catch (NumberFormatException e){
            return false;
        }
    }

    private Double correctTimeUsed(String input){
        return Double.parseDouble(input);
    }

    private String checkDescription(String input){
        if(input.isEmpty()){
            return "Ingen beskrivelse lagt til.";
        }
        return input;
    }

}
