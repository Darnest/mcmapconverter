package mcmapconverter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Collections;
import java.util.Set;
import java.util.HashSet;
import mcmaplib.*;

public class DatMapFormat extends MapFormat {
    private final static Set<String> EXTENSIONS;
    private final static String NAME = "dat";
    private final static String DESCRIPTION = "Official minecraft map format";

    static {
        Set<String> extensions = new HashSet<String>();
        extensions.add("dat");
        EXTENSIONS = Collections.unmodifiableSet(extensions);
    }

    public String getName() {
        return NAME;
    }

    public String getDescription() {
        return DESCRIPTION;
    }


    public Set<String> getExtensions() {
        return EXTENSIONS;
    }

    public DatMinecraftMap load(File file)
            throws IOException,
                   NotImplementedException,
                   MapFormatException,
                   FileNotFoundException {
        return DatMinecraftMap.load(file);
    }

    public DatMinecraftMap convert(MinecraftMap map)
            throws InvalidMapException {
        return new DatMinecraftMap(map);
    }
}
