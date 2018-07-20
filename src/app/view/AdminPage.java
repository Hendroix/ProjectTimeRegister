package app.view;

import javax.swing.*;

public class AdminPage extends JFrame{

    private JPanel panel;
    private JButton newProjectButton;
    private JButton backButton;
    private JButton changeTimeEntryButton;
    private JButton editUserButton;
    private JButton editProjectButton;
    private JButton newUserButton;

    public AdminPage(){
        setSize(500,500);
        setContentPane(panel);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public JPanel getPanel() {
        return panel;
    }

    public void setPanel(JPanel panel) {
        this.panel = panel;
    }

    public JButton getNewProjectButton() {
        return newProjectButton;
    }

    public void setNewProjectButton(JButton newProjectButton) {
        this.newProjectButton = newProjectButton;
    }

    public JButton getBackButton() {
        return backButton;
    }

    public void setBackButton(JButton backButton) {
        this.backButton = backButton;
    }

    public JButton getChangeTimeEntryButton() {
        return changeTimeEntryButton;
    }

    public void setChangeTimeEntryButton(JButton changeTimeEntryButton) {
        this.changeTimeEntryButton = changeTimeEntryButton;
    }

    public JButton getEditUserButton() {
        return editUserButton;
    }

    public void setEditUserButton(JButton editUserButton) {
        this.editUserButton = editUserButton;
    }

    public JButton getEditProjectButton() {
        return editProjectButton;
    }

    public void setEditProjectButton(JButton editProjectButton) {
        this.editProjectButton = editProjectButton;
    }

    public JButton getNewUserButton() {
        return newUserButton;
    }

    public void setNewUserButton(JButton newUserButton) {
        this.newUserButton = newUserButton;
    }
}
