package beans;
import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import sql.MySQLCon;
import static sql.MySQLCon.mclass;
import static sql.MySQLCon.mpassword;
import static sql.MySQLCon.murl;
import static sql.MySQLCon.muser;
import sql.SqlAction;
import src.User;
@ManagedBean(name = "loginBean")
@SessionScoped

public class LoginBean implements Serializable, MySQLCon {
    
    private String password;
    public static String uname;
    
    private User AuthUser = new User("","","","","","","");
    
    public User getAuthUser() {
        return AuthUser;
    }

    public void setAuthUser(User AuthUser) {
        this.AuthUser = AuthUser;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        LoginBean.uname = uname;
    }

    public void AuthentUser(String uname, String pass){
        SqlAction sa = new SqlAction(murl,muser,mpassword,mclass);
        ResultSet rs = sa.executeResult("SELECT * FROM users WHERE uname='"+uname+"'");
        if (rs != null) {
            try {
                while(rs.next()) {
                    this.AuthUser = new User(rs.getString("first_name"), rs.getString("last_name"),
                            rs.getString("email"), rs.getString("uname"), rs.getString("pass"),
                            rs.getString("regdate"), rs.getString("avatar"));
                }
            } 
            catch (SQLException ex) {
                FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_WARN,"Error",ex.toString()));
            }
            finally{sa.close();}
        }
}

    public boolean result(String uname, String pass){
        AuthentUser(uname,pass);
        return (this.AuthUser.getPass().equals(pass));
    }
    
    public String loginProject() {
        FacesContext mess = FacesContext.getCurrentInstance();
        if (result(uname,String.valueOf(password.hashCode()))) {
            mess.addMessage(null,new FacesMessage(FacesMessage.SEVERITY_INFO,"Authorization succesfull.","Good day."));
            return "logindex";
        } 
        else {
            mess.addMessage(null,new FacesMessage(FacesMessage.SEVERITY_WARN,"Incorrect login or password!","Please try again."));
            return "index";
        }
    }

    public String logout() {
        return "index";
    }
}
