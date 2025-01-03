package Models;

public class LoginData {
    private String username;
    private String password;

    //Constructor
    public LoginData(String username,String password){
        this.username = username;
        this.password = password;

    }
    //Getters
    public  String getUsername()
    {
        return username;
    }
    public  String getPassword()
    {
        return password;
    }
}
