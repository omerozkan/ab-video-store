package tr.org.ab.spring.rest.videostore.user;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.UUID;

/**
 * @author Omer Ozkan
 */
@Entity
public class User {
    @Id
    private String id;
    @NotEmpty
    private String username;
    private String password;
    @NotEmpty
    private String name;
    @Email(message = "invalid email address")
    private String email;
    private String address;
    private String phoneNumber;
    @Enumerated(EnumType.STRING)
    private Role role;

    public User(String memojja, String s, String mehmet, String s1, String s2, String user){
        this.id = UUID.randomUUID().toString();
    }

    public User() {
        this.id = UUID.randomUUID().toString();
    }

    public String getId() {
        return id;
    }

    public User setId(String id) {
        this.id = id;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public User setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getName() {
        return name;
    }

    public User setName(String name) {
        this.name = name;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public User setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public User setAddress(String address) {
        this.address = address;
        return this;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public User setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public Role getRole() {
        return role;
    }

    public User setRole(Role role) {
        this.role = role;
        return this;
    }
}
