package app.controller;

import app.model.DatabaseConnection;
import app.model.Project;
import app.model.Users;
import app.view.AddNewPage;

import javax.swing.*;
import javax.xml.crypto.Data;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

    private void updateSize(){
        addNewPage.setSize(500,500);
    }

    private void addNewTimeEntryEntry(){
        Project timeEntryProject = DatabaseConnection.findProject(projectComboBox.getSelectedItem().toString());
        System.out.println(timeEntryProject);
        Users timeEntryUser = DatabaseConnection.findUser(userComboBox.getSelectedItem().toString());
        System.out.println(timeEntryUser);
        String date = checkDateString(dateTextField.getText());
        System.out.println(date);
        String description = descriptionTextField.getText();
        System.out.println(description);
        String timeUsed = checkTimeUsed(timeUsedTextField.getText());
        System.out.println(timeUsed);
    }

    private String checkDateString(String input){
        return input;
    }

    private String checkTimeUsed(String input){
        return input;
    }

}
