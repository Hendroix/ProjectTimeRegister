package app.model;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;

public class Project {
    private String name;
    private String description;
    private double timeUsed;
    private Date startDate;
    private Date endDate;
    private ArrayList<TimeEntry> timeList = new ArrayList<>();
    private ArrayList<Users> usersList = new ArrayList<>();

    public Project(String name, String description, double timeUsed, Date startDate, Date endDate) {
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

    public String dbStartDate(){
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
        return year + "-" + monthString + "-" + dayString;
    }

    public String dbEndDate() {
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
            return year + "-" + monthString + "-" + dayString;
        }else{
            return "2000-01-01";
        }
    }

    public String printEndDate(){
        if(endDate != null && endDate.after(startDate)){
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

    public ArrayList<TimeEntry> getTimeList() {
        return timeList;
    }

    public void addToTimeList(TimeEntry TimeEntry){
        timeList.add(TimeEntry);
        addUserToUserList(TimeEntry.getUsers());
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
        return "Prosjekt: '" + name + "'. Tid brukt: " + printTimeUsed() + ". Startet " + printStartDate() + ". " + printEndDate() + "Antall logginger: " + timeList.size() + ", av " + usersList.size() + " person(er).";
    }
}
