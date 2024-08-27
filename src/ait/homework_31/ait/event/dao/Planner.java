package ait.homework_31.ait.event.dao;

import ait.homework_31.ait.event.model.Event;

import java.time.LocalDate;

public interface Planner {
    boolean addEvent(Event event);

    boolean removeEvent(int idEvent, int idPlanner);

    boolean updateEvent(int idEvent, int idPlanner, String url);

    Event getEventFromPlanner(int idEvent, int idPlanner);

    Event[] getAllEventsFromPlanner(int idPlanner);

    Event[] getEventBetweenDate(LocalDate dateFrom, LocalDate dateTo);

    int size();
}
