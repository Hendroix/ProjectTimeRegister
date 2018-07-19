package app.model;

import java.util.ArrayList;

public class Project {
    private String name;
    private String description;
    private double timeUsed;
    private String startDate;
    private String endDate;
    private ArrayList<TimeEntry> timeList = new ArrayList<>();
    private ArrayList<Users> usersList = new ArrayList<>();

    public Project(String name, String description, double timeUsed, String startDate, String endDate) {
        this.name = name;
        this.description = description;
        this.timeUsed = timeUsed;
        this.startDate = startDate;
        this.endDate = endDate;
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

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public ArrayList<TimeEntry> getTimeList() {
        return timeList;
    }

    public void addToTimeList(TimeEntry TimeEntry){
        timeList.add(TimeEntry);
        addUserToUserList(TimeEntry.getUsers());
    }

    public String printEndDate(){
     String endDateString = endDate;
     if(endDateString.equals(startDate)){
         return "Under utvikling";
     }else{
         return endDateString;
     }
    }

    public ArrayList<Users> getUsersList() {
        return usersList;
    }

    public void addUserToUserList(Users Users) {
        boolean exsists = false;
        for(var i = 0; i < usersList.size(); i++){
            if(Users == usersList.get(i)){
                exsists = true;
            }
        }
        if(!exsists){
            usersList.add(Users);
        }
    }

    @Override
    public String toString() {
        return "Prosjekt: '" + name + "'. Tid brukt: " + printTimeUsed() + ". Startet " + startDate + ". " + printEndDate() + ". Antall loggninger: " + timeList.size() +
                ", av " + usersList.size() + " person(er).";
    }
}
