package tr.org.ab.spring.rest.videostore.user.fixture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tr.org.ab.spring.rest.videostore.user.Role;
import tr.org.ab.spring.rest.videostore.user.User;
import tr.org.ab.spring.rest.videostore.user.service.UserService;

import javax.annotation.PostConstruct;

/**
 * @author Omer Ozkan
 */
@Component
class UserFixture {

    @Autowired
    private UserService userService;


    @PostConstruct
    public void addTestUsers() {
        User user = new User()
                .setEmail("test@video.store")
                .setAddress("No address")
                .setName("Test User")
                .setPassword("password")
                .setUsername("user")
                .setRole(Role.USER)
                .setPhoneNumber("+123456");

        User admin = new User()
                .setEmail("admin@video.store")
                .setAddress("No address")
                .setName("Admin User")
                .setPassword("password")
                .setUsername("admin")
                .setRole(Role.ADMIN)
                .setPhoneNumber("+1234567");

        userService.add(user);
        userService.add(admin);

    }
}
