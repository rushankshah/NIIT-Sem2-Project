//package controller;
public class DetailsClass {
    private String username;
    private String email;
    private String password;
    
    void setUsername(String uname)
    {
           username=uname;
    }
    void setEmail(String email)
    {
           this.email=email;
    }
    void setPassword(String password)
    {
           this.password=password;
    }
    String getUsername()
    {
            return username;
    }
        String getEmail()
    {
            return email;
    }
        String getPassword()
    {
            return password;
    }
}
