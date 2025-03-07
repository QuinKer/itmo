package Exceptions;

public class BodyPartTypeMismatchException extends Exception {
    private final String message;
    public BodyPartTypeMismatchException(String message) {this.message = message;}

    @Override
    public String getMessage() {
        return "Ошибка в процессе надевания: " + message;
    }
}
