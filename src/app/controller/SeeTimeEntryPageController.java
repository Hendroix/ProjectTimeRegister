package app.controller;

import app.model.DatabaseConnection;
import app.model.TimeEntry;
import app.view.SeeTimeEntryPage;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SeeTimeEntryPageController {

    private SeeTimeEntryPage seeTimeEntryPage;
    private JList timeEntryJList;
    private JButton backBtn;

    public SeeTimeEntryPageController(){
        initComponents();
        initListeners();
        fillTimeEntryJList();
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
        backBtn = seeTimeEntryPage.getBackButton();
    }

    private void initListeners(){
        backBtn.addActionListener(new backButton());
    }

    private class backButton implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            MainPageController mainPageController =  new MainPageController();
            mainPageController.showMainPageController();
            closeSeeTimeEntryPageController();
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

    private void updateSize(){
        seeTimeEntryPage.setSize(1000,500);
    }
}
