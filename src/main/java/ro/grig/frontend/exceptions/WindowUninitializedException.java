package ro.grig.frontend.exceptions;

public class WindowUninitializedException extends Exception {
    public WindowUninitializedException() {
        super("No window initialized!");
    }
}
