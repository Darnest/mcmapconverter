package mcmapconverter;

import java.io.File;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.Set;
import mcmaplib.*;

public abstract class MapFormat {
    public abstract String getName();

    public abstract String getDescription();
    
    public abstract Set<String> getExtensions();
    
    public abstract MinecraftMap load(File file)
            throws IOException,
                   NotImplementedException,
                   MapFormatException,
                   FileNotFoundException;

    public abstract MinecraftMap convert(MinecraftMap map)
            throws InvalidMapException;
}