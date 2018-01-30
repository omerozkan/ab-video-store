package tr.org.ab.spring.rest.videostore.authorization;

import tr.org.ab.spring.rest.videostore.user.User;

import java.util.UUID;

/**
 * @author Omer Ozkan
 */
public class AuthenticatedUser {
    private User user;
    private String requestId = UUID.randomUUID().toString();

    public User getUser() {
        return user;
    }

    public AuthenticatedUser setUser(User user) {
        this.user = user;
        return this;
    }

    public String getRequestId() {
        return requestId;
    }
}
