package app.view.admin;

import javax.swing.*;

public class NewProjectPage extends JFrame{

    private JPanel panel;
    private JTextField endDateTextField;
    private JTextField nameTextField;
    private JTextField startDateTextField;
    private JTextField timeUsedTextField;
    private JTextField descriptionTextField;
    private JButton backButton;
    private JButton createButton;

    public NewProjectPage(){
        setSize(500,500);
        setContentPane(panel);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }


    public JButton getBackButton() {
        return backButton;
    }

    public void setBackButton(JButton backButton) {
        this.backButton = backButton;
    }

    public JButton getCreateButton() {
        return createButton;
    }

    public void setCreateButton(JButton createButton) {
        this.createButton = createButton;
    }

    public JTextField getEndDateTextField() {
        return endDateTextField;
    }

    public void setEndDateTextField(JTextField endDateTextField) {
        this.endDateTextField = endDateTextField;
    }

    public JTextField getNameTextField() {
        return nameTextField;
    }

    public void setNameTextField(JTextField nameTextField) {
        this.nameTextField = nameTextField;
    }

    public JTextField getStartDateTextField() {
        return startDateTextField;
    }

    public void setStartDateTextField(JTextField startDateTextField) {
        this.startDateTextField = startDateTextField;
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

    public JPanel getPanel() {
        return panel;
    }

    public void setPanel(JPanel panel) {
        this.panel = panel;
    }
}
