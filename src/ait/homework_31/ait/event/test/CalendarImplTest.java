package ait.homework_31.ait.event.test;

import ait.homework_31.ait.event.dao.CalenderImpl;
import ait.homework_31.ait.event.model.Event;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;


class CalendarImplTest {
    Event[] events;
    CalenderImpl calendar;

    @BeforeEach
    void setUp() {
        events = new Event[4];
        calendar = new CalenderImpl(5);
        events[0] = new Event(325, "title4", "url1", LocalDateTime.now().minusDays(2));
        events[1] = new Event(256, "title2", "url2", LocalDateTime.now().minusDays(1));
        events[2] = new Event(124, "title1", "url4", LocalDateTime.now().minusDays(5));
        events[3] = new Event(932, "title3", "url6", LocalDateTime.now().minusDays(8));

        for (Event event : events) {
            calendar.addEvent(event);
        }
    }

    @Test
    void addEvent() {

        assertFalse(calendar.addEvent(null));
        assertFalse(calendar.addEvent(events[1]));
        Event event = new Event(122, "title5", "url9", LocalDateTime.now().minusDays(3));
        assertTrue(calendar.addEvent(event));
        assertEquals(5, calendar.size());
        event = new Event(156, "title9", "url0", LocalDateTime.now().minusDays(6));
        assertFalse(calendar.addEvent(event));

    }

    @Test
    void removeEvent() {
        assertTrue(calendar.removeEvent(325));
        assertFalse(calendar.removeEvent(111));
        assertEquals(3, calendar.size());
    }

    @Test
    void updateEvent() {
        assertTrue(calendar.updateEvent(325, "newUrl"));
        assertEquals("newUrl", calendar.getEventFromCalender(325).getUrl());
    }

    @Test
    void getEventFromCalender() {
        assertEquals(events[0], calendar.getEventFromCalender(325));
    }


    @Test
    void getEventBetweenDate() {
        Arrays.sort(events);
        Event[] expected = {events[1],events[2],events[3]};
        Event[] actual = calendar.getEventBetweenDate(LocalDate.now().minusDays(5),LocalDate.now());
        assertArrayEquals(expected,actual);
     }

    @Test
    void size() {
        assertEquals(4, calendar.size());
    }

}