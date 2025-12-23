package com.sarat.string;

import java.util.Date;

public final class ImmutableEvent {

    private final String name;
    private final Date eventDate;

    public ImmutableEvent(String name, Date eventDate) {
        this.name = name;
        // Defensive copy on input
        this.eventDate = new Date(eventDate.getTime());
//        this.eventDate = eventDate; // not immutable
    }

    public String getName() {
        return name;
    }

    public Date getEventDate() {
        // Defensive copy on output
        return new Date(eventDate.getTime());
    }

    @Override
    public String toString() {
        return "ImmutableEvent{" +
                "name='" + name + '\'' +
                ", eventDate=" + eventDate +
                '}';
    }
    
    public static void main(String[] args) {
        Date date = new Date();
        ImmutableEvent event = new ImmutableEvent("Conference", date);

        System.out.println(event);

        // Try to modify original date object
        date.setTime(date.getTime() + 1000000000L);

        // The event's date remains unchanged
        System.out.println(event);

        // Try to modify returned Date object
        Date eventDate = event.getEventDate();
        eventDate.setTime(eventDate.getTime() + 2000000000L);

        // The event's date still remains unchanged
        System.out.println(event);
    }
}

