import java.util.Date;

public class main {
    public static project testProject;
    public static boolean consolePrint = false;

    public static void main(String[] args){
        //fillDatabase();
        //printAllInfo();

        databaseConnection.getAllProjects(consolePrint);
        databaseConnection.getAllUsers(consolePrint);
        databaseConnection.getAllTimeEntries(consolePrint);

    }

    private static void fillDatabase(){
        user testUser1, testUser2, testUser3;
        timeEntry testEntry1,testEntry2,testEntry3,testEntry4,testEntry5,testEntry6,testEntry7,testEntry8,testEntry9;
        String name = "Time Registrerings System";
        String desc = "Timesregistrerings system i Java med Databasetilkobling/Lokaltilkobling.";
        Date date = new Date();
        testProject = new project(name,desc, 0, date, date);
        testUser1 = new user("Hendroix","1234","Henrik","Olsen");
        testUser2 = new user("Opiah","4567","Ole","Tholderen");
        testUser3 = new user("Jakers","890+","Jake","Jacobsen");
        testEntry1 = new timeEntry(0,testProject, randomWithinRange(1,8),desc,date,testUser1);
        testEntry2 = new timeEntry(0,testProject, randomWithinRange(1,8),desc,date,testUser1);
        testEntry3 = new timeEntry(0,testProject, randomWithinRange(1,8),desc,date,testUser2);
        testEntry4 = new timeEntry(0,testProject, randomWithinRange(1,8),desc,date,testUser2);
        testEntry5 = new timeEntry(0,testProject, randomWithinRange(1,8),desc,date,testUser2);
        testEntry6 = new timeEntry(0,testProject, randomWithinRange(1,8),desc,date,testUser2);
        testEntry7 = new timeEntry(0,testProject, randomWithinRange(1,8),desc,date,testUser2);
        testEntry8 = new timeEntry(0,testProject, randomWithinRange(1,8),desc,date,testUser2);
        testEntry9 = new timeEntry(0,testProject, randomWithinRange(1,8),desc,date,testUser2);
        databaseConnection.addProject(testProject);
        databaseConnection.addUser(testUser1);
        databaseConnection.addUser(testUser2);
        databaseConnection.addUser(testUser3);
        databaseConnection.addTimeEntry(testEntry1);
        databaseConnection.addTimeEntry(testEntry2);
        databaseConnection.addTimeEntry(testEntry3);
        databaseConnection.addTimeEntry(testEntry4);
        databaseConnection.addTimeEntry(testEntry5);
        databaseConnection.addTimeEntry(testEntry6);
        databaseConnection.addTimeEntry(testEntry7);
        databaseConnection.addTimeEntry(testEntry8);
        databaseConnection.addTimeEntry(testEntry9);
    }

    private static void printAllInfo(){
        for (project p: databaseConnection.projectList
                ) {
            System.out.println(p.toString());
        }
        for (user u: databaseConnection.userList
                ) {
            System.out.println(u.toString());
        }
        for (timeEntry te: databaseConnection.timeEntryList
                ) {
            System.out.println(te.toString());
        }
    }

    private static double randomWithinRange(int min, int max){
        double range = (max - min) + 1;
        return (Math.random() * range) + min;
    }
}
