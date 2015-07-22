package sql;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SqlAction {
    
    private Connection con = null;
    private PreparedStatement pst = null;
    private ResultSet rs = null;
    private String errorString = "";
    private String url;
    private String user;
    private String password;
    
    public SqlAction(String url, String user, String password, String jdbcClass) {
        this.url = url;
        this.user = user;
        this.password = password;
        try{
            Class.forName(jdbcClass);
        } catch(Exception ex) {errorString = "Driver getting error: "+ex.getMessage();}
    }
    public String getErrorString() {
        return errorString;
    }
    
    public boolean isError() {
        return !errorString.isEmpty();
    }
    
    private boolean connect(){
        try {
            con = DriverManager.getConnection(url,user,password);
            errorString = "";
            return true;
        }catch (Exception ex) {
            errorString = "request finished with error: "+ex.getMessage();
            return false;
        }
    }
    
    private void executeSQL(String sql, boolean resultNeeded){
        if ((!isError())&&(connect())) {
            try{
                pst = con.prepareStatement(sql);
                if (resultNeeded) {
                    rs=pst.executeQuery();
                    errorString = "";
                }
                else {
                    pst.execute();
                    errorString = "";
                    close();
                }
            }catch (Exception ex){
                errorString = "request finished with error: "+ex.getMessage();
                close();
            }
        }
    }

    public ResultSet executeResult(String sql){
        executeSQL(sql,true);
        if (isError()) {return null;} else {return rs; }
    }

    public boolean execute(String sql){
        executeSQL(sql,false);
        return !isError();
    }
    
    public void close(){
        try{
            if (rs!=null) {rs.close(); rs=null;}
            if (pst!=null) {pst.close(); pst=null;}
            if (con!=null) {con.close(); con = null;}
        }catch(Exception e){}
    }
}