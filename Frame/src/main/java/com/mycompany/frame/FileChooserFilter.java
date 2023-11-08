package com.mycompany.frame;

import jdk.jshell.execution.Util;

import javax.swing.filechooser.FileFilter;
import java.io.File;
import org.apache.commons.io.FilenameUtils;

public class FileChooserFilter extends FileFilter {
    @Override
    public boolean accept(File file) {
        if(file.isDirectory()){
            return true;
        }

        String ext=FilenameUtils.getExtension(file.getAbsolutePath());
        if(ext==null){
            return false;
        }
        if(ext.equals("per")){
            return true;
        }
        return false;
    }

    @Override
    public String getDescription() {
        return "Ficheiro con formato (*.per)";
    }
}
