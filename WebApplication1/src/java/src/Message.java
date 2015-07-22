package src;

public class Message {
    
    private String content;
    private String mess_date;
    private String author_name;
    private String author_av;
    private String author_date;
    private String mess_title;
    
    public Message(String content, String mess_date, String author_name, String author_av, String author_date, String mess_title) {
        this.content = content;
        this.mess_date = mess_date;
        this.author_name = author_name;
        this.author_av = author_av;
        this.author_date = author_date;
        this.mess_title = mess_title;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public String getMess_date() {
        return mess_date;
    }
    public void setMess_date(String mess_date) {
        this.mess_date = mess_date;
    }
    public String getAuthor_name() {
        return author_name;
    }
    public void setAuthor_name(String author_name) {
        this.author_name = author_name;
    }
    public String getAuthor_av() {
        return author_av;
    }
    public void setAuthor_av(String author_av) {
        this.author_av = author_av;
    }
    public String getAuthor_date() {
        return author_date;
    }
    public void setAuthor_date(String author_date) {
        this.author_date = author_date;
    }
    public String getMess_title() {
        return mess_title;
    }
    public void setMess_title(String mess_title) {
        this.mess_title = mess_title;
    }
}
