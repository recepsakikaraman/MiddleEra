package Behavioral.Observer;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class KingdomEvent {

    private String eventType;
    private String message;
    private LocalDateTime timestamp;

    //cobstructor
    public KingdomEvent(String eventType, String message){
        this.eventType=eventType;
        this.message=message;
        this.timestamp=LocalDateTime.now();
    }

    public String getEventType() {
        return eventType;
    }

    public String getMessage() {
        return message;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }
    
    public String getFormattedTime(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        return timestamp.format(formatter);
    }

    @Override
    public String toString(){ 
        return "["+ getFormattedTime() +"]"+
        eventType + ": " +message;
    }
}
