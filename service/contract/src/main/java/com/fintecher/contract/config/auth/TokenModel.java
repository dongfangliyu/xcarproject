package com.fintecher.contract.config.auth;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: jwdstef
 * @Description: Token的Model类，可以增加字段提高安全性，例如时间戳、url签名
 * @Date 2017/5/31
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class TokenModel implements java.io.Serializable {

    //用户id
    private long userId;

    //随机生成的uuid
    private String token;

}
