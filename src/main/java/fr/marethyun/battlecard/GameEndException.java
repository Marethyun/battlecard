package fr.marethyun.battlecard;

public class GameEndException extends Exception {
    public GameEndException() {}

    public GameEndException(String s) {
        super(s);
    }

    public GameEndException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public GameEndException(Throwable throwable) {
        super(throwable);
    }

    public GameEndException(String s, Throwable throwable, boolean b, boolean b1) {
        super(s, throwable, b, b1);
    }
}
