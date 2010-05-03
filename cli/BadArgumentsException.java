package mcmapconverter.cli;

import mcmapconverter.MapConverterException;

public class BadArgumentsException extends MapConverterException {
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