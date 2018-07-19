package app.controller;

import app.model.DatabaseConnection;
import app.model.Project;
import app.model.TimeEntry;
import app.view.SeeTimeEntryPage;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class SeeTimeEntryPageController {

    private SeeTimeEntryPage seeTimeEntryPage;
    private JList timeEntryJList;
    private JButton backBtn;
    private JComboBox projectComboBox;
    private JButton getSpesificButton;
    private JScrollPane jScrollPane;

    public SeeTimeEntryPageController(){
        initComponents();
        initListeners();
        fillTimeEntryJList();
        fillProjectComboBox();
    }

    public void showSeeTimeEntryPageController(){
        seeTimeEntryPage.setVisible(true);
    }

    public void closeSeeTimeEntryPageController(){
        seeTimeEntryPage.setVisible(false);
        seeTimeEntryPage.dispose();
    }

    private void initComponents(){
        seeTimeEntryPage = new SeeTimeEntryPage();
        timeEntryJList = seeTimeEntryPage.getTimeEntryJList();
        jScrollPane = seeTimeEntryPage.getjScrollPane();
        jScrollPane.setViewportView(timeEntryJList);
        backBtn = seeTimeEntryPage.getBackButton();
        projectComboBox = seeTimeEntryPage.getProjectComboBox();
        getSpesificButton = seeTimeEntryPage.getGetSpesificButton();
    }

    private void initListeners(){
        backBtn.addActionListener(new backButton());
        getSpesificButton.addActionListener(new getButton());
    }

    private class backButton implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            MainPageController mainPageController =  new MainPageController();
            mainPageController.showMainPageController();
            closeSeeTimeEntryPageController();
        }
    }

    private class getButton implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            timeEntryJList.clearSelection();
            DefaultListModel listModel = new DefaultListModel();
            ArrayList<TimeEntry> timeEntryArrayList = DatabaseConnection.getTimeEntryByProject(projectComboBox.getSelectedItem().toString());
            for (TimeEntry te: timeEntryArrayList
                    ){
                        listModel.addElement(te.toString());
                    }
            timeEntryJList.setModel(listModel);
            }
        }

    private void fillTimeEntryJList(){
        DefaultListModel listModel = new DefaultListModel();
        for (TimeEntry te: DatabaseConnection.getTimeEntryList()
             ) {
            listModel.addElement(te.toString());
        }
        timeEntryJList.setModel(listModel);
        updateSize();
    }

    private void fillProjectComboBox(){
        for (Project p: DatabaseConnection.getProjectList()
             ) {
            projectComboBox.addItem(p.getName());
        }
        updateSize();
    }

    private void updateSize(){
        seeTimeEntryPage.setSize(1000,500);
    }
}
