package mcmapconverter;

import mcmapconverter.cli.Console;
import mcmapconverter.gui.ConverterWindow;

public class Main {
    public static void main(String[] args) {
        Converter converter;
        
        converter = new Converter();
        converter.addMapFormat(new DatMapFormat());
        converter.addMapFormat(new MCSharpMapFormat());
        converter.addMapFormat(new RUMMapFormat());
        converter.addMapFormat(new FCraftMapFormat());

        boolean cli;
        try {
            cli = System.console() != null;
        } catch(NoSuchMethodError e) {
            cli = false;
        }
        if(cli) {
            for(String arg : args) {
                if(arg.equals("-gui")) {
                    cli = false;
                }
            }
        } else {
            for(String arg : args) {
                if(arg.equals("-cli")) {
                    cli = true;
                }
            }
        }
        if(cli)
            new Console(converter, args);
        else
            new ConverterWindow(converter);
    }
}