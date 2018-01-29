package tr.org.ab.spring.rest.videostore.user.service;

import tr.org.ab.spring.rest.videostore.user.User;

import java.util.Collection;

/**
 * @author Omer Ozkan
 */
public interface UserService {
    User get(String id);

    User add(User user);

    void delete(String userId);

    void update(String userId, User user);

    Collection<User> getAll();

    User getByUsername(String username);
}
