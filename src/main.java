import java.util.Date;

public class main {
    public static project testProject;
    public static void main(String[] args){
        String name = "Test";
        String desc = "Test 1 2 3 4 5 6 7 8 9 0";
        Date date = new Date();
        testProject = new project(name,desc,date);
        testProject.getTimeList().add(new timeEntry(testProject, randomWithinRange(20,500),desc,date));
        testProject.getTimeList().add(new timeEntry(testProject, randomWithinRange(20,500),desc,date));
        testProject.getTimeList().add(new timeEntry(testProject, randomWithinRange(20,500),desc,date));
        testProject.getTimeList().add(new timeEntry(testProject, randomWithinRange(20,500),desc,date));
        testProject.getTimeList().add(new timeEntry(testProject, randomWithinRange(20,500),desc,date));
        testProject.getTimeList().add(new timeEntry(testProject, randomWithinRange(20,500),desc,date));
        testProject.getTimeList().add(new timeEntry(testProject, randomWithinRange(20,500),desc,date));
        testProject.getTimeList().add(new timeEntry(testProject, randomWithinRange(20,500),desc,date));
        testProject.getTimeList().add(new timeEntry(testProject, randomWithinRange(20,500),desc,date));
        testProject.getTimeList().add(new timeEntry(testProject, randomWithinRange(20,500),desc,date));
        updateTime();
        System.out.print(testProject);
    }
    public static void updateTime(){
        for (int i = 0; i < testProject.getTimeList().size(); i++){
            double timeUsed = testProject.getTimeList().get(i).getTimeUsed();
            testProject.addTimeUsed(timeUsed);
        }
    }
    public static double randomWithinRange(int min, int max){
        double range = (max - min) + 1;
        return (Math.random() * range) + min;
    }
}
