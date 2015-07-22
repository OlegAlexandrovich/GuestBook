package beans;
import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import sql.MySQLCon;
import static sql.MySQLCon.*;
import sql.SqlAction;
import src.Message;
@ManagedBean
@RequestScoped

public class GridBean implements Serializable, MySQLCon {
    
    private SqlAction sa;
    private List<Message> messages;
    
    public GridBean() {
        sa = new SqlAction(murl,muser,mpassword,mclass);
        addMessages();
    }

    public void addMessages() {
        messages = new ArrayList<Message>();
        ResultSet rs = sa.executeResult("SELECT * FROM messages");
        if (rs != null) {
            try {
                while(rs.next()) {
                    messages.add(new Message(rs.getString("content"), rs.getString("mess_date"),
                    rs.getString("author_name"), rs.getString("author_av"), rs.getString("author_date"), 
                    rs.getString("mess_title")));
                }
            } 
            catch (SQLException ex) {}
            finally{sa.close();}
        }
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }
}
