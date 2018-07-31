package app.controller.admin;

import app.controller.AdminPageController;
import app.model.DatabaseConnection;
import app.model.Project;
import app.view.AdminPage;
import app.view.MainPage;
import app.view.admin.*;
import javafx.scene.control.DialogPane;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

import static jdk.nashorn.internal.objects.NativeMath.round;

public class NewProjectPageController {

    private NewProjectPage newProjectPage;
    private JTextField nameTextField;
    private JTextField timeUsedTextField;
    private JTextField descriptionTextField;
    private JTextField startDateTextField;
    private JTextField endDateTextField;
    private JButton backButton;
    private JButton createButton;

    private static DecimalFormat df2 = new DecimalFormat(".##");

    public NewProjectPageController(){
        initComponents();
        initListeners();
        setDefaults();
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

    private class createButton implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (nameTextField.getText() != null && nameTextField.getText().length() >= 4) {
                String projectName = nameTextField.getText();
                if (descriptionTextField.getText() != null && descriptionTextField.getText().length() >= 20) {
                    String projectDescription = descriptionTextField.getText();
                    if (timeUsedTextField.getText() != null) {
                        Double timeUsed = 0.00;
                        if (startDateTextField != null && checkDateStarted()) {
                            String dateStarted = startDateTextField.getText();
                            if (endDateTextField != null && checkDateEnded()) {
                                String dateEnded = endDateTextField.getText();
                                Project newProject = new Project(projectName, projectDescription, timeUsed, dateStarted, dateEnded);
                                if(DatabaseConnection.checkIfProjectInArray(newProject)){
                                    DatabaseConnection.addProject(newProject);
                                    clearTextFields();
                                }
                            }
                        }
                    }
                }else{
                    JOptionPane.showMessageDialog(null,"Project description needs to be aleast 20 characters long.");
                }
            }else{
                JOptionPane.showMessageDialog(null,"Project name needs to be aleast 4 characters long.");
            }
        }
    }

    private boolean checkDateStarted(){
        try{
            DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
            dateFormat.setLenient(false);
            dateFormat.parse(startDateTextField.getText());
            return true;
        }catch (ParseException e){

            return false;
        }
    }

    private boolean checkDateEnded(){
        try{
            DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
            dateFormat.setLenient(false);
            dateFormat.parse(endDateTextField.getText());
            return true;
        }catch (ParseException e){

            return false;
        }
    }

    private void setDefaults(){
        LocalDate now = LocalDate.now();
        String year = "" + now.getYear();
        String month = "" + now.getMonthValue();
        String day = "" + now.getDayOfMonth();
        if(now.getMonthValue() < 10){
            month = "0" + month;
        }
        if(now.getDayOfMonth() < 10){
            day = "0" + day;
        }

        String today = year + "-" + month + "-" + day;
        startDateTextField.setText(today);
        endDateTextField.setText(today);
        timeUsedTextField.setText("0.00");

        timeUsedTextField.setEditable(false);
        endDateTextField.setEditable(false);

    }

    private void clearTextFields(){
    nameTextField.setText("");
    timeUsedTextField.setText("0.00");
    descriptionTextField.setText("");
    }


}
