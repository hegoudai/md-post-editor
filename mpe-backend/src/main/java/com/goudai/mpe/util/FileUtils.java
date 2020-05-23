package com.goudai.mpe.util;

/**
 * @author hegoudai@qq.com
 * @date 2020/4/19 18:08
 */
public class FileUtils {
    public static String getExtension(String fileName) {
        String extension = "";

        int i = fileName.lastIndexOf('.');
        if (i > 0) {
            extension = fileName.substring(i + 1);
        }

        return extension;
    }
}
