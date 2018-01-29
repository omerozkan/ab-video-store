package tr.org.ab.spring.rest.videostore.user;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * @author Omer Ozkan
 */
public enum Role {
    USER("user"),
    ADMIN("admin");

    String value;

    Role(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }
}
