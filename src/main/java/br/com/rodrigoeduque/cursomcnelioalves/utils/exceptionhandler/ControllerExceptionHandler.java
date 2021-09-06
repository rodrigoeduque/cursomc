package br.com.rodrigoeduque.cursomcnelioalves.utils.exceptionhandler;

import br.com.rodrigoeduque.cursomcnelioalves.utils.exceptionhandler.exceptions.IntegridadeBancoDadosException;
import br.com.rodrigoeduque.cursomcnelioalves.utils.exceptionhandler.exceptions.NaoEncontradaException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class ControllerExceptionHandler {

    @Autowired
    private MessageSource messageSource;

    @ExceptionHandler(NaoEncontradaException.class)
    public ResponseEntity<StandardError> naoEncontrada(NaoEncontradaException e, HttpServletRequest request) {
        StandardError error = new StandardError(HttpStatus.NOT_FOUND.value(), e.getMessage(), System.currentTimeMillis());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    @ExceptionHandler(IntegridadeBancoDadosException.class)
    public ResponseEntity<StandardError> integridadeDados(IntegridadeBancoDadosException e, HttpServletRequest request) {
        StandardError error = new StandardError(HttpStatus.BAD_REQUEST.value(), e.getMessage(), System.currentTimeMillis());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<?>> beanValidation(MethodArgumentNotValidException e, HttpServletRequest request) {

        List<FieldMessageResponse> list = new ArrayList<>();
        List<FieldError> fieldErrors = e.getBindingResult().getFieldErrors();

        fieldErrors.forEach(erros -> {
                    String mensagem = messageSource.getMessage(erros, LocaleContextHolder.getLocale());
                    FieldMessageResponse standardError = new FieldMessageResponse(erros.getField(), mensagem);
                    list.add(standardError);
                }
        );

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(list);
    }
}
