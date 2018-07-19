package app.view;

import javax.swing.*;

public class SeeTimeEntryPage extends JFrame{

    private JPanel panel;
    private JList timeEntryJList;
    private JButton backButton;
    private JComboBox projectComboBox;
    private JButton getSpesificButton;
    private JScrollPane jScrollPane;

    public SeeTimeEntryPage(){
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

    public JList getTimeEntryJList() {
        return timeEntryJList;
    }

    public void setTimeEntryJList(JList timeEntryJList) {
        this.timeEntryJList = timeEntryJList;
    }

    public JButton getBackButton() {
        return backButton;
    }

    public void setBackButton(JButton backButton) {
        this.backButton = backButton;
    }

    public JComboBox getProjectComboBox() {
        return projectComboBox;
    }

    public void setProjectComboBox(JComboBox projectComboBox) {
        this.projectComboBox = projectComboBox;
    }

    public JButton getGetSpesificButton() {
        return getSpesificButton;
    }

    public void setGetSpesificButton(JButton getSpesificButton) {
        this.getSpesificButton = getSpesificButton;
    }

    public JScrollPane getjScrollPane() {
        return jScrollPane;
    }

    public void setjScrollPane(JScrollPane jScrollPane) {
        this.jScrollPane = jScrollPane;
    }
}
