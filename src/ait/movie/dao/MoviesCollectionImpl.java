package ait.movie.dao;

import ait.movie.model.Movie;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;

public class MoviesCollectionImpl implements MoviesCollection {

    private final Collection<Movie> movies; //хранение фильмов

    //constructor
    public MoviesCollectionImpl() {
        this.movies = new ArrayList<>();
    }

    public MoviesCollectionImpl(List<Movie> list) {
        this();// вызов предыдущего конструктора
        for (Movie movie : list) {
            addMovie(movie);
        }
    }

    @Override
    public boolean addMovie(Movie movie) {
        if (movie == null || movies.contains(movie)) {
            return false;
        }
        return movies.add(movie);
    }

    @Override
    public Movie removeMovie(long imdb) {
        Movie movie = findById(imdb);
        movies.remove(movie);
        return movie;
    }

    @Override
    public Movie findById(long imdb) {
        for (Movie m : movies) {
            if (m.getImdb() == imdb) {
                return m;
            }
        }
        return null;
    }

    @Override
    public Iterable<Movie> findByGenre(String genre) {
        return findByPredicate(m -> m.getGanre().equals(genre));
    }

    @Override
    public Iterable<Movie> findByDirector(String director) {
        return findByPredicate(m -> m.getDirector().equals(director));
    }

    @Override
    public Iterable<Movie> findMoviesCreatedBetweenDates(LocalDate from, LocalDate to) {
        return findByPredicate(m -> m.getDate().isAfter(from.minusDays(1)) && m.getDate().isBefore(to.plusDays(1)));
    }

    @Override
    public int totalQuantity() {
        return movies.size();
    }

    @Override
    public void printCollection() {
        if (movies.isEmpty()) {
            System.out.println("There is no movies available!");
        } else {
            for (Movie movie : movies) {
                System.out.println(movie);
            }
        }
    }

    private Iterable<Movie> findByPredicate(Predicate<Movie> predicate) {
        List<Movie> found = new ArrayList<>();
        for (Movie m : movies) {
            if (predicate.test(m)) {
                found.add(m);
            }
        }
        return found;
    }

}
