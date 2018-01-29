package tr.org.ab.spring.rest.videostore.core.error;

import tr.org.ab.spring.rest.videostore.user.User;

/**
 * @author Omer Ozkan
 */
public class ConflictEntity extends RuntimeException {
    public ConflictEntity(Class<User> userClass, String field, String username) {
        super(String.format("%s with %s [%s] has already exist", userClass.getSimpleName(), field, username));
    }
}
