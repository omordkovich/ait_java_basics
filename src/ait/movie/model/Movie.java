package ait.movie.model;

import java.time.LocalDate;
import java.util.Objects;

public class Movie {
    private long imdb;
    private String title;
    private String ganre;
    private String director;
    private LocalDate date;

    public Movie(long imdb, String title, String ganre, String director, LocalDate date) {
        this.imdb = imdb;
        this.title = title;
        this.ganre = ganre;
        this.director = director;
        this.date = date;
    }

    public void setGanre(String ganre) {
        this.ganre = ganre;
    }

    public long getImdb() {
        return imdb;
    }

    public String getTitle() {
        return title;
    }

    public String getGanre() {
        return ganre;
    }

    public String getDirector() {
        return director;
    }

    public LocalDate getDate() {
        return date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Movie movie)) return false;
        return imdb == movie.imdb;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(imdb);
    }

    @Override
    public String toString() {
        return String.format("IMDB: %d, Title: %s, genre: %s, director: %s, date: %s", imdb, title, ganre, director, date);
    }
}
