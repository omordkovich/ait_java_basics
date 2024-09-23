package ait.movie.tests;

import ait.movie.dao.MoviesCollection;
import ait.movie.dao.MoviesCollectionImpl;
import ait.movie.model.Movie;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MoviesCollectionImplTest {
    MoviesCollection myMovies;
    Movie[] movies;

    @BeforeEach
    void setUp() {
        myMovies = new MoviesCollectionImpl();
        movies = new Movie[5];
        movies[0] = new Movie(1234567, "Inception", "Sci-Fi", "Christopher Nolan", LocalDate.of(2010, 7, 16));
        movies[1] = new Movie(2345678, "The Dark Knight", "Action", "Christopher Nolan", LocalDate.of(2008, 7, 18));
        movies[2] = new Movie(3456789, "Interstellar", "Sci-Fi", "Christopher Nolan", LocalDate.of(2014, 11, 7));
        movies[3] = new Movie(4567890, "The Godfather", "Crime", "Francis Ford Coppola", LocalDate.of(1972, 3, 24));
        movies[4] = new Movie(5678901, "Pulp Fiction", "Crime", "Quentin Tarantino", LocalDate.of(1994, 10, 14));
        for (Movie movie : movies) {
            myMovies.addMovie(movie);
        }
    }

    @Test
    void addMovie() {
        assertFalse(myMovies.addMovie(null));
        assertFalse(myMovies.addMovie(movies[2]));
        Movie newMovie = new Movie(6789012, "The Matrix", "Sci-Fi", "Lana Wachowski, Lilly Wachowski", LocalDate.of(1999, 3, 31));
        assertTrue(myMovies.addMovie(newMovie));
        assertEquals(6, myMovies.totalQuantity());
        Movie newMovie2 = new Movie(6789012, "The Matrix", "Sci-Fi", "Lana Wachowski, Lilly Wachowski", LocalDate.of(1999, 3, 31));
        assertFalse(myMovies.addMovie(newMovie2));
    }

    @Test
    void removeMovie() {
        assertEquals(movies[0],myMovies.removeMovie(1234567));
        assertEquals(4,myMovies.totalQuantity());
        assertNull(myMovies.removeMovie(1234567));
        assertNull(myMovies.removeMovie(2155155));

    }

    @Test
    void findById() {
        assertEquals(movies[2], myMovies.findById(3456789));
        assertNull(myMovies.findById(21251545));
    }

    @Test
    void findByGenre() {
        List<Movie> actual = (ArrayList<Movie>) myMovies.findByGenre("Sci-Fi");
        Movie[] actualArray = listToArray(actual);
        Movie[] expected = {movies[0], movies[2]};
        assertArrayEquals(expected, actualArray);
    }

    @Test
    void findByDirector() {
        List<Movie> actual = (ArrayList<Movie>) myMovies.findByDirector("Christopher Nolan");
        Movie[] actualArray = listToArray(actual);
        Movie[] expected = {movies[0], movies[1], movies[2]};
        assertArrayEquals(expected, actualArray);
    }

    @Test
    void findMoviesCreatedBetweenDates() {
        List<Movie> actual = (ArrayList<Movie>) myMovies.findMoviesCreatedBetweenDates(LocalDate.of(1970, 1, 1), LocalDate.of(2000, 1, 1));
        Movie[] actualArray = listToArray(actual);
        Movie[] expected = {movies[3], movies[4]};
        assertArrayEquals(expected, actualArray);
    }

    @Test
    void totalQuantity() {
        assertEquals(5, myMovies.totalQuantity());
    }

    private Movie[] listToArray(List<Movie> list) {
        int l = list.size();
        Movie[] movies = new Movie[l];
        int i = 0;
        for (Movie m : list) {
            movies[i] = m;
            i++;
        }
        return movies;
    }
}