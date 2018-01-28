package tr.org.ab.spring.rest.videostore.movie;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Omer Ozkan
 */
public class MovieFixture {

    private Map<String, Movie> movies = new ConcurrentHashMap<>();

    public MovieFixture() {
        ObjectMapper mapper = new ObjectMapper();
        List<Movie> list = null;
        try {
            CollectionType reference = mapper.getTypeFactory().constructCollectionType(List.class, Movie.class);
            list = mapper.readValue(new ClassPathResource("movies.json").getFile(), reference);
        } catch (IOException e) {
           throw new RuntimeException(e);
        }
        for (Movie movie : list) {
            movies.put(movie.getId(), movie);
        }
    }

    public Movie getMovie(String uuid) {
        return movies.get(uuid);
    }

    public void addMovie(Movie movie) {
        movie.setId(UUID.randomUUID().toString());
        movies.put(movie.getId(), movie);
    }

    public void updateMovie(String id, Movie movie) {
        movies.put(id, movie);
    }

    public void deleteMovie(String id) {
        movies.remove(id);
    }

    public Collection<Movie> getAllMovies() {
        return movies.values();
    }
}
