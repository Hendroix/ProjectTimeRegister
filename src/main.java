import java.util.Date;

public class main {
    public static project testProject;
    public static void main(String[] args){
        String name = "Time Registrerings System";
        String desc = "Timesregistrerings system i Java med Databasetilkobling/Lokaltilkobling.";
        Date date = new Date();
        testProject = new project(name,desc,date);
        testProject.addToTimeList(new timeEntry(testProject, randomWithinRange(1,8),desc,date));
        testProject.addToTimeList(new timeEntry(testProject, randomWithinRange(1,8),desc,date));
        testProject.addToTimeList(new timeEntry(testProject, randomWithinRange(1,8),desc,date));
        testProject.addToTimeList(new timeEntry(testProject, randomWithinRange(1,8),desc,date));
        testProject.addToTimeList(new timeEntry(testProject, randomWithinRange(1,8),desc,date));
        testProject.addToTimeList(new timeEntry(testProject, randomWithinRange(1,8),desc,date));
        testProject.addToTimeList(new timeEntry(testProject, randomWithinRange(1,8),desc,date));
        testProject.addToTimeList(new timeEntry(testProject, randomWithinRange(1,8),desc,date));
        System.out.print(testProject);
    }

    public static double randomWithinRange(int min, int max){
        double range = (max - min) + 1;
        return (Math.random() * range) + min;
    }
}
