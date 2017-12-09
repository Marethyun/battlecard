package fr.marethyun.battlecard;

public class BattleGameException extends RuntimeException {
    public BattleGameException() {}

    public BattleGameException(String s) {
        super(s);
    }

    public BattleGameException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public BattleGameException(Throwable throwable) {
        super(throwable);
    }

    public BattleGameException(String s, Throwable throwable, boolean b, boolean b1) {
        super(s, throwable, b, b1);
    }
}
