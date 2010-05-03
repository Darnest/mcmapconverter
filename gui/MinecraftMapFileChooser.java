package mcmapconverter.gui;

import java.util.Set;
import javax.swing.*;
import javax.swing.filechooser.*;
import mcmapconverter.MapFormat;

public class MinecraftMapFileChooser extends JFileChooser {
    public MinecraftMapFileChooser(Set<MapFormat> mapFormats) {
        FileFilter defaultFilter;

        setAcceptAllFileFilterUsed(false);
        
        defaultFilter = new MinecraftMapFormatSetFileFilter(mapFormats);
        addChoosableFileFilter(defaultFilter);
        for(MapFormat mapFormat : mapFormats) {
            addChoosableFileFilter(
                    new MinecraftMapFormatFileFilter(mapFormat));
        }
        setFileFilter(defaultFilter);
    }
}