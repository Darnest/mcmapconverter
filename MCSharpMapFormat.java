package mcmapconverter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Collections;
import java.util.Set;
import java.util.HashSet;
import mcmaplib.*;

public class MCSharpMapFormat extends MapFormat {
    private final static Set<String> EXTENSIONS;
    private final static String NAME = "MCSharp",
                                DESCRIPTION = "Map format for MCSharp";

    static {
        Set<String> extensions = new HashSet<String>();
        extensions.add("lvl");
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

    public MCSharpMinecraftMap load(File file)
            throws IOException,
                   NotImplementedException,
                   MapFormatException,
                   FileNotFoundException {
        return MCSharpMinecraftMap.load(file);
    }

    public MCSharpMinecraftMap convert(MinecraftMap map)
            throws InvalidMapException {
        return new MCSharpMinecraftMap(map);
    }
}
