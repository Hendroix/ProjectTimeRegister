package app.model;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class TimeEntry {
    private int entryID;
    private Project Project;
    private double timeUsed;
    private String description;
    private Date dateAdded;
    private Users Users;

    public TimeEntry(int entryID, Project Project, double timeUsed, String description, Date dateAdded, Users Users) {
        this.entryID = entryID;
        this.Project = Project;
        this.timeUsed = timeUsed;
        this.description = description;
        this.dateAdded = dateAdded;
        this.Users = Users;
    }

    public Project getProject() {
        return Project;
    }

    public void setProject(Project Project) {
        this.Project = Project;
    }

    public double getTimeUsed() {
        return timeUsed;
    }

    private void setTimeUsed(double timeUsed) {
        this.timeUsed = timeUsed;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDateAdded() {
        return dateAdded;
    }

    public String dbDateAdded(){
        LocalDate localDate = dateAdded.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        int year = localDate.getYear();
        int month = localDate.getMonthValue();
        String monthString;
        String dayString;
        if (month < 10) {
            monthString = "0" + month;
        } else {
            monthString = "" + month;
        }
        int day = localDate.getDayOfMonth();
        if (day < 10) {
            dayString = "0" + day;
        } else {
            dayString = "" + day;
        }
        return year + "-" + monthString + "-" + dayString;
    }

    public void setDateAdded(Date dateAdded) {
        this.dateAdded = dateAdded;
    }

    public String printDateAdded(){
        LocalDate localDate = dateAdded.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        int year = localDate.getYear();
        int month = localDate.getMonthValue();
        String monthString;
        String dayString;
        if(month < 10){
            monthString = "0" + month;
        }else{
            monthString = "" + month;
        }
        int day = localDate.getDayOfMonth();
        if(day < 10){
            dayString = "0" + day;
        }else{
            dayString = "" + day;
        }
        String dateString = dayString + "." + monthString + "." + year;
        return dateString;
    }

    public Users getUsers() {
        return Users;
    }

    public void setUsers(Users Users) {
        this.Users = Users;
    }

    public int getEntryID() {
        return entryID;
    }

    private void setEntryID(int entryID) {
        this.entryID = entryID;
    }

    @Override
    public String toString() {
        return entryID + "|" + Project.getName() + ", added: " + timeUsed + ", for " + printDateAdded() + ", By " + Users.getUserName();
    }
}
