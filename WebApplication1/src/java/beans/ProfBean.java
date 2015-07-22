package beans;
import sql.SqlAction;
import sql.MySQLCon;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import static sql.MySQLCon.mclass;
import static sql.MySQLCon.mpassword;
import static sql.MySQLCon.murl;
import static sql.MySQLCon.muser;
@ManagedBean(name = "profBean")
@ViewScoped

public class ProfBean implements Serializable, MySQLCon {
    
    private String new_first;
    private String new_last;
    private String new_email;
    private String new_uname;
    private String pass;
    private String new_av;
    
    public void update() {
        SqlAction sa = new SqlAction(murl,muser,mpassword,mclass);
        if (!new_first.trim().equals("")) sa.execute("UPDATE users SET first_name = '"+new_first+"' WHERE uname= '"+LoginBean.uname+"'");
        sa.close();
        if (!new_last.trim().equals("")) sa.execute("UPDATE users SET last_name = '"+new_last+"' WHERE uname= '"+LoginBean.uname+"'");
        sa.close();
        if (!new_email.trim().equals("")) sa.execute("UPDATE users SET email = '"+new_email+"' WHERE uname= '"+LoginBean.uname+"'");
        sa.close();
        if (!new_av.trim().equals("")) sa.execute("UPDATE users SET avatar = '"+new_av+"' WHERE uname = '"+LoginBean.uname+"'");
        sa.close();
    }

    public String getNew_first() {
        return new_first;
    }

    public void setNew_first(String new_first) {
        this.new_first = new_first;
    }

    public String getNew_last() {
        return new_last;
    }

    public void setNew_last(String new_last) {
        this.new_last = new_last;
    }

    public String getNew_email() {
        return new_email;
    }
    
    public void setNew_email(String new_email) {
        this.new_email = new_email;
    }

    public String getNew_uname() {
        return new_uname;
    }

    public void setNew_uname(String new_uname) {
        this.new_uname = new_uname;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getNew_av() {
        return new_av;
    }

    public void setNew_av(String new_av) {
        this.new_av = new_av;
    }
}
