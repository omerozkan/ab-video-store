package tr.org.ab.spring.rest.videostore.advice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import tr.org.ab.spring.rest.videostore.core.error.ConflictEntity;
import tr.org.ab.spring.rest.videostore.core.error.NotFound;

import java.util.Collections;

/**
 * @author Omer Ozkan
 */
@RestControllerAdvice
public class ExceptionHandlerAdvice {

    private final Logger logger = LoggerFactory.getLogger(ExceptionHandlerAdvice.class);

    @ExceptionHandler(NotFound.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Object handleNotFound(NotFound notFound) {
        return Collections.singletonMap("message", notFound.getMessage());
    }

    @ExceptionHandler(ConflictEntity.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public Object handleEntityConflict(ConflictEntity entityConflict) {
        return Collections.singletonMap("message", entityConflict.getMessage());
    }


    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Object handleException(Exception e) {
        logger.error("Internal error", e);
        return Collections.singletonMap("message", "Internal Server Error");

    }
}
