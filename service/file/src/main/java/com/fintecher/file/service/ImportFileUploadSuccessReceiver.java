package com.fintecher.file.service;

import com.fintecher.common.entity.message.ImportFileUploadSuccessMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.io.ByteArrayInputStream;

/**
 * @Author: jwdstef
 * @Description: 接受文件上传成功队列消息
 * @Date 2017/12/4
 */
@Component
//@RabbitListener(queues = "mr.cui.file.import.upload.success")
public class ImportFileUploadSuccessReceiver {

    private final Logger logger = LoggerFactory.getLogger(ImportFileUploadSuccessReceiver.class);

    @Autowired
    private UploadFileCridFsService uploadFileCridFsService;

//    @RabbitHandler
//    public void receive(ImportFileUploadSuccessMessage message) {
//        try {
//            logger.debug("收到解压文件消息 {}", message);
//            HttpHeaders headers = new HttpHeaders();
//            RestTemplate restTemplate = new RestTemplate();
//            ResponseEntity<byte[]> response = restTemplate.exchange(message.getUploadFile().getUrl(),
//                    HttpMethod.GET, new HttpEntity<byte[]>(headers),
//                    byte[].class);
//            uploadFileCridFsService.uploadCaseFileReduce(new ByteArrayInputStream(response.getBody()), message.getUserId(), message.getUserName(), message.getBatchNum(), message.getCompanyCode());
//
//        } catch (Exception e) {
//            logger.error(e.getMessage(), e);
//        }
//    }
}
