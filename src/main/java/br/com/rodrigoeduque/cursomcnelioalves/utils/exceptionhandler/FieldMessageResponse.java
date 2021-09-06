package br.com.rodrigoeduque.cursomcnelioalves.utils.exceptionhandler;

public class FieldMessageResponse {

    private String campo;
    private String mensagem;

    public FieldMessageResponse() {
    }

    public FieldMessageResponse(String fieldName, String message) {
        this.campo = fieldName;
        this.mensagem = message;
    }

    public String getCampo() {
        return campo;
    }

    public String getMensagem() {
        return mensagem;
    }
}
