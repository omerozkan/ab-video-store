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
        Movie movie = new Movie()
//                .setId(UUID.randomUUID().toString())
                .setId("id")
                .setCountries(Collections.singletonList("USA"))
                .setImdbId("tt0338013")
                .setTitle("Eternal Sunshine of the Spotless Mind")
                .setYear(2004)
                .setGenres(Arrays.asList("Drama", "Romance", "Sci-Fi"))
                .setImdbRating(8.3f);
        movies.put(movie.getId(), movie);
    }

    public Movie getMovie(String uuid) {
        return movies.get(uuid);
    }
}
