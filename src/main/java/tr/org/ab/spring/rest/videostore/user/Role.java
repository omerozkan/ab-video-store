package tr.org.ab.spring.rest.videostore.user;

import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Arrays;

/**
 * @author Omer Ozkan
 */
public enum Role {
    USER("user"),
    ADMIN("admin", Role.USER);

    String value;
    Role[] subRoles;

    Role(String value) {
        this.value = value;
        this.subRoles = new Role[0];
    }

    Role(String value, Role... subRoles) {
        this.value = value;
        this.subRoles = subRoles;
    }

    @JsonValue
    public String getValue() {
        return value;
    }

    public boolean hasRole(Role role) {
        return role == this || Arrays.asList(subRoles).contains(role);
    }
}
