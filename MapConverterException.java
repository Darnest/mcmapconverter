package mcmapconverter;

public class MapConverterException extends Exception {
    public MapConverterException(String s) {
        super(s);
    }

    public MapConverterException(Throwable e) {
        super(e);
    }

    public MapConverterException(String s, Throwable e) {
        super(s, e);
    }

    public MapConverterException() {
        super();
    }
}