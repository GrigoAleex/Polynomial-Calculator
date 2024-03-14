package ro.grig.frontend.exceptions;

public class ViewNotFoundException extends Exception{
    public ViewNotFoundException() {
        super("View not found!");
    }
}
