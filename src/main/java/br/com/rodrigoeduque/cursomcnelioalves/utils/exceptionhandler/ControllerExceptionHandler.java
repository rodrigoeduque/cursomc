package br.com.rodrigoeduque.cursomcnelioalves.utils.exceptionhandler;

import br.com.rodrigoeduque.cursomcnelioalves.utils.exceptionhandler.exceptions.NaoEncontradaException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(NaoEncontradaException.class)
    public ResponseEntity<StandardError> naoEncontrada(NaoEncontradaException e, HttpServletRequest request) {
        StandardError error = new StandardError(HttpStatus.NOT_FOUND.value(), e.getMessage(), System.currentTimeMillis());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }
}
