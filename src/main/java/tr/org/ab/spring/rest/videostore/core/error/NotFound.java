package tr.org.ab.spring.rest.videostore.core.error;

/**
 * @author Omer Ozkan
 */
public class NotFound extends RuntimeException {

    public NotFound(String message) {
        super(message);
    }
}
