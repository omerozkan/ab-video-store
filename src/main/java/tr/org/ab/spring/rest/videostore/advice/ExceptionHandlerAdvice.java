package tr.org.ab.spring.rest.videostore.advice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import tr.org.ab.spring.rest.videostore.core.error.ConflictEntity;
import tr.org.ab.spring.rest.videostore.core.error.NotFound;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

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

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    @ResponseBody
    public List<FieldErrorMessage> handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {
//        List<FieldErrorMessage> errors = new LinkedList<>();
//        for (FieldError fe : ex.getBindingResult().getFieldErrors()){
//            errors.add(new FieldErrorMessage(fe));
//        }
//        return errors;
        return ex.getBindingResult().getFieldErrors()
                .stream()
                .map(FieldErrorMessage::new)
                .collect(Collectors.toList());
    }

    private static class FieldErrorMessage {
        private String field;
        private String message;

        public FieldErrorMessage(FieldError fe) {
            this.field = fe.getField();
            this.message = fe.getDefaultMessage();
        }

        public String getField() {
            return field;
        }

        public void setField(String field) {
            this.field = field;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }
}
