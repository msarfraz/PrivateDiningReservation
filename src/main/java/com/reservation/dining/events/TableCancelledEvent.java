package com.reservation.dining.events;
import org.springframework.context.ApplicationEvent;

public class TableCancelledEvent extends ApplicationEvent {
    private String message;

    public TableCancelledEvent(Object source, String message) {
        super(source);
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
