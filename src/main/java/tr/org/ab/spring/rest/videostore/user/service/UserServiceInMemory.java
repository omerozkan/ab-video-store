package tr.org.ab.spring.rest.videostore.user.service;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;
import tr.org.ab.spring.rest.videostore.user.User;

import java.util.Collection;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Omer Ozkan
 */
class UserServiceInMemory implements UserService {

    private Map<String, User> usersById = new ConcurrentHashMap<>();
    private Map<String, User> usersByUsername = new ConcurrentHashMap<>();

    @Override
    public User get(String id) {
        return usersById.get(id);
    }

    @Override
    public User add(User user) {
        user.setId(UUID.randomUUID().toString());
        usersById.put(user.getId(), user);
        usersByUsername.put(user.getUsername(), user);
        return user;
    }

    @Override
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(String userId) {
        User user = usersById.get(userId);
        usersById.remove(userId);
        usersByUsername.remove(user.getUsername());
    }

    @Override
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(String userId, User user) {
        user.setId(userId);
        usersById.put(userId, user);
        usersByUsername.put(user.getUsername(), user);
    }

    @Override
    public Collection<User> getAll() {
        return usersById.values();
    }

    @Override
    public User getByUsername(String username) {
        return usersByUsername.get(username);
    }
}
