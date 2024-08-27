package ait.homework_31.ait.event.model;

import java.time.LocalDateTime;
import java.util.Objects;

public class Event {
    private int idEvent;
    private int idPlanner;
    private String title;
    private String url;
    private LocalDateTime date;

    public Event(int idEvent, int idPlanner, String title, String url, LocalDateTime date) {
        this.idEvent = idEvent;
        this.idPlanner = idPlanner;
        this.title = title;
        this.url = url;
        this.date = date;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof Event event)) return false;
        return idEvent == event.idEvent && idPlanner == event.idPlanner;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idEvent, idPlanner);
    }

    public int getIdEvent() {
        return idEvent;
    }

    public int getIdPlanner() {
        return idPlanner;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }


    public String getTitle() {
        return title;
    }

    public String getUrl() {
        return url;
    }

    public LocalDateTime getDate() {
        return date;
    }

    @Override
    public String toString() {
        return String.format("Title: %s, Event ID: %d, Planner ID: %d URL: %s, Date: %s", title, idEvent, idPlanner, url, date);
    }
}
