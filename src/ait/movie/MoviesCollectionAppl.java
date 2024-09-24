package ait.movie;

import ait.movie.dao.MoviesCollection;
import ait.movie.dao.MoviesCollectionImpl;
import ait.movie.model.Movie;

import java.time.LocalDate;

public class MoviesCollectionAppl {
    public static void main(String[] args) {
        MoviesCollection myMovies = new MoviesCollectionImpl();
        Movie[] movies = new Movie[5];
        movies[0] = new Movie(1234567, "Inception", "Sci-Fi", "Christopher Nolan", LocalDate.of(2010, 7, 16));
        movies[1] = new Movie(2345678, "The Dark Knight", "Action", "Christopher Nolan", LocalDate.of(2008, 7, 18));
        movies[2] = new Movie(3456789, "Interstellar", "Sci-Fi", "Christopher Nolan", LocalDate.of(2014, 11, 7));
        movies[3] = new Movie(4567890, "The Godfather", "Crime", "Francis Ford Coppola", LocalDate.of(1972, 3, 24));
        movies[4] = new Movie(5678901, "Pulp Fiction", "Crime", "Quentin Tarantino", LocalDate.of(1994, 10, 14));
        System.out.println("----------------------------My movies collection----------------------");

        for (Movie movie : movies) {
            myMovies.addMovie(movie);
        }
        myMovies.printCollection();
        Iterable<Movie> lastMovies = myMovies.findMoviesCreatedBetweenDates(LocalDate.of(2010, 1, 1).minusDays(1), LocalDate.now());
        System.out.println("----------------------------Movies released since 2010----------------------");
        for (Movie movie : lastMovies) {
            System.out.println(movie);
        }
    }
}
