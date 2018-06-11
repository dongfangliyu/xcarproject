package com.fintecher.contract.util;

import com.fintecher.contract.service.Impl.ContractGeneratorServiceImpl;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileInputStream;
import java.util.Map;

/**
 * @Author wxc
 * @Data 2018/2/2 17:14
 * @Description
 */
public class CreatePdfUtil {
    private static final Logger logger = LoggerFactory.getLogger(ContractGeneratorServiceImpl.class);

    /**
     *  功能说明：生成PDF合同
     *
     */
    public static String generatorPdfUpload(JSONObject paramJson, Map<String, Object> listJson, String pdfUrl,
                                            String pdfName, String pdf_templet) {
        // 定义返回JSON
        JSONObject jsonResult = new JSONObject();
        try {

            // 临时目录
            File directory_tem = new File("");// 参数为空
            String courseFile = directory_tem.getCanonicalPath();
            // 项目根目录
            String systemPath = courseFile;
//            String systemPath = FileUtils.getTempDirectoryPath();

            // 合同临时保存路径
            String directoryName = systemPath.concat(File.separator).concat(pdfUrl.substring(0,pdfUrl.lastIndexOf(File.separator)+1));

            // 找到文件夹目录，如不存在就创建
            File directory = new File(directoryName);
            if (!directory.exists()) {
                directory.mkdirs();
                directory.setExecutable(true, false);
                directory.setReadable(true);
                directory.setWritable(true);
            }

            // 生成PDF合同至临时目录directoryName
            pdfUtil.generator(systemPath.concat(File.separator).concat(pdfUrl), pdf_templet, listJson);

            // 找到生成好的PDF文件
            FileInputStream inputStream = new FileInputStream(systemPath.concat(File.separator).concat(pdfUrl));

            // 上传至服务器
//            boolean flag = FtpOperation.uploadFile(pdfUrl, pdfName + ".pdf", inputStream, null);
            // 关闭流
            inputStream.close();
            // 删除文件
//            File deleteFile = new File(pdfUrl);
//            if (deleteFile.exists()) {
//                deleteFile.delete();
//            }
            // 删除目录
//            if (directory.exists()) {
//                directory.deleteOnExit();
//            }
//            if (!flag) {
//                jsonResult.put(MsgConsts.RESPONSE_CODE, MsgConsts.ERROR_CODE);
//                jsonResult.put(MsgConsts.RESPONSE_INFO, "合同生成失败");
//            } else {
//                logger.warn("上传至FTP说明：" + "-----合同已上传至ftp!");
//                jsonResult.put(MsgConsts.RESPONSE_CODE, MsgConsts.SUCCESS_CODE);
//                jsonResult.put(MsgConsts.RESPONSE_INFO, MsgConsts.SUCCESS_INFO);
//            }
        } catch (Exception e) {
//            jsonResult.put(MsgConsts.RESPONSE_CODE, MsgConsts.ERROR_CODE);
//            jsonResult.put(MsgConsts.RESPONSE_INFO, MsgConsts.ERROR_INFO);
            logger.warn(e.getMessage(), e);
            e.printStackTrace();
        }
        return jsonResult.toString();
    }
}
