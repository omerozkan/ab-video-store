package tr.org.ab.spring.rest.videostore.authorization;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import tr.org.ab.spring.rest.videostore.authorization.annotation.Authorization;
import tr.org.ab.spring.rest.videostore.core.error.UnauthenticatedClient;
import tr.org.ab.spring.rest.videostore.core.error.UnauthorizedUser;
import tr.org.ab.spring.rest.videostore.user.Role;
import tr.org.ab.spring.rest.videostore.user.User;
import tr.org.ab.spring.rest.videostore.user.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Base64;

/**
 * @author Omer Ozkan
 */
@Component
public class AuthorizationInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    private UserService userService;

    @Autowired
    private AuthenticatedUser authenticatedUser;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (!(handler instanceof HandlerMethod)) {
            throw new IllegalArgumentException("Unsupported request");
        }

        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Authorization authorization = handlerMethod.getMethodAnnotation(Authorization.class);

        if (authorization == null) {
            return true;
        }

        User user = authenticateUser(request);
        authenticatedUser.setUser(user);

        Role requiredRole = authorization.requiredRole();
        if (!user.getRole().hasRole(requiredRole)) {
            throw new UnauthorizedUser();
        }

        return true;
    }

    private User authenticateUser(HttpServletRequest request) {
        String authorizationHeaderValue = request.getHeader("Authorization");

        if (authorizationHeaderValue == null || !authorizationHeaderValue.startsWith("Basic")) {
            throw new UnauthenticatedClient();
        }

        String encoded = authorizationHeaderValue.replace("Basic ", "");
        byte[] decoded = Base64.getDecoder().decode(encoded);
        String decodedString = new String(decoded);

        String[] tokens = decodedString.split(":", 2);

        if (tokens.length != 2) {
            throw new UnauthenticatedClient();
        }

        String username = tokens[0];
        String password = tokens[1];

        User user = userService.getByUsername(username);
        if (user == null) {
            throw new UnauthenticatedClient();
        }

        if (!user.getPassword().equals(password)) {
            throw new UnauthenticatedClient();
        }
        return user;
    }

}
