package br.com.rodrigoeduque.cursomcnelioalves.utils.exceptionhandler.exceptions;

public class NaoEncontradaException extends RuntimeException {
    public NaoEncontradaException(String mensagem) {
        super(mensagem);
    }

    public NaoEncontradaException(String mensagem, Throwable causa) {
        super(mensagem);
    }
}
