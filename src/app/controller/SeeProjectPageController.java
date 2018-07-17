package app.controller;

import app.view.SeeProjectPage;
import app.model.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SeeProjectPageController {

    private SeeProjectPage seeProjectPage;
    private JList projectJList;
    private JButton backBtn;

    public SeeProjectPageController(){
        initComponents();
        initListeners();
        fillProjectJList();
    }

    public void showSeeProjectPageController(){
        seeProjectPage.setVisible(true);
    }

    public void closeSeeProjectPageController(){
        seeProjectPage.setVisible(false);
        seeProjectPage.dispose();
    }

    private void initComponents(){
        seeProjectPage = new SeeProjectPage();
        projectJList = seeProjectPage.getProjectJList();
        backBtn = seeProjectPage.getBackBtn();
    }

    private void initListeners(){
        backBtn.addActionListener(new backButton());

    }

    private class backButton implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            MainPageController mainPageController = new MainPageController();
            mainPageController.showMainPageController();
            closeSeeProjectPageController();
        }
    }

    private void fillProjectJList(){
        DefaultListModel listModel = new DefaultListModel();
        for (Project p: DatabaseConnection.getProjectList()
             ) {
            listModel.addElement(p.toString());
        }
        projectJList.setModel(listModel);
        updateSize();
    }

    private void updateSize(){
        seeProjectPage.setSize(1000,500);
    }
}
