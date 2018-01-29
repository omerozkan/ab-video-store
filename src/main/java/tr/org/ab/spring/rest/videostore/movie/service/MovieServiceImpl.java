package tr.org.ab.spring.rest.videostore.movie.service;

import org.springframework.stereotype.Service;
import tr.org.ab.spring.rest.videostore.movie.Movie;

import java.util.Collection;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Omer Ozkan
 */
@Service
class MovieServiceImpl implements MovieService {

    private Map<String, Movie> movies = new ConcurrentHashMap<>();

    @Override
    public Movie getMovie(String uuid) {
        return movies.get(uuid);
    }

    @Override
    public Movie addMovie(Movie movie) {
        movie.setId(UUID.randomUUID().toString());
        movies.put(movie.getId(), movie);
        return movie;
    }

    @Override
    public void updateMovie(String id, Movie movie) {
        movies.remove(id);
        movie.setId(id);
        movies.put(id, movie);
    }

    @Override
    public void deleteMovie(String id) {
        movies.remove(id);
    }

    @Override
    public Collection<Movie> getAllMovies() {
        return movies.values();
    }
}
