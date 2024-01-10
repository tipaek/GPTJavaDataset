package com.newweb.util;

import javax.swing.JOptionPane;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 文件操作工具类
 *
 * @author qianlong
 *
 */
public class FileUtil {

    /**
     * 获取文本文件的文本内容 若没有此文件，则创建一个新文件，返回空串
     *
     * @param fileName
     * @return
     * @throws IOException
     */
    public static String getTextFileContents(String fileName) {
        String text = "";
        File file = createFileIfNotExists(fileName);
        try {
            FileInputStream fis = new FileInputStream(file);
            byte[] data = new byte[(int) file.length() + 100];
            int bytesRead = fis.read(data);
            text = new String(data, 0, bytesRead);
            fis.close();
        } catch (Exception e) {
            showErrorMessage("文件读取失败，请检查是否有文件读取权限，或指定文件是否损坏等");
        }
        return text;
    }

    /**
     * 获取指定路径下的所有文件中的文本
     *
     * @param path
     * @return
     */
    public static List<String> getAllFileTextFromDir(String path) {
        List<String> filesText = new ArrayList<>();
        File directory = createDirectoryIfNotExists(path);
        File[] files = directory.listFiles();
        try {
            for (File file : files) {
                FileInputStream fis = new FileInputStream(file);
                byte[] data = new byte[(int) file.length() + 100];
                int bytesRead = fis.read(data);
                String text = new String(data, 0, bytesRead);
                filesText.add(text);
                fis.close();
            }
        } catch (Exception e) {
            showErrorMessage("获取文件List内容失败");
        }
        return filesText;
    }

    /**
     * 获取传入的路径下的文件的文件内容
     * 如果文件不存在，将自动根据路径及文件名创建一个新的，返回空串
     *
     * @param path
     * @param fileName
     * @return
     */
    public static String getFileTextFromDirFile(String path, String fileName) {
        String text = "";
        File directory = createDirectoryIfNotExists(path);
        File file = new File(directory, fileName);
        if (!file.exists()) {
            createFile(file);
        }
        try {
            FileInputStream fis = new FileInputStream(file);
            byte[] data = new byte[(int) file.length() + 50];
            int bytesRead = fis.read(data);
            text = new String(data, 0, bytesRead);
            fis.close();
        } catch (Exception e) {
            showErrorMessage("获取指定路径文件内容失败");
        }
        return text;
    }

    /**
     * 将制定的字符串写入指定路径下的指定文件中
     * 如果路径及文件不存在，将自动创建
     *
     * @param text
     * @param path
     * @param fileName
     * @param append: true为在文件后追加内容
     * @return
     */
    public static boolean writeTextToTextFile(String text, String path, String fileName, boolean append) {
        File directory = createDirectoryIfNotExists(path);
        File file = new File(directory, fileName);
        createFile(file);
        try {
            FileOutputStream fos = new FileOutputStream(file, append);
            byte[] write = text.getBytes();
            fos.write(write);
            fos.close();
            return true;
        } catch (Exception e) {
            showErrorMessage("发生错误");
            return false;
        }
    }

    private static File createFileIfNotExists(String fileName) {
        File file = new File(fileName);
        if (!file.exists()) {
            createFile(file);
        }
        return file;
    }

    private static File createDirectoryIfNotExists(String path) {
        File directory = new File(path);
        if (!directory.exists()) {
            directory.mkdirs();
        }
        return directory;
    }

    private static void createFile(File file) {
        try {
            file.createNewFile();
        } catch (IOException e) {
            showErrorMessage("创建文件失败，请检查是否有文件写入权限或磁盘是否有可用空间");
        }
    }

    private static void showErrorMessage(String message) {
        JOptionPane.showConfirmDialog(null, message, "系统消息", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE);
    }
}
