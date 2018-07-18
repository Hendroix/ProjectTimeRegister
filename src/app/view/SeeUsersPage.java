package app.view;

import javax.swing.*;

public class SeeUsersPage extends JFrame {

    private JPanel panel;
    private JButton backBtn;
    private JList userList;

    public SeeUsersPage(){
        setSize(500,500);
        setContentPane(panel);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public JButton getBackBtn() {
        return backBtn;
    }

    public void setBackBtn(JButton backBtn) {
        this.backBtn = backBtn;
    }

    public JList getUserList() {
        return userList;
    }

    public void setUserList(JList userList) {
        this.userList = userList;
    }
}
