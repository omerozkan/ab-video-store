package tr.org.ab.spring.rest.videostore.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import tr.org.ab.spring.rest.videostore.core.error.NotFound;
import tr.org.ab.spring.rest.videostore.user.User;
import tr.org.ab.spring.rest.videostore.user.service.UserService;

import java.util.Collection;
import java.util.UUID;

/**
 * @author Omer Ozkan
 */
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    User createUser(@RequestBody User user) {
        return userService.add(user);
    }

    @GetMapping("{userKey}")
    User getUser(@PathVariable("userKey") String userKey) {
        return retrieveUser(userKey);
    }

    private User retrieveUser(@PathVariable("userKey") String userKey) {
        User user;
        try {
            UUID.fromString(userKey);
            user = userService.get(userKey);
        } catch (IllegalArgumentException e) {
            user = userService.getByUsername(userKey);
        }
        if (user == null) {
            throw new NotFound("User not found");
        }
        return user;
    }

    @PutMapping("{userKey}")
    void updateUser(@PathVariable("userKey") String userKey, @RequestBody User user) {
        User existing = retrieveUser(userKey);
        userService.update(existing.getId(), user);
    }


    @DeleteMapping("{userKey}")
    void deleteUser(@PathVariable("userKey") String userKey) {
        User existing = retrieveUser(userKey);
        userService.delete(existing.getId());
    }

    @GetMapping
    Collection<User> listUsers() {
        return userService.getAll();
    }

}
