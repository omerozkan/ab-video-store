package tr.org.ab.spring.rest.videostore.movie;

import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Omer Ozkan
 */
public class MovieFixture {

    private Map<String, Movie> movies = new ConcurrentHashMap<>();

    public MovieFixture() {
        Movie movie1 = new Movie()
                .setId(UUID.randomUUID().toString())
                .setCountries(Collections.singletonList("USA"))
                .setImdbId("tt0338013")
                .setTitle("Eternal Sunshine of the Spotless Mind")
                .setYear(2004)
                .setGenres(Arrays.asList("Drama", "Romance", "Sci-Fi"))
                .setImdbRating(8.3f);

        movies.put(movie1.getId(), movie1);

        Movie movie2 = new Movie()
                .setId(UUID.randomUUID().toString())
                .setCountries(Arrays.asList("USA", "UK"))
                .setImdbId("tt1375666")
                .setTitle("Inception")
                .setYear(2010)
                .setGenres(Arrays.asList("Action", "Adventure", "Sci-Fi"))
                .setImdbRating(8.8f);

        movies.put(movie2.getId(), movie2);
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
}
