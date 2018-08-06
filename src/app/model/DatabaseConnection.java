package app.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;

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
            USERS_LIST.add(Users);
            statement.executeUpdate(sqlStatement);
        }
        catch(SQLException ex){
            ex.printStackTrace();
            System.out.println("You are not connected to the internet");
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
            System.out.println("You are not connected to the internet");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static void updateUser(String originalUserName, String newUserName, String newFirstName, String newLastName, String newPassword){
        try {
            Class.forName(DRIVER);
            Connection connection = DriverManager.getConnection(url, username, passowrd);
            Statement statement = connection.createStatement();

            String sqlStatement = "UPDATE Users SET userName ='" + newUserName + "', userPass ='" + newPassword + "', firstName ='" + newFirstName + "', lastName ='" + newLastName + "' WHERE userName = '" + originalUserName + "'";
            statement.executeUpdate(sqlStatement);
            USERS_LIST.remove(findUser(originalUserName));
            USERS_LIST.add(new Users(newUserName, newPassword, newFirstName, newLastName));
        }catch (SQLException ex){
            ex.printStackTrace();
            System.out.println("You are not connected to the internet");
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
    }
    public static void deleteSpesificUser(String userName){
        try{
           Class.forName(DRIVER);
           Connection connection = DriverManager.getConnection(url, username, passowrd);
           Statement statement = connection.createStatement();

           String sqlStatement = "DELETE FROM Users WHERE userName ='" + userName + "'";
           int resultSet = statement.executeUpdate(sqlStatement);
           USERS_LIST.remove(findUser(userName));

        }catch (SQLException ex){
            ex.printStackTrace();
            System.out.println("You are not connected to the internet");
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
                    "','" + Project.getTimeUsed() + "','" + Project.getStartDate() +"','" + Project.getEndDate() + "')";
            statement.executeUpdate(sqlStatement);
            PROJECT_LIST.add(Project);

        }catch (SQLException ex){
            ex.printStackTrace();
            System.out.println("You are not connected to the internet");
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
                Project tmp = new Project(resultSet.getString(1), resultSet.getString(2), resultSet.getDouble(3),(resultSet.getString(4)),(resultSet.getString(5)));
                if(checkIfProjectInArray(tmp)){
                    PROJECT_LIST.add(tmp);
                }
                if(print){
                    System.out.println(tmp.toString());
                }
            }
        }catch (SQLException ex){
            ex.printStackTrace();
            System.out.println("You are not connected to the internet");
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
                Project tmp = new Project(resultSet.getString(1), resultSet.getString(2), resultSet.getDouble(3),(resultSet.getString(4)),(resultSet.getString(5)));
                return tmp;
            }
        }catch (SQLException ex){
            ex.printStackTrace();
            System.out.println("You are not connected to the internet");
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

            String sqlStatement = "DELETE FROM Project WHERE projectName ='" + projectName + "'";
            int resultSet = statement.executeUpdate(sqlStatement);
            PROJECT_LIST.remove(findProject(projectName));

        }catch (SQLException ex){
            ex.printStackTrace();
            System.out.println("You are not connected to the internet");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static void updateProject(Project project, String oldProjectName){
        try {
            Class.forName(DRIVER);
            Connection connection = DriverManager.getConnection(url, username, passowrd);
            Statement statement = connection.createStatement();

            String sqlStatement = "UPDATE Project SET projectName ='" + project.getName() + "', projectDescription ='" + project.getDescription() +
                    "', timeUsed ='" + project.getTimeUsed() + "', dateStarted ='" + project.getStartDate() + "', dateEnded ='" + project.getEndDate() +"' WHERE projectName = '" + oldProjectName + "'";
            statement.executeUpdate(sqlStatement);
            PROJECT_LIST.remove(findProject(oldProjectName));
            PROJECT_LIST.add(project);
        }catch (SQLException ex){
            ex.printStackTrace();
            System.out.println("You are not connected to the internet");
        }catch (ClassNotFoundException e){
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
            updateProjectTimeUsedSum(projectName);
        }catch (SQLException ex){
            ex.printStackTrace();
            System.out.println("You are not connected to the internet");
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
                    "'," + TimeEntry.getTimeUsed() + ",'" + TimeEntry.getDescription() +"','" + TimeEntry.getDateAdded() +"','" + TimeEntry.getUsers().getUserName() + "')";
            statement.executeUpdate(sqlStatement);
            updateTimeInProject(TimeEntry.getProject().getName());
        }catch (SQLException ex){
            ex.printStackTrace();
            System.out.println("You are not connected to the internet");
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
                    resultSet.getDouble(3),resultSet.getString(4),(resultSet.getString(5)),findUser(resultSet.getString(6)));
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
            System.out.println("You are not connected to the internet");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static ArrayList<TimeEntry> getTimeEntryByProject(String projectName){
        ArrayList<TimeEntry> timeEntries = new ArrayList<>();
        try {
            Class.forName(DRIVER);
            Connection connection = DriverManager.getConnection(url, username, passowrd);
            Statement statement = connection.createStatement();

            String sqlStatement = "SELECT * FROM TimeEntry WHERE projectName ='" + projectName + "'";
            ResultSet resultSet = statement.executeQuery(sqlStatement);
            while(resultSet.next()){
                timeEntries.add(new TimeEntry(resultSet.getInt(1), findProject(resultSet.getString(2)), resultSet.getDouble(3), resultSet.getString(4),
                        resultSet.getString(5), findUser(resultSet.getString(6))));
            }
            return timeEntries;
        }catch (SQLException ex){
            ex.printStackTrace();
            System.out.println("You are not connected to the internet");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return timeEntries;
    }
    public static void updateTimeEntry(TimeEntry timeEntry){
        try {
        Class.forName(DRIVER);
        Connection connection = DriverManager.getConnection(url, username, passowrd);
        Statement statement = connection.createStatement();

        String sqlStatement = "UPDATE TimeEntry SET projectName ='" + timeEntry.getProject().getName()+ "', timeUsed ='" + timeEntry.getTimeUsed() +
                "', description ='" + timeEntry.getDescription() + "', dateAdded ='" + timeEntry.getDateAdded() + "', userName ='" + timeEntry.getUsers().getUserName() +"' WHERE entryID = '" + timeEntry.getEntryID() + "'";
        statement.executeUpdate(sqlStatement);
        TIME_ENTRY_LIST.remove(findTimeEntry(timeEntry.getEntryID()));
        TIME_ENTRY_LIST.add(timeEntry);
    }catch (SQLException ex){
        ex.printStackTrace();
        System.out.println("You are not connected to the internet");
    }catch (ClassNotFoundException e){
        e.printStackTrace();
    }
    }
    public static void deleteTimeEntry(int entryID){
        try{
            Class.forName(DRIVER);
            Connection connection = DriverManager.getConnection(url, username, passowrd);
            Statement statement = connection.createStatement();

            String sqlStatement = "DELETE FROM TimeEntry WHERE entryID ='" + entryID + "'";
            int resultSet = statement.executeUpdate(sqlStatement);
            TIME_ENTRY_LIST.remove(findTimeEntry(entryID));

        }catch (SQLException ex){
            ex.printStackTrace();
            System.out.println("You are not connected to the internet");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static void deleteTimeEntryByProject(String projectName){
        try{
            Class.forName(DRIVER);
            Connection connection = DriverManager.getConnection(url, username, passowrd);
            Statement statement = connection.createStatement();

            String sqlStatement = "DELETE FROM TimeEntry WHERE projectName ='" + projectName + "'";
            int resultSet = statement.executeUpdate(sqlStatement);
            removeTimeEntrieFromListByProject(projectName);
            deleteSpesificProject(projectName);

        }catch (SQLException ex){
            ex.printStackTrace();
            System.out.println("You are not connected to the internet");
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
        for (Project p: PROJECT_LIST
             ) {
            if(projectName.equals(p.getName())){
                return p;
            }
        }
        return null;
    }
    public static Users findUser(String userName){
        for (Users u: USERS_LIST
             ) {
            if(userName.equals(u.getUserName())){
                return u;
            }
        }
        return null;
    }
    public static TimeEntry findTimeEntry(int entryID){
        for (TimeEntry te: TIME_ENTRY_LIST
             ) {
            if(entryID == te.getEntryID()){
                return te;
            }
        }
        return null;
    }

    public static boolean projectExists(String projectName){
        for(int i = 0; i < PROJECT_LIST.size(); i++){
            if(projectName.equals(PROJECT_LIST.get(i).getName())){
                return true;
            }
        }
        return false;
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

    public static void gatherInfoFromDatabase(boolean print){
        getAllProjects(print);
        getAllUsers(print);
        getAllTimeEntries(print);
    }

    private static void removeTimeEntrieFromListByProject(String projectName){
        Iterator<TimeEntry> iter = TIME_ENTRY_LIST.iterator();

        while (iter.hasNext()) {
            TimeEntry checkTimeEntry = iter.next();

            if(checkTimeEntry.getProject().getName().equals(projectName)){
                iter.remove();
            }
        }
    }

    private static void updateProjectTimeUsedSum(String projectName){
        Project replaceAbleProject = getSpesificProject(projectName);
        PROJECT_LIST.add(replaceAbleProject);
        PROJECT_LIST.remove(findProject(projectName));
    }
}
