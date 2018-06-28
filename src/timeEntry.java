import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class timeEntry {
    private project project;
    private static double timeUsed;
    private String description;
    private Date dateAdded;
    private user user;

    public timeEntry(project project, double timeUsed, String description, Date dateAdded, user user) {
        this.project = project;
        this.timeUsed = timeUsed;
        this.description = description;
        this.dateAdded = dateAdded;
        this.user = user;
        databaseConnection.addTimeEntry(this);
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

    public user getUser() {
        return user;
    }
    public void setUser(user user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return project.getName() + ", added: " + timeUsed + ", for " + dateAdded;
    }
}
