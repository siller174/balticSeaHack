package com.baltichack.view.utils;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class MyFileUtils {
    public static void createFileWithDirs(File targetFile) {
        if (!targetFile.exists()) {
            File parent = targetFile.getParentFile();
            if (!parent.exists() && !parent.mkdirs()) {
                throw new IllegalStateException("Couldn't create dir: " + parent);
            }
        }
    }
}
