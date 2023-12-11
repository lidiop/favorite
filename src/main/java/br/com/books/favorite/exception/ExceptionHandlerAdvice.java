package br.com.books.favorite.exception;

import com.mongodb.DuplicateKeyException;
import com.mongodb.MongoWriteException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

@ControllerAdvice
public class ExceptionHandlerAdvice extends ResponseEntityExceptionHandler {

    @ExceptionHandler(HttpClientErrorException.class)
    public ResponseEntity<Object> handleHttpClientErrorException(
            HttpClientErrorException ex, WebRequest request) {
        return getObjectResponseEntity(ex);
    }

    @ExceptionHandler(DuplicateKeyException.class)
    public ResponseEntity<Object> handleDuplicateKeyException(
            DuplicateKeyException ex, WebRequest request) {
        return getObjectResponseEntity(ex);
    }

    @ExceptionHandler(org.springframework.dao.DuplicateKeyException.class)
    public ResponseEntity<Object> handleDuplicateKeyExceptionDao(
            org.springframework.dao.DuplicateKeyException ex, WebRequest request) {
        return getObjectResponseEntity(ex);
    }

    @ExceptionHandler(MongoWriteException.class)
    public ResponseEntity<Object> handleMongoWriteException(
            MongoWriteException ex, WebRequest request) {
        return getObjectResponseEntity(ex);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<Object> handleRuntimeException(
            RuntimeException ex, WebRequest request) {
        return getObjectResponseEntity(ex);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<Object> handleRuntimeException(
            UserNotFoundException ex, WebRequest request) {
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("message", ex.getMessage());
        body.put("status", HttpStatus.NOT_FOUND.value());
        body.put("error", HttpStatus.NOT_FOUND.getReasonPhrase());
        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
    }

    private ResponseEntity<Object> getObjectResponseEntity(Exception ex) {
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("message", ex.getMessage());
        body.put("status", HttpStatus.BAD_REQUEST.value());
        body.put("error", HttpStatus.BAD_REQUEST.getReasonPhrase());
        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
    }
}