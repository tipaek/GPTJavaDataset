package com.yeshj.pacman.test;

import com.yeshj.pacman.utils.FileHelper;
import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class FileHelperTest {

    private final String tempDir = FileHelper.isWindow() ?
            "e:\\null" + new Random().nextInt() :
            "/tmp/null" + new Random().nextInt();
    private String srcDir;
    private String destDir;
    private String testFile;

    @Before
    public void setUp() throws Exception {
        File dir = new File(tempDir);
        FileUtils.forceMkdir(dir);

        srcDir = FileHelper.combinePath(tempDir, "src");
        destDir = FileHelper.combinePath(tempDir, "dest");
        FileUtils.forceMkdir(new File(srcDir));
        FileUtils.forceMkdir(new File(destDir));

        testFile = FileHelper.combinePath(srcDir, "test.file");
        File file = new File(testFile);
        file.createNewFile();

        try (FileOutputStream output = new FileOutputStream(file)) {
            output.write("test is not a test".getBytes());
        }
    }

    @After
    public void tearDown() throws Exception {
        File dir = new File(tempDir);
        FileUtils.forceDeleteOnExit(dir);
    }

    @Test
    public void testCopyFile() throws IOException {
        String destFile = FileHelper.combinePath(destDir, "ddd.cp");
        FileHelper.copyFile(testFile, destFile);

        assertTrue(FileHelper.exists(destFile));
        assertTrue(FileHelper.exists(testFile));
    }

    @Test
    public void testMoveFile() throws IOException {
        String destFile = FileHelper.combinePath(destDir, "ddd.cp");
        FileHelper.moveFile(testFile, destFile);

        assertTrue(FileHelper.exists(destFile));
        assertFalse(FileHelper.exists(testFile));
    }

    @Test
    public void testMoveDir() throws Exception {
        FileHelper.moveDir(srcDir, destDir);
        String actualDir = FileHelper.combinePath(destDir, "/src/");
        String actualFile = FileHelper.combinePath(destDir, "/src/test.file");
        assertTrue(FileHelper.exists(actualDir));
        assertTrue(FileHelper.exists(actualFile));
        assertFalse(FileHelper.exists(srcDir));
    }
}
