package com.fintecher.contract.config.auth;

import com.fintecher.contract.util.Constant;
import com.fintecher.util.ZWStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.stereotype.Component;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * 通过Redis存储和验证token的实现类
 * @author jwdstef
 * @date 2017/7/31.
 */
@Component("tokenManager")
public class RedisTokenManager implements TokenManager {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    public void setRedis(StringRedisTemplate redis) {
        this.stringRedisTemplate = redis;
        //泛型设置成Long后必须更改对应的序列化方案
        redis.setKeySerializer(new JdkSerializationRedisSerializer());
    }

//    public TokenModel createToken(long userId) {
//        //使用uuid作为源token
//        String token = UUID.randomUUID().toString().replace("-", "");
//        TokenModel model = new TokenModel(userId, token);
//        //存储到redis并设置过期时间
//        stringRedisTemplate.boundValueOps(String.valueOf(userId)).set(token, Constant.TOKEN_EXPIRES_HOUR, TimeUnit.HOURS);
//        return model;
//    }

    public String createToken(long userId) {
        String token = "";
        String tk = stringRedisTemplate.boundValueOps(String.valueOf(userId)).get();
        if(ZWStringUtils.isNotEmpty(tk)){
            token = tk;
        }else{
            token = UUID.randomUUID().toString().replace("-", "");
        }
        String valiToken = String.format("%s_%s",userId,token);
        //存储到redis并设置过期时间
        stringRedisTemplate.boundValueOps(String.valueOf(userId)).set(token, Constant.TOKEN_EXPIRES_HOUR, TimeUnit.HOURS);
        return valiToken;
    }

    public TokenModel getToken(String authentication) {
        if(StringUtils.isEmpty(authentication)){
            return null;
        }
        String[] param = authentication.split("_");
        if (param.length != 2) {
            return null;
        }
        //使用userId和源token简单拼接成的token，可以增加加密措施
        long userId = Long.parseLong(param[0]);
        String token = param[1];
        return new TokenModel(userId, token);
    }

    public boolean checkToken(TokenModel model) {
        if (model == null) {
            return false;
        }
        String token = stringRedisTemplate.boundValueOps(String.valueOf(model.getUserId())).get();
        if (token == null || !token.equals(model.getToken())) {
        //if (token == null) {
                return false;
        }
        //如果验证成功，说明此用户进行了一次有效操作，延长token的过期时间
        stringRedisTemplate.boundValueOps(String.valueOf(model.getUserId())).expire(Constant.TOKEN_EXPIRES_HOUR, TimeUnit.HOURS);
        return true;
    }

    public void deleteToken(long userId) {
        stringRedisTemplate.delete(String.valueOf(userId));
    }
}
