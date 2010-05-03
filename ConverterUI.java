package mcmapconverter;

public interface ConverterUI {
    public void displayInputFileError(String message);
    public void displayOutputFileError(String message);
    public void displayInputFormatError(String message);
    public void displayOutputFormatError(String message);
    public void displayError(String message);
    public void displaySuccess();
}