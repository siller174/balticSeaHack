package com.baltichack.view.utils;

import java.io.File;

public class FileUtils {
    public static void createDir(String path) {
        File file = new File(path);
        if (!file.exists()) {
            file.mkdirs();
        }

    }
}
