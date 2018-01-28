package tr.org.ab.spring.rest.videostore.movie;

import org.springframework.web.bind.annotation.*;

import java.util.Collection;

/**
 * @author Omer Ozkan
 */
@RestController
@RequestMapping("/movies")
public class MovieController {

    private MovieFixture movieFixture = new MovieFixture();

    @GetMapping("/{id}")
    Movie getMovie(@PathVariable("id") String id) {
        return movieFixture.getMovie(id);
    }

    @GetMapping("")
    Collection<Movie> getMovies() {
        return movieFixture.getAllMovies();
    }

}
