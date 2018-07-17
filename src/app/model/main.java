package app.model;

import java.util.Date;
import java.util.stream.Stream;

import app.controller.LoginPageController;
import app.controller.MainPageController;


public class main {
    public static Project testProject;
    public static boolean consolePrint = false;

    public static void main(String[] args){
        //fillDatabase();
        //printAllInfo();

        DatabaseConnection.getAllProjects(consolePrint);
        DatabaseConnection.getAllUsers(consolePrint);
        DatabaseConnection.getAllTimeEntries(consolePrint);

        MainPageController mainPageController = new MainPageController();
        mainPageController.showMainPageController();

    }

    private static void fillDatabase(){
        Users testUsers1, testUsers2, testUsers3;
        TimeEntry testEntry1,testEntry2,testEntry3,testEntry4,testEntry5,testEntry6,testEntry7,testEntry8,testEntry9,testEntry10,testEntry11;
        String name = "Time Registrerings System";
        String desc = "Timesregistrerings system i Java med Databasetilkobling/Lokaltilkobling.";
        Date date = new Date();
        testProject = new Project(name,desc, 0, date, date);
        testUsers1 = new Users("Hendroix","1234","Henrik","Olsen");
        testUsers2 = new Users("Opiah","4567","Ole","Tholderen");
        testUsers3 = new Users("Jakers","890+","Jake","Jacobsen");
        testEntry1 = new TimeEntry(0,testProject, randomWithinRange(1,8),desc,date, testUsers1);
        testEntry2 = new TimeEntry(0,testProject, randomWithinRange(1,8),desc,date, testUsers1);
        testEntry3 = new TimeEntry(0,testProject, randomWithinRange(1,8),desc,date, testUsers2);
        testEntry4 = new TimeEntry(0,testProject, randomWithinRange(1,8),desc,date, testUsers3);
        testEntry5 = new TimeEntry(0,testProject, randomWithinRange(1,8),desc,date, testUsers2);
        testEntry6 = new TimeEntry(0,testProject, randomWithinRange(1,8),desc,date, testUsers1);
        testEntry7 = new TimeEntry(0,testProject, randomWithinRange(1,8),desc,date, testUsers2);
        testEntry8 = new TimeEntry(0,testProject, randomWithinRange(1,8),desc,date, testUsers3);
        testEntry9 = new TimeEntry(0,testProject, randomWithinRange(1,8),desc,date, testUsers2);
        testEntry10 = new TimeEntry(0,testProject, randomWithinRange(1,8),desc,date, testUsers1);
        testEntry11 = new TimeEntry(0,testProject, randomWithinRange(1,8),desc,date, testUsers3);
        DatabaseConnection.addProject(testProject);
        DatabaseConnection.addUser(testUsers1);
        DatabaseConnection.addUser(testUsers2);
        DatabaseConnection.addUser(testUsers3);
        DatabaseConnection.addTimeEntry(testEntry1);
        DatabaseConnection.addTimeEntry(testEntry2);
        DatabaseConnection.addTimeEntry(testEntry3);
        DatabaseConnection.addTimeEntry(testEntry4);
        DatabaseConnection.addTimeEntry(testEntry5);
        DatabaseConnection.addTimeEntry(testEntry6);
        DatabaseConnection.addTimeEntry(testEntry7);
        DatabaseConnection.addTimeEntry(testEntry8);
        DatabaseConnection.addTimeEntry(testEntry9);
        DatabaseConnection.addTimeEntry(testEntry10);
        DatabaseConnection.addTimeEntry(testEntry11);
    }

    private static void printAllInfo(){
        for (Project p: DatabaseConnection.PROJECT_LIST
                ) {
            System.out.println(p.toString());
        }
        for (Users u: DatabaseConnection.USERS_LIST
                ) {
            System.out.println(u.toString());
        }
        for (TimeEntry te: DatabaseConnection.TIME_ENTRY_LIST
                ) {
            System.out.println(te.toString());
        }
    }

    private static double randomWithinRange(int min, int max){
        double range = (max - min) + 1;
        return (Math.random() * range) + min;
    }
}
