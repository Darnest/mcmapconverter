package mcmapconverter.gui;

import java.io.File;
import java.util.Set;
import javax.swing.filechooser.*;
import mcmapconverter.MapFormat;

public class MinecraftMapFormatFileFilter extends FileFilter {
    private MapFormat mapFormat;
    private String description;

    private static String getDescription(MapFormat mapFormat) {
        String description;
        Set<String> extensions;
        boolean first = true;

        extensions = mapFormat.getExtensions();
        description = mapFormat.getName() + " (";
        for(String extension : extensions) {
            if(first)
                first = false;
            else
                description += ", ";
            description += "." + extension;
        }
        description += ")";
        return description;
    }

    public MinecraftMapFormatFileFilter(MapFormat mapFormat) {
        this.mapFormat = mapFormat;
        description = getDescription(mapFormat);
    }

    private String getExtension(File file) {
        String filename, extension;
        int extensionIndex;

        filename = file.getName();
        extensionIndex = filename.lastIndexOf('.');
        if(extensionIndex == -1)
            return null;
        extension = filename.substring(extensionIndex + 1);
        return extension;
    }

    @Override
    public boolean accept(File file) {
        boolean accept;
        String extension;
        Set<String> extensions;

        if(file.isDirectory())
            accept = true;
        else {
            extension = getExtension(file);
            extensions = mapFormat.getExtensions();
            if(extension == null)
                accept = false;
            else
                accept = extensions.contains(extension);
        }
        return accept;
    }

    public String getDescription() {
        return description;
    }

    public MapFormat getMapFormat() {
        return mapFormat;
    }
}