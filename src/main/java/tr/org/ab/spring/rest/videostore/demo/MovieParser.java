package tr.org.ab.spring.rest.videostore.demo;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.io.ClassPathResource;
import tr.org.ab.spring.rest.videostore.movie.Movie;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Omer Ozkan
 */
public class MovieParser {
    public static void main(String[] args) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        File file = new ClassPathResource("movies.json").getFile();
        List<Map> listOfRawMovies = mapper.readValue(file, List.class);
        List<Movie> listOfMovies = new ArrayList<>();
        for (Map rawMovie : listOfRawMovies) {
            Movie movie = new Movie()
                    .setId(UUID.randomUUID().toString())
                    .setCountries(Arrays.stream(rawMovie.get("Country").toString().split(",")).map(String::trim).collect(Collectors.toList()))
                    .setGenres(Arrays.stream(rawMovie.get("Genre").toString().split(",")).map(String::trim).collect(Collectors.toList()))
                    .setImdbId(rawMovie.get("imdbID").toString())
                    .setYear(Integer.valueOf(rawMovie.get("Year").toString()))
                    .setTitle(rawMovie.get("Title").toString())
                    .setImdbRating(Float.valueOf(rawMovie.get("imdbRating").toString()));
            listOfMovies.add(movie);
        }

        mapper.writeValue(new ClassPathResource("parsed.json").getFile(), listOfMovies);
    }
}
