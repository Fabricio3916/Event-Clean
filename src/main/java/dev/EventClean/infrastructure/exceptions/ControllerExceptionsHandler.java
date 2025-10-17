package dev.EventClean.infrastructure.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ControllerExceptionsHandler {

    @ExceptionHandler(DuplicateEventException.class)
    public ResponseEntity<Map<String, String>> handleDuplicateEventException(DuplicateEventException ex) {
        Map<String, String> response = new HashMap<>();
        response.put("Erro:" , ex.getMessage());
        response.put("Mensagem: " , "Por favor insira um identificar valido e tente novamente.");
        return new ResponseEntity<>(response,HttpStatus.CONFLICT);
    }

    @ExceptionHandler(NotFoundEventException.class)
    public ResponseEntity<Map<String, String>> handleNotFoundEventException(NotFoundEventException ex) {
        Map<String, String> response = new HashMap<>();
        response.put("Erro:" , ex.getMessage());
        response.put("Mensagem: " , "Por favor insira um identificar valido e tente novamente.");
        return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
    }

}
