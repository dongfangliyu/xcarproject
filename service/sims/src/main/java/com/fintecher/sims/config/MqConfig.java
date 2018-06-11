package com.fintecher.sims.config;

import com.fintecher.sims.config.cache.Receiver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.listener.PatternTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;

import java.util.concurrent.CountDownLatch;

/**
 * @Author: jwdstef
 * @Description: redis队列配置类(看你用不用redis队列了)
 * @Date 2017/6/12
 */
@Configuration
public class MqConfig {

    @Autowired
    private JedisConnectionFactory jedisConnectionFactory;

    /**********************mq注入开始*********************/
    @Bean
    Receiver receiver(CountDownLatch latch) {
        return new Receiver(latch);
    }

    @Bean
    CountDownLatch latch() {
        return new CountDownLatch(1);
    }


    @Bean
    StringRedisTemplate template() {
        return new StringRedisTemplate(jedisConnectionFactory);
    }

    @Bean
    RedisMessageListenerContainer container(MessageListenerAdapter listenerAdapter) {

        RedisMessageListenerContainer container = new RedisMessageListenerContainer();
        container.setConnectionFactory(jedisConnectionFactory);
        container.addMessageListener(listenerAdapter, new PatternTopic("chat"));
        return container;
    }

    @Bean
    MessageListenerAdapter listenerAdapter(Receiver receiver) {
        return new MessageListenerAdapter(receiver, "receiveMessage");
    }

    /**********************mq注入结束*********************/
}
