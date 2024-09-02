package ait.homework_31.ait.event.dao;

import ait.homework_31.ait.event.model.Event;

import java.time.LocalDate;

public interface Calendar {
    boolean addEvent(Event event);

    boolean removeEvent(int idEvent);

    boolean updateEvent(int idEvent, String url);

    Event getEventFromCalender(int idEvent);

    Event[] getEventBetweenDate(LocalDate dateFrom, LocalDate dateTo);

    int size();
}
