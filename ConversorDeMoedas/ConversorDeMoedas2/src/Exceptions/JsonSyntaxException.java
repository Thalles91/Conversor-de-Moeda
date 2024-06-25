package Exceptions;

public class JsonSyntaxException extends Throwable {
    @Override
    public String getMessage() {
        return "Entre em contato ou tente mais tarde";
    }

}