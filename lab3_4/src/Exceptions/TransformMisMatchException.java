package Exceptions;

public class TransformMisMatchException extends RuntimeException {
    private final String message;

    public TransformMisMatchException(String message) {
        this.message = message;
    }
    @Override
    public String getMessage() {
        return "Ошибка трансформации: " + message;
    }
}
