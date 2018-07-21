package app.controller.admin;

import app.controller.AdminPageController;
import app.model.DatabaseConnection;
import app.model.TimeEntry;
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
        fillTimeEntryComboBox();
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

    private void fillTimeEntryComboBox(){
        for (TimeEntry te: DatabaseConnection.getTimeEntryList()
             ) {
            timeEntryComboBox.addItem(te);
        }
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
            System.out.println("EDITING");
        }
    }

    private class deleteButton implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("DELETING");
        }
    }

    private class confirmButton implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("CONFIRMING");
        }
    }

    private class abortButton implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("ABORTING");
        }
    }

}
