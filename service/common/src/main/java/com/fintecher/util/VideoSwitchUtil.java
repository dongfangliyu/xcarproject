package com.fintecher.util;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author:peishouwen
 * @Desc:
 * @Date:Create in 11:00 2017/11/2
 */
public class VideoSwitchUtil {
    public static Map<String, String> getOsInfo() {
        Map<String, String> map = new HashMap<>();
        //java版本号
        String javaVersion = System.getProperty("java.version");
        map.put("javaVersion", javaVersion);
        //java目录
        String javaHome = System.getProperty("java.home");
        map.put("javaHome", javaHome);
        //操作系统OSName
        String osName = System.getProperty("os.name");
        map.put("osName", osName);
        //操作系统架构
        String osArch = System.getProperty("os.arch");
        map.put("osArch", osArch);
        //操作系统版本
        String osVersion = System.getProperty("os.version");
        map.put("osVersion", osVersion);
        return map;
    }

    /**
     * 转为MP3格式
     *
     * @param sourcePath 源文件所在路径
     * @param ffmpegPath ffmpeg.exe 所在路径 "C:\\ffmpeg\\bin\\ffmpeg.exe" linux :/user/bin/ffmpeg
     * @return
     */
    public static String switchToMp3(String sourcePath, String ffmpegPath) {
        File file = new File(sourcePath);
        if (!file.exists()) {
            throw new RuntimeException(sourcePath.concat("文件不存在"));
        }
        String newVideoPath = sourcePath.substring(0, sourcePath.lastIndexOf(".")).concat(".mp3");
        try {
            Integer type = checkVideoType(sourcePath);
            if (0 == type) {
                List<String> commands = new ArrayList<String>();
                commands.add(ffmpegPath);//"C:\\ffmpeg\\bin\\ffmpeg.exe"
                commands.add("-i");
                commands.add(sourcePath);
                commands.add("-f");
                commands.add("mp3");
                commands.add("-y");//文件存在选择重写
                commands.add(newVideoPath);
                ProcessBuilder builder = new ProcessBuilder();
                builder.command(commands);
                Process process = builder.start();
                //process.waitFor();//等待进程执行完毕
                //防止ffmpeg进程塞满缓存造成死锁
                InputStream error = process.getErrorStream();
                InputStream is = process.getInputStream();
                byte[] b = new byte[2048];
                int readbytes = -1;
                try {
                    while ((readbytes = error.read(b)) != -1) {
                        System.out.println("FFMPEG视频转换进程错误信息：" + new String(b, 0, readbytes));
                    }
                    while ((readbytes = is.read(b)) != -1) {
                        System.out.println("FFMPEG视频转换进程输出内容为：" + new String(b, 0, readbytes));
                    }
                } catch (IOException e2) {
                    e2.printStackTrace();
                } finally {
                    error.close();
                    is.close();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return newVideoPath;
    }

    /**
     * @param path
     * @return 0 可以转换 1-不能转换 9-不需要转换
     */
    private static Integer checkVideoType(String path) {
        String type = path.substring(path.lastIndexOf(".") + 1, path.length()).toLowerCase();
        switch (type) {
            case "avi":
                return 0;
            case "mpg":
                return 0;
            case "wmv":
                return 0;
            case "3gp":
                return 0;
            case "mov":
                return 0;
            case "mp4":
                return 9;
            case "asf":
                return 0;
            case "asx":
                return 0;
            case "flv":
                return 0;
            case "wav":
                return 0;
            case "wmv9":
                return 1;
            case "rm":
                return 1;
            case "rmvb":
                return 1;
            default:
                return 9;
        }
    }

    /**
     * 获取语音时长
     *
     * @param sourcePath 源文件路径
     * @param ffmpegPath 解码器路径
     * @return
     * @throws IOException
     */
    public static String getVideoTime(String sourcePath, String ffmpegPath) throws IOException {
        File file = new File(sourcePath);
        if (!file.exists()) {
            throw new RuntimeException(sourcePath.concat("文化不存在"));
        }
        List<String> commands = new ArrayList<String>();
        commands.add(ffmpegPath);//"C:\\ffmpeg\\bin\\ffmpeg.exe"
        commands.add("-i");
        commands.add(sourcePath);
        ProcessBuilder builder = new ProcessBuilder();
        builder.command(commands);
        Process process = builder.start();
        //防止ffmpeg进程塞满缓存造成死锁
        //从输入流中读取视频信息
        BufferedReader br = new BufferedReader(new InputStreamReader(process.getErrorStream()));
        StringBuffer sb = new StringBuffer();
        try {
            String line = "";
            while ((line = br.readLine()) != null) {
                if (line.indexOf("Duration") != -1) {
                    sb.append(line);
                }
            }
        } finally {
            br.close();
        }
        if (sb.length() > 0) {
            String[] timeArr = sb.toString().split(",");
            String timeStr = timeArr[0];
            return timeStr.replaceAll("Duration: ", "");
        }
        return "0";
    }

    public static void main(String[] args) {
        try {
            System.out.println(getVideoTime("E:\\文档\\项目文档\\催收系统\\mr.cui-cuidaren\\项目实施\\海口和清\\海南和清部署备忘\\录音文件\\VOA00084.WAV", "C:\\ffmpeg\\bin\\ffmpeg.exe"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
