package ro.fasttrack.curs13Homework;

public class NoActivityException extends RuntimeException {

    public NoActivityException() {
        super("Activity can't be found!");
    }
}
