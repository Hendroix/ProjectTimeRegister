package app.view;

import javax.swing.*;

public class MainPage extends JFrame{

    private JPanel mainJPanel;
    private JButton usersButton;
    private JButton logoutButton;
    private JButton projectButton;
    private JButton timeEntryButton;
    private JButton newEntryButton;
    private JButton adminButton;

    public MainPage(){
        setSize(500,500);
        setContentPane(mainJPanel);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public JButton getUsersButton() {
        return usersButton;
    }

    public void setUsersButton(JButton usersButton) {
        this.usersButton = usersButton;
    }

    public JButton getLogoutButton() {
        return logoutButton;
    }

    public void setLogoutButton(JButton logoutButton) {
        this.logoutButton = logoutButton;
    }

    public JButton getProjectButton() {
        return projectButton;
    }

    public void setProjectButton(JButton projectButton) {
        this.projectButton = projectButton;
    }

    public JButton getTimeEntryButton() {
        return timeEntryButton;
    }

    public void setTimeEntryButton(JButton timeEntryButton) {
        this.timeEntryButton = timeEntryButton;
    }

    public JButton getNewEntryButton() {
        return newEntryButton;
    }

    public void setNewEntryButton(JButton newEntryButton) {
        this.newEntryButton = newEntryButton;
    }

    public JButton getAdminButton() {
        return adminButton;
    }

    public void setAdminButton(JButton adminButton) {
        this.adminButton = adminButton;
    }
}
