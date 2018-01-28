package tr.org.ab.spring.rest.videostore.movie;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import tr.org.ab.spring.rest.videostore.core.SimpleResponse;
import tr.org.ab.spring.rest.videostore.core.error.NotFound;

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
        Movie movie = movieFixture.getMovie(id);

        if (movie == null) {
            throw new NotFound("Movie with id " + id + " not found");
        }

        return movie;
    }

    @GetMapping
    Collection<Movie> getMovies() {
        return movieFixture.getAllMovies();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    Movie createMovie(@RequestBody Movie movie) {
        return movieFixture.addMovie(movie);
    }

    @DeleteMapping("/{id}")
    void deleteMovie(@PathVariable("id") String id) {
        movieFixture.deleteMovie(id);
    }

    @PutMapping("/{id}")
    SimpleResponse updateMovie(@RequestBody Movie updated, @PathVariable("id") String id) {
        movieFixture.updateMovie(id, updated);
        return new SimpleResponse("updated");
    }

}
