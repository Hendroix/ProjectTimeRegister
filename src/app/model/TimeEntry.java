package app.model;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class TimeEntry {
    private int entryID;
    private Project Project;
    private double timeUsed;
    private String description;
    private String dateAdded;
    private Users Users;

    public TimeEntry(int entryID, Project Project, double timeUsed, String description, String dateAdded, Users Users) {
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

    public String getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(String dateAdded) {
        this.dateAdded = dateAdded;
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
        return entryID + "|" + Project.getName() + ", '" + description + "' added: " + dateAdded + ", for " + timeUsed + ", By " + Users.getUserName();
    }
}
