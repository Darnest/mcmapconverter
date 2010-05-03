package mcmapconverter.gui;

import java.io.File;
import java.util.Set;
import javax.swing.filechooser.*;
import mcmapconverter.MapFormat;

public class MinecraftMapFormatSetFileFilter extends FileFilter {
    Set<MapFormat> mapFormats;

    public MinecraftMapFormatSetFileFilter(Set<MapFormat> mapFormats) {
        this.mapFormats = mapFormats;
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
        boolean accept = false;
        String extension;

        if(file.isDirectory())
            accept = true;
        else {
            extension = getExtension(file);
            if(extension != null) {
                for(MapFormat mapFormat : mapFormats) {
                    Set<String> extensions;

                    extensions = mapFormat.getExtensions();
                    accept = extensions.contains(extension);
                    if(accept)
                        break;
                }
            }
        }
        return accept;
    }

    public String getDescription() {
        return "Minecraft Map";
    }
}