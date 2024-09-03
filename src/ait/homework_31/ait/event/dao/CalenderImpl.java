package ait.homework_31.ait.event.dao;

import ait.homework_31.ait.event.model.Event;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.function.Predicate;

public class CalenderImpl implements Calendar {
    Event[] events;
    int size;

    public CalenderImpl(int capacity) {
        this.events = new Event[capacity];
    }

    @Override
    public boolean addEvent(Event event) {
        if (event == null || size == events.length || getEventFromCalender(event.getIdEvent()) != null) {
            return false;
        }
        int index = Arrays.binarySearch(events, 0, size, event);
        index = index >= 0 ? index : -index - 1;
        System.arraycopy(events, index, events, index + 1, size - index);
        events[index] = event;
        size++;
        return true;
    }


    @Override
    public boolean removeEvent(int idEvent) {
        for (int i = 0; i < size; i++) {
            if (events[i].getIdEvent() == idEvent) {
                System.arraycopy(events, i + 1, events, i, size - i - 1);
                events[--size] = null;
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean updateEvent(int idEvent, String url) {
        Event event = getEventFromCalender(idEvent);
        if (event == null) {
            return false;
        }
        event.setUrl(url);
        return true;
    }

    @Override
    public Event getEventFromCalender(int idEvent) {
        for (int i = 0; i < size; i++) {
            if (events[i].getIdEvent() == idEvent) {
                return events[i];
            }
        }
        return null;
    }


    @Override
    public Event[] getEventBetweenDate(LocalDate dateFrom, LocalDate dateTo) {
        return findEventByPredicate(p ->
                (p.getDate().toLocalDate().isAfter(dateFrom)
                        || p.getDate().toLocalDate().equals((dateFrom)))
                        && (p.getDate().toLocalDate().isBefore(dateTo)
                        || p.getDate().toLocalDate().equals((dateTo))));
    }

    @Override
    public int size() {
        return size;
    }

    private Event[] findEventByPredicate(Predicate<Event> predicate) {
        Event[] res = new Event[size];
        int j = 0;
        for (int i = 0; i < size; i++) {
            if (predicate.test(events[i])) {
                res[j++] = events[i];
            }
        }
        return Arrays.copyOf(res, j);
    }
}

