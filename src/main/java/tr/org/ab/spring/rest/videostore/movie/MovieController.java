package tr.org.ab.spring.rest.videostore.movie;

import org.springframework.web.bind.annotation.*;

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

}
