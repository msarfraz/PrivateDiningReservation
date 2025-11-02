package com.reservation.dining.service;
import com.reservation.dining.events.TableCancelledEvent;
import com.reservation.dining.events.TableReservedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class NotificationService {
    @EventListener
    public void handleTableEvent(TableReservedEvent event) {
        System.out.println("Send Email - " + event.getMessage());
    }

    @EventListener
    public void handleTableEvent(TableCancelledEvent event) {
        System.out.println("Send Email - " + event.getMessage());

    }
}
