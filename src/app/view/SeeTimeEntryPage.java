package app.view;

import javax.swing.*;

public class SeeTimeEntryPage extends JFrame{

    private JPanel panel;
    private JList timeEntryJList;
    private JButton backButton;

    public SeeTimeEntryPage(){
        setSize(500,500);
        setContentPane(panel);
        setLocationRelativeTo(null);
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
}
