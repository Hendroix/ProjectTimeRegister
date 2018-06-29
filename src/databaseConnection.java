import java.sql.*;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.GregorianCalendar;

public class databaseConnection {
    static final String DRIVER = "com.mysql.jdbc.Driver";
    static final String url = "jdbc:mysql://hupe2.mysql.domeneshop.no/hupe2";
    static final String username = "hupe2";
    static final String passowrd = "";

    static final ArrayList<user> userList = new ArrayList<>();
    static final ArrayList<project> projectList = new ArrayList<>();
    static final ArrayList<timeEntry> timeEntryList = new ArrayList<>();

    //USER SQL CALLS
    public static void addUser(user user){
        try {
            Class.forName(DRIVER);
            Connection connection = DriverManager.getConnection(url, username, passowrd);
            Statement statement = connection.createStatement();

            String sqlStatement = "INSERT INTO users VALUES('" + user.getUserName() + "','" + user.getUserPass() +"','" + user.getFirstName() + "','" + user.getLastName()+ "')";
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

            String sqlStatement = "SELECT * FROM users";
            ResultSet resultSet = statement.executeQuery(sqlStatement);
            while(resultSet.next()){
                user tmp = new user(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4));
                if(checkIfUserInArray(tmp)){
                userList.add(tmp);
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
    public static user getSpesificUser(String userName){
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
    public static void addProject(project project){
        try{
            Class.forName(DRIVER);
            Connection connection = DriverManager.getConnection(url, username, passowrd);
            Statement statement = connection.createStatement();

            String sqlStatement = "INSERT INTO project VALUES('" + project.getName() + "','" + project.getDescription() +
                    "','" + project.getTimeUsed() + "','" + project.dbStartDate() +"','" + project.dbEndDate() + "')";
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

            String sqlStatement = "SELECT * FROM project";
            ResultSet resultSet = statement.executeQuery(sqlStatement);
            while(resultSet.next()){
                project tmp = new project(resultSet.getString(1), resultSet.getString(1), resultSet.getDouble(3),parseDate(resultSet.getString(4)),parseDate(resultSet.getString(5)));
                if(checkIfProjectInArray(tmp)){
                    projectList.add(tmp);
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
    public static project getSpesificProject(String projectName){
        try {
            Class.forName(DRIVER);
            Connection connection = DriverManager.getConnection(url, username, passowrd);
            Statement statement = connection.createStatement();

            String sqlStatement = "SELECT * FROM project WHERE projectName = '" + projectName + "'";
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

            String sqlStatement = "DELETE FROM project WHERE userName ='" + projectName + "'";
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

            String sqlStatement = "UPDATE project set timeUsed = (SELECT SUM(timeUsed) FROM timeEntry WHERE projectName = '" + projectName + "') WHERE projectName = '" + projectName + "'";
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

            String sqlStatement = "UPDATE project set dateEnded = '" + endDateString + "') WHERE projectName = '" + projectName + "'";
            //System.out.println("The Querry is:" + sqlStatement);
            statement.executeUpdate(sqlStatement);

        }catch (SQLException ex){
            ex.printStackTrace();
        }catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    //TIME ENTRY SQL CALLS
    public static void addTimeEntry(timeEntry timeEntry){
        try{
            Class.forName(DRIVER);
            Connection connection = DriverManager.getConnection(url, username, passowrd);
            Statement statement = connection.createStatement();

            String sqlStatement = "INSERT INTO timeEntry VALUES(" + "0" + ",'" + timeEntry.getProject().getName() +
                    "'," + timeEntry.getTimeUsed() + ",'" + timeEntry.getDescription() +"','" + timeEntry.dbDateAdded() +"','" + timeEntry.getUser().getUserName() + "')";
            statement.executeUpdate(sqlStatement);
            updateTimeInProject(timeEntry.getProject().getName());

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

            String sqlStatement = "SELECT * FROM timeEntry";
            ResultSet resultSet = statement.executeQuery(sqlStatement);
            while(resultSet.next()){
                timeEntry tmp = new timeEntry(resultSet.getInt(1),findProject(resultSet.getString(2)),
                    resultSet.getDouble(3),resultSet.getString(4),parseDate(resultSet.getString(5)),findUser(resultSet.getString(6)));
                if(checkIfTimeEntryInArray(tmp)){
                    timeEntryList.add(tmp);
                    tmp.getProject().addToTimeList(tmp);
                    tmp.getProject().addUserToUserList(tmp.getUser());
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

            String sqlStatement = "SELECT * FROM timeEntry WHERE userName ='" + userName + "'";
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

            String sqlStatement = "SELECT * FROM timeEntry WHERE projectName ='" + projectName + "'";
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

            String sqlStatement = "DELETE FROM timeEntry WHERE userName ='" + projectName + "'";
            int resultSet = statement.executeUpdate(sqlStatement);

        }catch (SQLException ex){
            ex.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    //Check Functions
    private static boolean checkIfUserInArray(user user){
        for(int i = 0; i < userList.size(); i++){
            if(user.getUserName().equals(userList.get(i).getUserName())){
                return false;
            }
        }
        return true;
    }
    private static boolean checkIfProjectInArray(project project){
        for(int i = 0; i < projectList.size(); i++){
            if(project.getName().equals(projectList.get(i).getName())){
                return false;
            }
        }
        return true;
    }
    private static boolean checkIfTimeEntryInArray(timeEntry timeEntry){
        for (int i = 0; i < timeEntryList.size(); i++){
            if((timeEntry.getEntryID()) == (timeEntryList.get(i).getEntryID())){
                return false;
            }
        }
        return true;
    }

    //Useful methods
    private static project findProject(String projectName){
        for(int i = 0; i < projectList.size(); i++){
            if(projectName.equals(projectList.get(i).getName())){
                return projectList.get(0);
            }
        }
        return null;
    }
    private static java.util.Date parseDate(String dateFormat){
        String[] date = dateFormat.split("-");
        GregorianCalendar calendar = new GregorianCalendar(Integer.parseInt(date[0]),Integer.parseInt(date[1])-1,Integer.parseInt(date[2]),0,0);
        return calendar.getTime();
    }
    private static user findUser(String userName){
        for(int i = 0; i < userList.size(); i++){
            if(userName.equals(userList.get(i).getUserName())){
                return userList.get(i);
            }
        }
        return null;
    }
}
