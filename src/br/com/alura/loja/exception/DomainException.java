package br.com.alura.loja.exception;

public class DomainException extends RuntimeException {

    private static final long serialVersionUID = 1706439193808268949L;

    public DomainException(String message) {
        super(message);
    }
}
