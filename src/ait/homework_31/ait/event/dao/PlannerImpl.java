package ait.homework_31.ait.event.dao;

import ait.homework_31.ait.event.model.Event;

import java.time.LocalDate;

public class PlannerImpl implements Planner {
    Event[] events;
    int size;

    public PlannerImpl(int capacity) {
        this.events = new Event[capacity];
    }

    @Override
    public boolean addEvent(Event event) {
        return false;
    }

    @Override
    public boolean removeEvent(int idEvent, int idPlanner) {
        return false;
    }

    @Override
    public boolean updateEvent(int idEvent, int idPlanner, String url) {
        return false;
    }

    @Override
    public Event getEventFromPlanner(int idEvent, int idPlanner) {
        return null;
    }

    @Override
    public Event[] getAllEventsFromPlanner(int idPlanner) {
        return new Event[0];
    }

    @Override
    public Event[] getEventBetweenDate(LocalDate dateFrom, LocalDate dateTo) {
        return new Event[0];
    }

    @Override
    public int size() {
        return size;
    }
}
