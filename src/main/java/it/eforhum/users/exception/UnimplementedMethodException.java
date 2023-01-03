package it.eforhum.users.exception;

public class UnimplementedMethodException extends RuntimeException {
    public UnimplementedMethodException() {
        super("Method not already implemented");
    }

    public UnimplementedMethodException(String msg) {
        super(msg);
    }
}
