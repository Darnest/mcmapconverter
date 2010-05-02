package mcmapconverter;

import java.util.HashSet;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.io.File;

public class MapFormatDetector {
    private final Map<String, Set<MapFormat>> extensionMapFormats;
    private final Map<String, MapFormat> namedMapFormats;

    public MapFormatDetector() {
        extensionMapFormats = new HashMap<String, Set<MapFormat>>();
        namedMapFormats = new HashMap<String, MapFormat>();
    }

    public MapFormat getMapFormat(String name) {
        return namedMapFormats.get(name.toLowerCase());
    }

    public Set<MapFormat> getMapFormats() {
        return new HashSet<MapFormat>(namedMapFormats.values());
    }

    public Set<MapFormat> getMapFormats(String extension) {
        Set<MapFormat> mapFormats;
        
        mapFormats = extensionMapFormats.get(extension.toLowerCase());
        if(mapFormats != null)
            return new HashSet<MapFormat>(mapFormats);
        return mapFormats;
    }

    public Set<MapFormat> getMapFormats(File file) {
        String filename, extension;

        filename = file.getName();
        extension = filename.substring(filename.lastIndexOf('.') + 1);
        return getMapFormats(extension);
    }

    public void addMapFormat(MapFormat format) {
        Set<String> extensions;

        namedMapFormats.put(format.getName().toLowerCase(), format);
        extensions = format.getExtensions();
        synchronized(extensionMapFormats) {
            synchronized(extensions) {
                for(String extension : extensions) {
                    Set<MapFormat> formats;

                    extension = extension.toLowerCase();
                    if(extensionMapFormats.containsKey(extension)) {
                        formats = extensionMapFormats.get(extension);
                    } else {
                        formats = new HashSet<MapFormat>();
                        extensionMapFormats.put(extension, formats);
                    }
                    synchronized(formats) {
                        formats.add(format);
                    }
                }
            }
        }
    }

    public void removeMapFileFormat(MapFormat format) {
        Set<String> extensions;

        extensions = format.getExtensions();
        synchronized(extensionMapFormats) {
            synchronized(extensions) {
                for(String extension : extensions) {
                    Set<MapFormat> formats;

                    if(extensionMapFormats.containsKey(extension)) {
                        formats = extensionMapFormats.get(extension);
                        synchronized(formats) {
                            formats.remove(format);
                        }
                    }
                }
            }
        }
    }
}