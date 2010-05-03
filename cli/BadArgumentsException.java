package mcmapconverter.cli;

public class BadArgumentsException extends Exception {
    public BadArgumentsException(String s) {
        super(s);
    }

    public BadArgumentsException(Throwable e) {
        super(e);
    }

    public BadArgumentsException(String s, Throwable e) {
        super(s, e);
    }

    public BadArgumentsException() {
        super();
    }
}