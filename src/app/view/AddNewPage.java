package app.view;

import javax.swing.*;
import java.awt.*;

public class AddNewPage extends JFrame {

    private JButton createBtn;
    private JButton backBtn;
    private JPanel mainPanel;
    private JTextField timeUsedTextField;
    private JTextField descriptionTextField;
    private JTextField dateTextField;
    private JComboBox projectComboBox;
    private JComboBox userComboBox;

    public AddNewPage(){
        setSize(500,500);
        setContentPane(mainPanel);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public JButton getCreateBtn() {
        return createBtn;
    }

    public void setCreateBtn(JButton createBtn) {
        this.createBtn = createBtn;
    }

    public JButton getBackBtn() {
        return backBtn;
    }

    public void setBackBtn(JButton backBtn) {
        this.backBtn = backBtn;
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }

    public void setMainPanel(JPanel mainPanel) {
        this.mainPanel = mainPanel;
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

    public JTextField getDateTextField() {
        return dateTextField;
    }

    public void setDateTextField(JTextField dateTextField) {
        this.dateTextField = dateTextField;
    }

    public JComboBox getProjectComboBox() {
        return projectComboBox;
    }

    public void setProjectComboBox(JComboBox projectComboBox) {
        this.projectComboBox = projectComboBox;
    }

    public JComboBox getUserComboBox() {
        return userComboBox;
    }

    public void setUserComboBox(JComboBox userComboBox) {
        this.userComboBox = userComboBox;
    }
}
