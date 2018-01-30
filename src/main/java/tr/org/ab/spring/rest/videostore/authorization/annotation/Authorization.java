package tr.org.ab.spring.rest.videostore.authorization.annotation;

import tr.org.ab.spring.rest.videostore.user.Role;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author Omer Ozkan
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface Authorization {
    Role requiredRole();
}
