package src;
import java.io.Serializable;

public class User implements Serializable{
    
    private String first_name;
    private String last_name;
    private String email;
    private String uname;
    private String pass;
    private String regdate;
    private String avatar;
    
    public User(String first_name, String last_name, String email, String uname, String pass, String regdate, String avatar) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.uname = uname;
        this.pass = pass;
        this.regdate = regdate;
        this.avatar = avatar;
    }
    public String getFirst_name() {
        return first_name;
    }
    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }
    public String getLast_name() {
        return last_name;
    }
    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getUname() {
        return uname;
    }
    public void setUname(String uname) {
        this.uname = uname;
    }
    public String getPass() {
        return pass;
    }
    public void setPass(String pass) {
        this.pass = pass;
    }
    public String getRegdate() {
        return regdate;
    }
    public void setRegdate(String regdate) {
        this.regdate = regdate;
    }
    public String getAvatar() {
        return avatar;
    }
    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
}
