package com.fintecher.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/**
 * @Author: PeiShouWen
 * @Description: 解压缩文件
 * @Date 10:34 2017/3/25
 */
public class UnReduceFile {

    private final static Logger logger = LoggerFactory.getLogger(UnReduceFile.class);

    /**
     * 解压ZIP压缩文件
     *
     * @param inputStream 源文件流
     * @param targetFile  目标文件路径
     * @param charset     源文件编码
     * @return 返回文件目录记录
     */
    public static List<String> unZip(InputStream inputStream, String targetFile, String charset) throws IOException {
        long startTime = System.currentTimeMillis();
        List<String> directoryList = new ArrayList<>();
        try (
                ZipInputStream zis = new ZipInputStream(inputStream, Charset.forName(charset))
        ) {
            ZipEntry entry;
            while ((entry = zis.getNextEntry()) != null) {
                File loadFile = new File(targetFile + entry.getName());
                if (entry.isDirectory()) {
                    directoryList.add(entry.getName().trim());
                    loadFile.mkdirs();
                } else {
                    if (!loadFile.getParentFile().exists()) {
                        try {
                            loadFile.getParentFile().mkdirs();
                        } catch (Exception e) {
                            e.printStackTrace();
                            break;
                        }
                    }
                    // 写入文件
                    BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(loadFile));
                    int read;
                    byte[] buffer = new byte[1024 * 10];
                    while ((read = zis.read(buffer, 0, buffer.length)) != -1) {
                        bos.write(buffer, 0, read);
                    }
                    logger.info(Thread.currentThread() + " 解压文件:" + loadFile.getName() + "成功");
                    bos.flush();
                    bos.close();
                }
            }
            zis.closeEntry();
            zis.close();
            logger.info(Thread.currentThread() + " 解压耗时：" + (System.currentTimeMillis() - startTime) + " 毫秒");
        } catch (IOException e) {
            throw e;
        }
        return directoryList;
    }
}
