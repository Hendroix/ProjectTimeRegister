import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class databaseConnection {
    static final String DRIVER = "com.mysql.jdbc.Driver";
    static final String url = "jdbc:mysql://hupe2.mysql.domeneshop.no/hupe2";
    static final String username = "hupe2";
    static final String passowrd = "";

    public static void addUser(user user){
        try {
            Class.forName(DRIVER);
            Connection connection = DriverManager.getConnection(url, username, passowrd);
            Statement statement = connection.createStatement();

            String sqlStatement = "INSERT INTO users VALUES('" + user.getUserName() + "','" + user.getUserPass() +"','" + user.getFirstName() + "','" + user.getLastName()+ "')";
            System.out.println("The Querry is:" + sqlStatement);
            statement.executeUpdate(sqlStatement);
        }
        catch(SQLException ex){
            ex.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static void addProject(project project){
        try{
            Class.forName(DRIVER);
            Connection connection = DriverManager.getConnection(url, username, passowrd);
            Statement statement = connection.createStatement();

            String sqlStatement = "INSERT INTO project VALUES('" + project.getName() + "','" + project.getDescription() +
                    "','" + project.getTimeUsed() + "','" + project.dbStartDate() +"','" + project.dbEndDate() + "')";
            System.out.println("The Querry is:" + sqlStatement);
            statement.executeUpdate(sqlStatement);

        }catch (SQLException ex){
            ex.printStackTrace();
        }catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static void updateTimeInProject(project project){

    }
    public static void addTimeEntry(timeEntry timeEntry){
        try{
            Class.forName(DRIVER);
            Connection connection = DriverManager.getConnection(url, username, passowrd);
            Statement statement = connection.createStatement();

            String sqlStatement = "INSERT INTO timeEntry VALUES(" + "0" + ",'" + timeEntry.getProject().getName() +
                    "'," + timeEntry.getTimeUsed() + ",'" + timeEntry.getDescription() +"','" + timeEntry.dbDateAdded() +"','" + timeEntry.getUser().getUserName() + "')";
            System.out.println("The Querry is:" + sqlStatement);
            statement.executeUpdate(sqlStatement);

        }catch (SQLException ex){
            ex.printStackTrace();
        }catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
