package com.fintecher.file.service.impl;

import com.fintecher.common.entity.file.UploadFile;
import com.fintecher.common.entity.message.ProgressMessage;
import com.fintecher.common.entity.message.UnReduceFileMessage;
import com.fintecher.file.repository.UploadFileRepository;
import com.fintecher.file.service.UploadFileCridFsService;
import com.fintecher.util.ShortUUID;
import com.fintecher.util.UnReduceFile;
import com.fintecher.util.ZWDateUtil;
import com.mongodb.gridfs.GridFSDBFile;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsCriteria;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.List;
import java.util.Objects;

/**
 * @Author: jwdstef
 * @Description: GridFS文件服务器
 * @Date 2017/12/4
 */
@Service("uploadFileCridFsServiceImpl")
public class UploadFileCridFsServiceImpl implements UploadFileCridFsService {
    private final Logger logger = LoggerFactory.getLogger(UploadFileCridFsServiceImpl.class);

    @Value("${gridfs.path}")
    private String path;
    @Value("${gridfs.localPath}")
    private String localPath;

    @Autowired
    UploadFileRepository uploadFileRepository;


    @Autowired
    GridFsTemplate gridFsTemplate;

    @Autowired
    RabbitTemplate rabbitTemplate;

    /**
     *
     *
     *
     * 获取外网地址
     */
    private String getResAccessUrl(String fid) {
        String fileUrl = "http://".concat(path).concat("/fileUploadController/view/").concat(fid);
        return fileUrl;
    }

    /**
     * 获取内网地址
     */
    private String getLocalResAccessUrl(String fid) {
        String fileUrl = "http://".concat(localPath).concat("/fileUploadController/view/").concat(fid);
        return fileUrl;
    }

    @Override
    public UploadFile uploadFile(MultipartFile file) throws Exception {
        String realName =file.getOriginalFilename();
        if (realName.endsWith(".do")) {
            realName = realName.replaceAll(".do", "");
        }
        String originalFileName = file.getOriginalFilename();
        if (originalFileName.endsWith(".do")) {
            originalFileName = originalFileName.replaceAll(".do", "");
        }
        UploadFile uploadFile = uploadFile(file.getInputStream(), file.getSize(), realName, FilenameUtils.getExtension(originalFileName));
        gridFsTemplate.store(new ByteArrayInputStream(file.getBytes()), uploadFile.getId(), uploadFile.getType());
        return uploadFile;
    }

    private UploadFile uploadFile(InputStream inputStream, long fileSize, String fileName, String fileExtName) throws Exception {
        UploadFile uploadFile = new UploadFile();
        uploadFile.setCreateTime(ZWDateUtil.getNowDateTime());
        uploadFile.setRealName(fileName);
        uploadFile.setName(fileName);
        uploadFile.setType(fileExtName);
        //uploadFile.setCreator(creator);
        uploadFile.setSize(fileSize);
        uploadFile = uploadFileRepository.save(uploadFile);
        uploadFile.setLocalUrl(getLocalResAccessUrl(uploadFile.getId()));
        uploadFile.setUrl(getResAccessUrl(uploadFile.getId()));
        return uploadFileRepository.save(uploadFile);
    }

//    @Override
//    public void uploadCaseFileReduce(InputStream inputStream, String userId, String userName, String batchNum, String companyCode) throws Exception {
//        String targetTempFilePath = FileUtils.getTempDirectoryPath().concat(File.separator).concat(userName).
//                concat(File.separator).concat(ShortUUID.generateShortUuid()).concat(File.separator);
//
//        List<String> directoryList;
//        try {
//            directoryList = UnReduceFile.unZip(inputStream, targetTempFilePath, "GBK");
//        } catch (IOException e) {
//            logger.error(e.getMessage(), e);
//            return;
//        }
//        if (Objects.nonNull(directoryList)) {
//            int current = 0;
//            int total = 0;
//            for (String directoryName : directoryList) {
//                File file = FileUtils.getFile(targetTempFilePath, directoryName);
//                File[] array = file.listFiles();
//                total = total + array.length;
//            }
//            logger.info("文件总数:{}", total);
//            ProgressMessage progressMessage = new ProgressMessage();
//            progressMessage.setUserId(userId);
//            progressMessage.setCurrent(0);
//            progressMessage.setTotal(total);
//            progressMessage.setText("开始解压缩文件");
//            //上传文件进度
//            rabbitTemplate.convertAndSend("mr.cui.file.unReduce.progress", progressMessage);
//            for (String directoryName : directoryList) {
//                File file = FileUtils.getFile(targetTempFilePath, directoryName);
//                File[] array = file.listFiles();
//                for (File f : array) {
//                    try {
//                        if (f.isDirectory()) {
//                            continue;
//                        }
//                        InputStream in = new FileInputStream(f);
//                        UploadFile uploadFile = uploadFile(in, f.length(), FilenameUtils.getName(f.getName()),
//                                    FilenameUtils.getExtension(f.getName()));
//                        UnReduceFileMessage message = new UnReduceFileMessage();
//                        message.setCompanyCode(companyCode);
//                        message.setUserId(userId);
//                        message.setUploadFile(uploadFile);
//                        message.setBatchNum(batchNum);
//                        message.setPath(directoryName);
//                        current = current + 1;
//                        message.setCurrent(current);
//                        message.setTotal(total);
//                        logger.info("发送第 {} 个文件", current);
//                        rabbitTemplate.convertAndSend("mr.cui.file.unReduce.success", message);
//                        in.close();
//                    } catch (FileNotFoundException e) {
//                        logger.error(e.getMessage(), e);
//                    } catch (IOException e) {
//                        logger.error(e.getMessage(), e);
//                    }
//                }
//            }
//            try {
//                FileUtils.deleteDirectory(FileUtils.getFile(targetTempFilePath));
//            } catch (IOException e) {
//                logger.error(e.getMessage(), e);
//            }
//        }
//    }

    @Override
    public void removeFile(String id) {
        uploadFileRepository.delete(id);
        Query query = Query.query(GridFsCriteria.whereFilename().is(id));
        gridFsTemplate.delete(query);
    }

    @Override
    public UploadFile getFileById(String id) {
        return uploadFileRepository.findOne(id);
    }

    @Override
    public GridFSDBFile getFileContent(String id) {
        Query query = Query.query(GridFsCriteria.whereFilename().is(id));
        return gridFsTemplate.findOne(query);
    }
}
