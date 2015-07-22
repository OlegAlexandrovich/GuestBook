package beans;
import sql.SqlAction;
import sql.MySQLCon;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
@ManagedBean(name = "registrationBean")
@ViewScoped

public class RegistrationBean implements Serializable, MySQLCon {
    
    private String first_name;
    private String last_name;
    private String email;
    private String uname;
    private String pass;
    private String avatar="images/avatarDefault.png";
    
    public String insert() {
        SqlAction sa = new SqlAction(murl,muser,mpassword,mclass);
        FacesContext mess = FacesContext.getCurrentInstance();
        if (uname.trim().equals("") || pass.trim().equals("") || email.trim().equals("")){
            mess.addMessage(null,new FacesMessage(FacesMessage.SEVERITY_WARN,"Warning!","fields marked with '*' are necessary to fill in."));
            return "registration";
        }
        else{
            sa.execute("insert into users(first_name, last_name, email, uname, pass, regdate, avatar) values ('" + first_name + "','" + last_name + "','" + email + "','" + uname + "','" + pass.hashCode() + "', CURDATE(),'"+avatar+"');");
            if (sa.getErrorString().equals("")){
                mess.addMessage(null,new FacesMessage(FacesMessage.SEVERITY_INFO,"Registration succesfully completed.","You can login."));
                return "index";
            }
            else if(sa.getErrorString().equals("request finished with error: Duplicate entry '"+uname+"' for key 'uname'")){
                mess.addMessage(null,new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error!","User with such login already exist."));
                return "registration";
            }
            else{
                mess.addMessage(null,new FacesMessage(FacesMessage.SEVERITY_WARN,"Error!",sa.getErrorString()));
                return "registration";
            }
        }
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

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
}
