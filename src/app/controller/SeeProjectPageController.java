package app.controller;

import app.view.SeeProjectPage;
import app.model.*;
import javax.swing.*;

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

    }
    private void fillProjectJList(){
        System.out.println(projectJList.getModel().getSize());
        DefaultListModel listModel = new DefaultListModel();
        for (Project p: DatabaseConnection.getProjectList()
             ) {
            listModel.addElement(p.toString());
        }
        projectJList.setModel(listModel);
        System.out.println(projectJList.getModel().getSize());
        System.out.println(projectJList.getModel().getElementAt(0));
    }
}
