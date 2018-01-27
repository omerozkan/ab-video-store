package tr.org.ab.spring.rest.videostore.movie;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Omer Ozkan
 */
@RestController
@RequestMapping("/movies")
public class MovieController {

    private MovieFixture movieFixture = new MovieFixture();

    @RequestMapping("/{id}")
    Movie getMovie(@PathVariable("id") String id) {
        return movieFixture.getMovie(id);
    }

}
