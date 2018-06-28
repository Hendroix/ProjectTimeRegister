public class user {
    private String userName;
    private String userPass;
    private String firstName;
    private String lastName;

    public user(String userName, String userPass, String firstName, String lastName) {
        this.userName = userName;
        this.userPass = userPass;
        this.firstName = firstName;
        this.lastName = lastName;
        databaseConnection.addUser(this);
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPass() {
        return userPass;
    }

    private void setUserPass(String userPass) {
        this.userPass = userPass;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public boolean checkPassword(String psw){
        if(psw == userPass){
            return true;
        }else{
            return false;
        }
    }
}
