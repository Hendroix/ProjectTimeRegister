import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;

public class project {
    private String name;
    private String description;
    private double timeUsed;
    private Date startDate;
    private Date endDate;
    private ArrayList<timeEntry> timeList = new ArrayList<>();

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
    public void addTimeUsed(double timeUsed){
        this.timeUsed += timeUsed;
    }

    public String printTimeUsed() {
        int days = (int)timeUsed / 24;
        double hoursLeft = timeUsed - (days * 24);
        int hours = (int)hoursLeft;
        double minLeft = (hoursLeft - ((int)hoursLeft)) * 60;
        int min = (int)minLeft;
        return "Dager: " + days + ", Timer: " + hours + ", Minutter: " + min + " TOTALT: " + String.format("%.2f",timeUsed);
    }

    public Date getStartDate() {
        return startDate;
    }

    public String printStartDate(){
        LocalDate localDate = startDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
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
        return dayString + "." + monthString + "." + year;
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

    public String printEndDate(){
        if(endDate != null){
            LocalDate localDate = endDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
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
            return "Avsluttet " + dayString + "." + monthString + "." + year + ". ";
        }else{
            return "Under utvikling. ";
        }
    }

    public ArrayList<timeEntry> getTimeList() {
        return timeList;
    }
    public void addToTimeList(timeEntry timeEntry){
        timeList.add(timeEntry);
        updateTime(this);
    }
    public static void updateTime(project project){
        double timeUsed = 0;
        for (int i = 0; i < project.getTimeList().size(); i++){
            timeUsed += project.getTimeList().get(i).getTimeUsed();
        }
        project.setTimeUsed(timeUsed);
    }
    @Override
    public String toString() {
        return "Prosjekt: '" + name + "'. Tid brukt: " + printTimeUsed() + ". Startet " + printStartDate() + ". " + printEndDate() + "Antall logginger: " + timeList.size() + ".";
    }
}
