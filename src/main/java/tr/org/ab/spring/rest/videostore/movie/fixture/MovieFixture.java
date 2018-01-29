package tr.org.ab.spring.rest.videostore.movie.fixture;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import tr.org.ab.spring.rest.videostore.movie.Movie;
import tr.org.ab.spring.rest.videostore.movie.service.MovieService;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.List;

/**
 * @author Omer Ozkan
 */
@Component
class MovieFixture {

    @Autowired
    private MovieService movieService;

    @PostConstruct
    public void addTestData() {
        ObjectMapper mapper = new ObjectMapper();
        List<Movie> movieList;
        try {
            CollectionType reference = mapper.getTypeFactory().constructCollectionType(List.class, Movie.class);
            movieList = mapper.readValue(new ClassPathResource("movies.json").getFile(), reference);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        for (Movie movie : movieList) {
            movieService.addMovie(movie);
        }
    }
}
