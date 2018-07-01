package app.model;

import java.sql.*;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.GregorianCalendar;

public class DatabaseConnection {
    static final String DRIVER = "com.mysql.jdbc.Driver";
    static final String url = "jdbc:mysql://hupe2.mysql.domeneshop.no/hupe2";
    static final String username = "hupe2";
    static final String passowrd = Databasepassword.getPassword();

    static final ArrayList<Users> USERS_LIST = new ArrayList<>();
    static final ArrayList<Project> PROJECT_LIST = new ArrayList<>();
    static final ArrayList<TimeEntry> TIME_ENTRY_LIST = new ArrayList<>();

    //USER SQL CALLS
    public static void addUser(Users Users){
        try {
            Class.forName(DRIVER);
            Connection connection = DriverManager.getConnection(url, username, passowrd);
            Statement statement = connection.createStatement();

            String sqlStatement = "INSERT INTO Users VALUES('" + Users.getUserName() + "','" + Users.getUserPass() +"','" + Users.getFirstName() + "','" + Users.getLastName()+ "')";
            //System.out.println("The Querry is:" + sqlStatement);
            statement.executeUpdate(sqlStatement);
        }
        catch(SQLException ex){
            ex.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static void getAllUsers(boolean print){
        if(print){
            System.out.println("USERS:");
        }
        try {
            Class.forName(DRIVER);
            Connection connection = DriverManager.getConnection(url, username, passowrd);
            Statement statement = connection.createStatement();

            String sqlStatement = "SELECT * FROM Users";
            ResultSet resultSet = statement.executeQuery(sqlStatement);
            while(resultSet.next()){
                Users tmp = new Users(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4));
                if(checkIfUserInArray(tmp)){
                USERS_LIST.add(tmp);
                }
                if(print){
                    System.out.println(tmp.toString());
                }
                }
        }catch (SQLException ex){
            ex.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static Users getSpesificUser(String userName){
        try {
            Class.forName(DRIVER);
            Connection connection = DriverManager.getConnection(url, username, passowrd);
            Statement statement = connection.createStatement();

            String sqlStatement = "SELECT * FROM users WHERE userName ='" + userName + "'";
            ResultSet resultSet = statement.executeQuery(sqlStatement);
            while(resultSet.next()){
                System.out.println(resultSet.getString(1) + ", " + "####" + ", " + resultSet.getString(3)
                        + ", " + resultSet.getString(4));
            }
        }catch (SQLException ex){
            ex.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static void deleteSpesificUser(String userName){
        try{
           Class.forName(DRIVER);
           Connection connection = DriverManager.getConnection(url, username, passowrd);
           Statement statement = connection.createStatement();

           String sqlStatement = "DELETE FROM users WHERE userName ='" + userName + "'";
           int resultSet = statement.executeUpdate(sqlStatement);

        }catch (SQLException ex){
            ex.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    //PROJECT SQL CALLS
    public static void addProject(Project Project){
        try{
            Class.forName(DRIVER);
            Connection connection = DriverManager.getConnection(url, username, passowrd);
            Statement statement = connection.createStatement();

            String sqlStatement = "INSERT INTO Project VALUES('" + Project.getName() + "','" + Project.getDescription() +
                    "','" + Project.getTimeUsed() + "','" + Project.dbStartDate() +"','" + Project.dbEndDate() + "')";
            statement.executeUpdate(sqlStatement);

        }catch (SQLException ex){
            ex.printStackTrace();
        }catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static void getAllProjects(boolean print){
        if(print){
            System.out.println("PROJECTS:");
        }
        try {
            Class.forName(DRIVER);
            Connection connection = DriverManager.getConnection(url, username, passowrd);
            Statement statement = connection.createStatement();

            String sqlStatement = "SELECT * FROM Project";
            ResultSet resultSet = statement.executeQuery(sqlStatement);
            while(resultSet.next()){
                Project tmp = new Project(resultSet.getString(1), resultSet.getString(1), resultSet.getDouble(3),parseDate(resultSet.getString(4)),parseDate(resultSet.getString(5)));
                if(checkIfProjectInArray(tmp)){
                    PROJECT_LIST.add(tmp);
                }
                if(print){
                    System.out.println(tmp.toString());
                }
            }
        }catch (SQLException ex){
            ex.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static Project getSpesificProject(String projectName){
        try {
            Class.forName(DRIVER);
            Connection connection = DriverManager.getConnection(url, username, passowrd);
            Statement statement = connection.createStatement();

            String sqlStatement = "SELECT * FROM Project WHERE projectName = '" + projectName + "'";
            ResultSet resultSet = statement.executeQuery(sqlStatement);
            while(resultSet.next()){
                System.out.println(resultSet.getString(1) + ", " + resultSet.getString(2) + " " + resultSet.getDouble(3)
                        + ", " + resultSet.getString(4) + ", " + resultSet.getString(5));
            }
        }catch (SQLException ex){
            ex.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return null;
    }
    public static void deleteSpesificProject(String projectName){
        try{
            Class.forName(DRIVER);
            Connection connection = DriverManager.getConnection(url, username, passowrd);
            Statement statement = connection.createStatement();

            String sqlStatement = "DELETE FROM Project WHERE userName ='" + projectName + "'";
            int resultSet = statement.executeUpdate(sqlStatement);
            deleteTimeEntryByProject(projectName);

        }catch (SQLException ex){
            ex.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static void updateTimeInProject(String projectName){
        try{
            Class.forName(DRIVER);
            Connection connection = DriverManager.getConnection(url, username, passowrd);
            Statement statement = connection.createStatement();

            String sqlStatement = "UPDATE Project set timeUsed = (SELECT SUM(timeUsed) FROM TimeEntry WHERE projectName = '" + projectName + "') WHERE projectName = '" + projectName + "'";
            statement.executeUpdate(sqlStatement);
        }catch (SQLException ex){
            ex.printStackTrace();
        }catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static void setEndDate(String projectName, Date endDate){
        String endDateString;
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
            endDateString = year + "-" + monthString + "-" + dayString;
        }else{
            endDateString = "2000-01-01";
        }
        try{
            Class.forName(DRIVER);
            Connection connection = DriverManager.getConnection(url, username, passowrd);
            Statement statement = connection.createStatement();

            String sqlStatement = "UPDATE Project set dateEnded = '" + endDateString + "') WHERE projectName = '" + projectName + "'";
            //System.out.println("The Querry is:" + sqlStatement);
            statement.executeUpdate(sqlStatement);

        }catch (SQLException ex){
            ex.printStackTrace();
        }catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    //TIME ENTRY SQL CALLS
    public static void addTimeEntry(TimeEntry TimeEntry){
        try{
            Class.forName(DRIVER);
            Connection connection = DriverManager.getConnection(url, username, passowrd);
            Statement statement = connection.createStatement();

            String sqlStatement = "INSERT INTO TimeEntry VALUES(" + "0" + ",'" + TimeEntry.getProject().getName() +
                    "'," + TimeEntry.getTimeUsed() + ",'" + TimeEntry.getDescription() +"','" + TimeEntry.dbDateAdded() +"','" + TimeEntry.getUsers().getUserName() + "')";
            statement.executeUpdate(sqlStatement);
            updateTimeInProject(TimeEntry.getProject().getName());

        }catch (SQLException ex){
            ex.printStackTrace();
        }catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static void getAllTimeEntries(boolean print){
        if(print){
            System.out.println("TIMEENTRIES:");
        }
        try {
            Class.forName(DRIVER);
            Connection connection = DriverManager.getConnection(url, username, passowrd);
            Statement statement = connection.createStatement();

            String sqlStatement = "SELECT * FROM TimeEntry";
            ResultSet resultSet = statement.executeQuery(sqlStatement);
            while(resultSet.next()){
                TimeEntry tmp = new TimeEntry(resultSet.getInt(1),findProject(resultSet.getString(2)),
                    resultSet.getDouble(3),resultSet.getString(4),parseDate(resultSet.getString(5)),findUser(resultSet.getString(6)));
                if(checkIfTimeEntryInArray(tmp)){
                    TIME_ENTRY_LIST.add(tmp);
                    tmp.getProject().addToTimeList(tmp);
                    tmp.getProject().addUserToUserList(tmp.getUsers());
                }
                if(print){
                    System.out.println(tmp.toString());
                }
            }
        }catch (SQLException ex){
            ex.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static void getTimeEntryByUser(String userName){
        try {
            Class.forName(DRIVER);
            Connection connection = DriverManager.getConnection(url, username, passowrd);
            Statement statement = connection.createStatement();

            String sqlStatement = "SELECT * FROM TimeEntry WHERE userName ='" + userName + "'";
            //System.out.println(sqlStatement);
            ResultSet resultSet = statement.executeQuery(sqlStatement);
            while(resultSet.next()){
                System.out.println(resultSet.getInt(1) + ", " + resultSet.getString(2) + ", " + resultSet.getDouble(3)
                        + ", " + resultSet.getString(4) + " " + resultSet.getString(5) + ", " + resultSet.getString(6));
            }
        }catch (SQLException ex){
            ex.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static void getTimeEntryByProject(String projectName){
        try {
            Class.forName(DRIVER);
            Connection connection = DriverManager.getConnection(url, username, passowrd);
            Statement statement = connection.createStatement();

            String sqlStatement = "SELECT * FROM TimeEntry WHERE projectName ='" + projectName + "'";
            ResultSet resultSet = statement.executeQuery(sqlStatement);
            while(resultSet.next()){
                System.out.println(resultSet.getInt(1) + ", " + resultSet.getString(2) + ", " + resultSet.getDouble(3)
                        + ", " + resultSet.getString(4) + " " + resultSet.getString(5) + ", " + resultSet.getString(6));
            }
        }catch (SQLException ex){
            ex.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static void deleteTimeEntryByProject(String projectName){
        try{
            Class.forName(DRIVER);
            Connection connection = DriverManager.getConnection(url, username, passowrd);
            Statement statement = connection.createStatement();

            String sqlStatement = "DELETE FROM TimeEntry WHERE userName ='" + projectName + "'";
            int resultSet = statement.executeUpdate(sqlStatement);

        }catch (SQLException ex){
            ex.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    //Check Functions
    public static boolean checkIfUserInArray(Users Users){
        for(int i = 0; i < USERS_LIST.size(); i++){
            if(Users.getUserName().equals(USERS_LIST.get(i).getUserName())){
                return false;
            }
        }
        return true;
    }
    public static boolean checkIfProjectInArray(Project Project){
        for(int i = 0; i < PROJECT_LIST.size(); i++){
            if(Project.getName().equals(PROJECT_LIST.get(i).getName())){
                return false;
            }
        }
        return true;
    }
    public static boolean checkIfTimeEntryInArray(TimeEntry TimeEntry){
        for (int i = 0; i < TIME_ENTRY_LIST.size(); i++){
            if((TimeEntry.getEntryID()) == (TIME_ENTRY_LIST.get(i).getEntryID())){
                return false;
            }
        }
        return true;
    }

    //Useful methods
    public static Project findProject(String projectName){
        for(int i = 0; i < PROJECT_LIST.size(); i++){
            if(projectName.equals(PROJECT_LIST.get(i).getName())){
                return PROJECT_LIST.get(0);
            }
        }
        return null;
    }
    public static java.util.Date parseDate(String dateFormat){
        String[] date = dateFormat.split("-");
        GregorianCalendar calendar = new GregorianCalendar(Integer.parseInt(date[0]),Integer.parseInt(date[1])-1,Integer.parseInt(date[2]),0,0);
        return calendar.getTime();
    }
    public static Users findUser(String userName){
        for(int i = 0; i < USERS_LIST.size(); i++){
            if(userName.equals(USERS_LIST.get(i).getUserName())){
                return USERS_LIST.get(i);
            }
        }
        return null;
    }
    public static boolean userExists(String userName){
        for(int i = 0; i < USERS_LIST.size(); i++){
            if(userName.equals(USERS_LIST.get(i).getUserName())){
                return true;
            }
        }
        return false;
    }

    public static ArrayList<Users> getUsersList() {
        return USERS_LIST;
    }

    public static ArrayList<Project> getProjectList() {
        return PROJECT_LIST;
    }

    public static ArrayList<TimeEntry> getTimeEntryList() {
        return TIME_ENTRY_LIST;
    }
}
