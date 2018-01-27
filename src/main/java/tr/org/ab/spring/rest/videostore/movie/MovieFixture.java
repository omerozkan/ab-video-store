package tr.org.ab.spring.rest.videostore.movie;

import java.util.Arrays;
import java.util.Collections;
import java.util.UUID;

/**
 * @author Omer Ozkan
 */
public class MovieFixture {

    public Movie getMovie() {
        return new Movie()
                .setId(UUID.randomUUID())
                .setCountries(Collections.singletonList("USA"))
                .setImdbId("tt0338013")
                .setTitle("Eternal Sunshine of the Spotless Mind")
                .setYear(2004)
                .setGenres(Arrays.asList("Drama", "Romance", "Sci-Fi"));
    }
}
