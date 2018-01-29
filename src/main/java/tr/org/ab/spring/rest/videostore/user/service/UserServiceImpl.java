package tr.org.ab.spring.rest.videostore.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tr.org.ab.spring.rest.videostore.user.User;
import tr.org.ab.spring.rest.videostore.user.repository.UserRepository;

import java.util.Collection;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Override
    public User get(String id) {
        return userRepository.getOne(id);
    }

    @Override
    public User add(User user) {
        return userRepository.save(user);
    }

    @Override
    public void delete(String userId) {
        User user = getUser(userId);
        userRepository.delete(user);
    }

    @Override
    public void update(String userId, User user) {
        userRepository.save(user);
    }

    private User getUser(String userId) {
        return userRepository.getOne(userId);
    }

    @Override
    public Collection<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public User getByUsername(String username) {
        return userRepository.findUserByUsername(username);
    }
}
