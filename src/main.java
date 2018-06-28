import java.util.Date;
import java.sql.*;

public class main {
    public static project testProject;
    public static user testUser;
    public static timeEntry testTimeEntry;
    public static void main(String[] args){
        String name = "Time Registrerings System";
        String desc = "Timesregistrerings system i Java med Databasetilkobling/Lokaltilkobling.";
        Date date = new Date();
        testProject = new project(name,desc,date);
        //databaseConnection.addProject(testProject);
        testUser = new user("Hendroix","1234","Henrik","Olsen");
        //databaseConnection.addUser(testUser);
        testTimeEntry = new timeEntry(testProject, randomWithinRange(1,8),desc,date,testUser);
        //databaseConnection.addTimeEntry(testTimeEntry);
        testProject.addToTimeList(new timeEntry(testProject, randomWithinRange(1,8),desc,date,testUser));
        testProject.addToTimeList(new timeEntry(testProject, randomWithinRange(1,8),desc,date,testUser));
        testProject.addToTimeList(new timeEntry(testProject, randomWithinRange(1,8),desc,date,testUser));
        testProject.addToTimeList(new timeEntry(testProject, randomWithinRange(1,8),desc,date,testUser));
        testProject.addToTimeList(new timeEntry(testProject, randomWithinRange(1,8),desc,date,testUser));
        testProject.addToTimeList(new timeEntry(testProject, randomWithinRange(1,8),desc,date,testUser));
        testProject.addToTimeList(new timeEntry(testProject, randomWithinRange(1,8),desc,date,testUser));
        testProject.addToTimeList(new timeEntry(testProject, randomWithinRange(1,8),desc,date,testUser));
        System.out.print(testProject);
    }

    public static double randomWithinRange(int min, int max){
        double range = (max - min) + 1;
        return (Math.random() * range) + min;
    }
}
