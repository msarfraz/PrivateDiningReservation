package com.reservation.dining.config;
import com.reservation.dining.events.TableCancelledEvent;
import com.reservation.dining.events.TableReservedEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
public class TableEventPublisher {
    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    public void publishTableReservedEvent(final String message) {
        System.out.println("Publishing table reserved event. ");
        TableReservedEvent tableReservedEvent = new TableReservedEvent(this, message);
        applicationEventPublisher.publishEvent(tableReservedEvent);
    }
    public void publishTableCancelledEvent(final String message) {
        System.out.println("Publishing table cancelled event. ");
        TableCancelledEvent tableCancelledEvent = new TableCancelledEvent(this, message);
        applicationEventPublisher.publishEvent(tableCancelledEvent);
    }
}
