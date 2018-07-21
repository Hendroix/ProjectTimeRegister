package app.controller.admin;

import app.controller.AdminPageController;
import app.view.AdminPage;
import app.view.admin.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NewProjectPageController {

    private NewProjectPage newProjectPage;
    private JTextField nameTextField;
    private JTextField timeUsedTextField;
    private JTextField descriptionTextField;
    private JTextField startDateTextField;
    private JTextField endDateTextField;
    private JButton backButton;
    private JButton createButton;

    public NewProjectPageController(){
        initComponents();
        initListeners();
    }

    public void showNewProjcetPageController(){
        newProjectPage.setVisible(true);
    }

    public void closeNewProjectPageController(){
        newProjectPage.setVisible(false);
        newProjectPage.dispose();
    }

    private void initComponents(){
        newProjectPage = new NewProjectPage();
        nameTextField = newProjectPage.getNameTextField();
        descriptionTextField = newProjectPage.getDescriptionTextField();
        timeUsedTextField = newProjectPage.getTimeUsedTextField();
        startDateTextField = newProjectPage.getStartDateTextField();
        endDateTextField = newProjectPage.getEndDateTextField();
        backButton = newProjectPage.getBackButton();
        createButton = newProjectPage.getCreateButton();

    }

    private void initListeners(){
        backButton.addActionListener(new backButton());
        createButton.addActionListener(new createButton());
    }

    private class backButton implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            AdminPageController adminPageController = new AdminPageController();
            adminPageController.showAdminPageController();
            closeNewProjectPageController();
        }
    }

    private class createButton implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Nå skal vi lage nytt prosjekt og legge det til i databasen.");
        }
    }


}
