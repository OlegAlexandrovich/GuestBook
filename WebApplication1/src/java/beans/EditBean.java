package beans;
import sql.SqlAction;
import sql.MySQLCon;
import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import static sql.MySQLCon.mclass;
import static sql.MySQLCon.mpassword;
import static sql.MySQLCon.murl;
import static sql.MySQLCon.muser;
import sql.SqlAction;
import java.text.SimpleDateFormat;
import java.util.Date;
import src.User;
@ManagedBean(name = "editBean")
@ViewScoped

public class EditBean implements Serializable, MySQLCon {
    
    private String mess_content;
    private String mess_title;
    
    public void insert_mess() {
        SqlAction sa = new SqlAction(murl,muser,mpassword,mclass);
        String author_name = LoginBean.uname;
        String author_av = "";
        String author_date = "";
        ResultSet rs = sa.executeResult("SELECT * FROM users WHERE uname='"+author_name+"'");
        if (rs != null) {
            try {
                while(rs.next()) {
                    author_av = rs.getString("avatar");
                    author_date = rs.getString("regdate");
                }
                sa.execute("insert into messages(content, mess_date, author_name, author_av, author_date, mess_title) values ('" + mess_content + "','Added "+String.valueOf((new SimpleDateFormat("dd.MM.yyyy 'in' HH:mm:ss")).format(new Date()))+"','" + author_name + "','" + author_av + "','" + author_date+"','" + mess_title+"');");
            } catch (SQLException ex) {}
            finally{sa.close();}
        }
    }
    
    public String getMess_content() {
        return mess_content;
    }

    public void setMess_content(String mess_content) {
        this.mess_content = mess_content;
    }

    public String getMess_title() {
        return mess_title;
    }

    public void setMess_title(String mess_title) {
        this.mess_title = mess_title;
    }
}
