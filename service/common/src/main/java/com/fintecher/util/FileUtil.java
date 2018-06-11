package com.fintecher.util;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author:peishouwen
 * @Desc: 文件操作工具
 * @Date:Create in 10:45 2017/11/1
 */
public class FileUtil {

    /**
     * 通过GLOB筛选文件
     *
     * @param basePath
     * @param ruleStr
     * @return
     */
    public static List<Path> simpleSearchFiles(String basePath, String ruleStr, List<Path> pathList) {
        if (Objects.isNull(pathList)) {
            pathList = new ArrayList<>();
        }
        Path directoryPath = Paths.get(basePath);
        if (Files.isDirectory(directoryPath)) {
            try (DirectoryStream<Path> stream = Files.newDirectoryStream(directoryPath, ruleStr)) { // File*Exception*
                for (Path path : stream) {
                    if (Files.isDirectory(path)) {
                        simpleSearchFiles(path.toString(), ruleStr, pathList);
                    } else {
                        pathList.add(path);
                    }
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return pathList;
    }

    /**
     * 通过Filter做文件过滤
     *
     * @param basePath
     * @param regexp
     * @param pathList
     * @return
     */
    public static List<Path> filterSearchFiles(String basePath, String regexp, List<Path> pathList) {
        if (Objects.isNull(pathList)) {
            pathList = new ArrayList<>();
        }
        DirectoryStream.Filter<Path> filter = new DirectoryStream.Filter<Path>() {
            @Override
            public boolean accept(Path entry) throws IOException {
                Pattern pattern = Pattern.compile(regexp);
                //文件夹不过滤
                if (Files.isDirectory(entry)) {
                    return true;
                }
                Matcher match = pattern.matcher(entry.getFileName().toString());
                return match.find();
            }
        };
        Path directoryPath = Paths.get(basePath);
        if (Files.isDirectory(directoryPath)) {
            try (DirectoryStream<Path> stream = Files.newDirectoryStream(directoryPath, filter)) {
                for (Path path : stream) {
                    if (Files.isDirectory(path)) {
                        filterSearchFiles(path.toString(), regexp, pathList);
                    } else {
                        pathList.add(path);
                    }
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return pathList;
    }

    /**
     * 获取文件属性
     *
     * @param pathStr
     */
    public static void getFileAttributes(String pathStr) {
        try {
            Path path = Paths.get(pathStr);
            //获取访问基本属性的BasicFileAttributeView
            BasicFileAttributeView basicView = Files.getFileAttributeView(path, BasicFileAttributeView.class);
            //获取访问基本属性的BasucFileAttributes
            BasicFileAttributes basicAttribs = basicView.readAttributes();
            //访问文件的基本属性
            //创建时间
            System.out.println(new Date(basicAttribs.creationTime().toMillis()));
            //最后访问时间
            System.out.println(new Date(basicAttribs.lastAccessTime().toMillis()));
            //最后修改时间
            System.out.println(new Date(basicAttribs.lastModifiedTime().toMillis()));
            //文件大小
            System.out.println(basicAttribs.size());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public static void main(String[] args) {
//        List<Path> pathList = FileUtil.filterSearchFiles("E:\\文档\\项目文档\\催收系统\\mr.cui-cuidaren\\项目实施\\海口和清", "^*.WAV$", null);
//        for (Path path : pathList) {
//            System.out.println(path);
//        }

//        String filepath = "D:\\data\\20181108\\pingping";
//        File file = new File(filepath);
//        if (!file.isDirectory()) {
//            System.out.println("文件");
//            System.out.println("path=" + file.getPath());
//            System.out.println("absolutepath=" + file.getAbsolutePath());
//            System.out.println("name=" + file.getName());
//
//        } else if (file.isDirectory()) {
//            System.out.println("文件夹");
//            String[] filelist = file.list();
//            for (int i = 0; i < filelist.length; i++) {
//                File readfile = new File(filepath + "\\" + filelist[i]);
//                if (!readfile.isDirectory()) {
//                    System.out.println("path=" + readfile.getPath());
//                    System.out.println("absolutepath="
//                            + readfile.getAbsolutePath());
//                    System.out.println("name=" + readfile.getName());
//
//                } else if (readfile.isDirectory()) {
//                }
//            }
//        }
    }
}
