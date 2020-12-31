package Domain.Model;

import java.util.Date;

public class Event {
    private String pages;
    private Date localTime;

    public Event(){
    }

    public Event(Date localTime , String pages){
        setPages(pages);
        setLocalTime(localTime);
    }

    //getters and setters
    public Date getLocalTime(){
        return localTime;
    }

    public void setLocalTime(Date localTime){
        this.localTime = localTime;
    }

    public String getPages(){return pages;}

    public void setPages(String pages){
        this.pages =pages;
    }
}
