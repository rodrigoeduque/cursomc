package br.com.rodrigoeduque.cursomcnelioalves.utils.exceptionhandler.exceptions;

public class IntegridadeBancoDadosException extends RuntimeException {
    public IntegridadeBancoDadosException(String mensagem) {
        super(mensagem);
    }

    public IntegridadeBancoDadosException(String mensagem, Throwable causa) {
        super(mensagem);
    }
}
