import java.util.ArrayList;
import java.util.Date;

public class project {
    public String name;
    public String description;
    public double timeUsed;
    public Date startDate;
    public Date endDate;
    public ArrayList<timeEntry> timeList = new ArrayList<>();

    public project(String name, String description, Date startDate) {
        this.name = name;
        this.description = description;
        this.startDate = startDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getTimeUsed() {
        return timeUsed;
    }

    public void setTimeUsed(double timeUsed){
        this.timeUsed = timeUsed;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public ArrayList<timeEntry> getTimeList() {
        return timeList;
    }

    public void setTimeList(ArrayList<timeEntry> timeList) {
        this.timeList = timeList;
    }
    public void addToTimeList(timeEntry timeEntry){
        this.timeList.add(timeEntry);
    }

    @Override
    public String toString() {
        return name + ", tid brukt: " + timeUsed + ". Startet " + startDate + ". Antall logginger: " + timeList.size();
    }
}
