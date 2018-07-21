package app.controller.admin;

import app.controller.AdminPageController;
import app.model.DatabaseConnection;
import app.model.Project;
import app.view.admin.EditProjectPage;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
        timeusedTextField = editProjectPage.getTimeusedTextField();
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
            System.out.println("CONFIRMING");
        }
    }

    private class deleteButton implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("DELETING");
        }
    }

    private class abortButton implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("ABORTING");
        }
    }

    private class editButton implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("EDITING");
        }
    }

    private void fillProjectComboBox(){
        for (Project p: DatabaseConnection.getProjectList()
             ) {
                projectComboBox.addItem(p.getName());
        }
    }
}
