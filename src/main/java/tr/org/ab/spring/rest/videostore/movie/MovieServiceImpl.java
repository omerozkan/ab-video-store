package tr.org.ab.spring.rest.videostore.movie;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Omer Ozkan
 */
@Component
class MovieServiceImpl implements MovieService {

    private Map<String, Movie> movies = new ConcurrentHashMap<>();

    public MovieServiceImpl() {
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
