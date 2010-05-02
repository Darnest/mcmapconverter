package mcmapconverter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Collections;
import java.util.Set;
import java.util.HashSet;
import mcmaplib.*;

public class FCraftMapFormat extends MapFormat {
    private final static Set<String> EXTENSIONS;
    private final static String NAME = "fCraft",
                                DESCRIPTION = "Map format for fCraft";

    static {
        Set<String> extensions = new HashSet<String>();
        extensions.add("fcm");
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

    public FCraftMinecraftMap load(File file)
            throws IOException,
                   NotImplementedException,
                   MapFormatException,
                   FileNotFoundException {
        return FCraftMinecraftMap.load(file);
    }

    public FCraftMinecraftMap convert(MinecraftMap map)
            throws InvalidMapException {
        return new FCraftMinecraftMap(map);
    }
}
