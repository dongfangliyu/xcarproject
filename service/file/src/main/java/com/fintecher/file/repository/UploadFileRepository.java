package com.fintecher.file.repository;

import com.fintecher.common.entity.file.UploadFile;
import org.springframework.data.mongodb.repository.MongoRepository;


/**
 * @Author: jwdstef
 * @Description:
 * @Date 2017/12/4
 */
public interface UploadFileRepository extends MongoRepository<UploadFile, String> {
}
