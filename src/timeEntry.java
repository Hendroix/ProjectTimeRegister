import java.util.Date;

public class timeEntry {
    private project project;
    private static double timeUsed;
    private String description;
    private Date dateAdded;

    public timeEntry(project project, double timeUsed, String description, Date dateAdded) {
        this.project = project;
        this.timeUsed = timeUsed;
        this.description = description;
        this.dateAdded = dateAdded;

    }

    public project getProject() {
        return project;
    }

    public void setProject(project project) {
        this.project = project;
    }

    public static double getTimeUsed() {
        return timeUsed;
    }

    public void setTimeUsed(double timeUsed) {
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

    public void setDateAdded(Date dateAdded) {
        this.dateAdded = dateAdded;
    }

    @Override
    public String toString() {
        return project.getName() + ", added: " + timeUsed + ", for " + dateAdded;
    }
}
