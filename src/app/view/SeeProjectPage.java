package app.view;

import javax.swing.*;

public class SeeProjectPage extends JFrame {

    private JPanel panel1;
    private JList projectJList;
    private JButton backBtn;

    public SeeProjectPage() {
        setSize(500,500);
        setContentPane(panel1);
        setLocationRelativeTo(null);
    }

    public JList getProjectJList() {
        return projectJList;
    }

    public void setProjectJList(JList projectJList) {
        this.projectJList = projectJList;
    }

    public JButton getBackBtn() {
        return backBtn;
    }

    public void setBackBtn(JButton backBtn) {
        this.backBtn = backBtn;
    }
}
