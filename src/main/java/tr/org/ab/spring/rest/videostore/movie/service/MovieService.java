package tr.org.ab.spring.rest.videostore.movie.service;

import tr.org.ab.spring.rest.videostore.movie.Movie;

import java.util.Collection;

/**
 * @author Omer Ozkan
 */
public interface MovieService {
    Movie getMovie(String uuid);

    Movie addMovie(Movie movie);

    void updateMovie(String id, Movie movie);

    void deleteMovie(String id);

    Collection<Movie> getAllMovies();
}
