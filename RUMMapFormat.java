package mcmapconverter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Collections;
import java.util.Set;
import java.util.HashSet;
import mcmaplib.*;

public class RUMMapFormat extends MapFormat {
    private final static Set<String> EXTENSIONS;
    private final static String NAME = "RUM";
    private final static String DESCRIPTION = "Revenant's Universal Minecraft-Map format";

    static {
        Set<String> extensions = new HashSet<String>();
        extensions.add("rum");
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

    public RUMMinecraftMap load(File file)
            throws IOException,
                   NotImplementedException,
                   MapFormatException,
                   FileNotFoundException {
        return RUMMinecraftMap.load(file);
    }

    public RUMMinecraftMap convert(MinecraftMap map)
            throws InvalidMapException {
        return new RUMMinecraftMap(map);
    }
}
