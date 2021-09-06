package br.com.rodrigoeduque.cursomcnelioalves.utils.exceptionhandler;

public class StandardError {

    private Integer status;
    private String message;
    private Long timeStamp;

    @Deprecated
    public StandardError() {
    }

    public StandardError(Integer status, String message, Long timeStamp) {
        this.status = status;
        this.message = message;
        this.timeStamp = timeStamp;
    }

    public Integer getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public Long getTimeStamp() {
        return timeStamp;
    }
}
