package com.reservation.dining.events;
import org.springframework.context.ApplicationEvent;

public class TableReservedEvent extends ApplicationEvent {
    private String message;

    public TableReservedEvent(Object source, String message) {
        super(source);
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
