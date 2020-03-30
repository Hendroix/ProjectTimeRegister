package app.controller;

import app.view.SeeProjectPage;
import app.model.*;
import javax.swing.*;
import java.awt.event.*;

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
        projectJList.addMouseListener(new doubleClickList());
    }

    private class backButton implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            MainPageController mainPageController = new MainPageController();
            mainPageController.showMainPageController();
            closeSeeProjectPageController();
        }
    }

    private class doubleClickList extends MouseAdapter{
        @Override
        public void mouseClicked(MouseEvent e) {
            if(e.getClickCount() == 2){
                showInfoAboutClicked();
            }
        }
    }

    private void fillProjectJList(){
        DefaultListModel listModel = new DefaultListModel();
        for (Project p: DatabaseConnection.getProjectList()
             ) {
            listModel.addElement(p);
        }
        projectJList.setModel(listModel);
        updateSize();
    }

    private void showInfoAboutClicked(){
        Object selectedObject = projectJList.getSelectedValue();
        JOptionPane.showMessageDialog(null, ((Project) selectedObject).completeToString());

    }

    private void updateSize(){
        seeProjectPage.setSize(1000,500);
    }
}
