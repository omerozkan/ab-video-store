package tr.org.ab.spring.rest.videostore.core;

/**
 * @author Omer Ozkan
 */
public class SimpleResponse {

    private String message;

    public SimpleResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public SimpleResponse setMessage(String message) {
        this.message = message;
        return this;
    }
}
