package com.yeshj.pacman.utils;

import org.apache.commons.compress.archivers.ArchiveStreamFactory;
import org.apache.commons.compress.archivers.zip.Zip64Mode;
import org.apache.commons.compress.archivers.zip.ZipArchiveEntry;
import org.apache.commons.compress.archivers.zip.ZipArchiveOutputStream;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class FileHelper {

    public static final String FILE_SEPARATOR = System.getProperties().getProperty("file.separator");

    public static boolean isWindow() {
        return "\\".equals(FILE_SEPARATOR);
    }

    public static boolean exists(String dirOrFile) {
        if (StringUtils.isBlank(dirOrFile)) {
            return false;
        }
        return new File(dirOrFile).exists();
    }

    public static boolean ensureExists(String dir, boolean isFile) {
        if (StringHelper.isEmpty(dir)) {
            return false;
        }

        try {
            File file = new File(dir);
            if (isFile) {
                FileUtils.forceMkdir(file.getParentFile());
                if (!file.exists()) {
                    file.createNewFile();
                }
            } else {
                FileUtils.forceMkdir(file);
            }

            return true;
        } catch (IOException e) {
            return false;
        }
    }

    public static boolean deleteDir(String dir) {
        try {
            FileUtils.deleteDirectory(new File(dir));
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    public static boolean copyFile(String src, String dest) {
        try {
            FileUtils.copyFile(new File(src), new File(dest));
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    public static boolean moveFile(String src, String dest) {
        try {
            FileUtils.moveFile(new File(src), new File(dest));
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    public static boolean copyDir(String srcDir, String destDir) {
        if (!exists(srcDir)) {
            return false;
        }

        try {
            FileUtils.copyDirectory(new File(srcDir), new File(destDir), true);
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    public static boolean moveDir(String srcDir, String destDir) {
        if (!exists(srcDir)) {
            return false;
        }

        try {
            FileUtils.moveDirectoryToDirectory(new File(srcDir), new File(destDir), true);
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    // The rest of the code goes here...
}
