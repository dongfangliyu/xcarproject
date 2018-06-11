package com.fintecher.message;

import com.fintecher.util.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Queue;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.Environment;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @Author: jwdstef
 * @Description:
 * @Date 2017/12/11
 */
@ComponentScan
@EnableFeignClients
@EnableEurekaClient
//开启断路器装配
@EnableCircuitBreaker
@EnableDiscoveryClient
@EnableWebSocket
//@EntityScan("com.fintecher.pangloin.dataimp.entity.*")
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class, HibernateJpaAutoConfiguration.class})
public class MessageApplication extends SpringBootServletInitializer {
    private static final Logger log = LoggerFactory.getLogger(MessageApplication.class);


    @Bean
    public Queue unReduceProgressQueue() {
        return new Queue("mr.cui.file.unReduce.progress");
    }

    @Bean
    public Queue checkAreaProgressQueue() {
        return new Queue("mr.cui.data.area.progress");
    }

    @Bean
    public Queue exportFollowupRecordQueue() {return new Queue(Constants.FOLLOWUP_EXPORT_QE);}

    @Bean
    public Queue exportOutsourceFollowupRecordQueue() {return new Queue(Constants.FOLLOWUP_OUTSOURCE_EXPORT_QE);}

    public static void main(String[] args) throws UnknownHostException {
        SpringApplication app = new SpringApplication(MessageApplication.class);
        ApplicationContext applicationContext =app.run(args);
        Environment env = applicationContext.getEnvironment();
        log.info("\n----------------------------------------------------------\n\t" +
                        "Application '{}' is running! Access URLs:\n\t" +
                        "Local: \t\thttp://localhost:{}\n\t" +
                        "External: \thttp://{}:{}\n\t" +
                        "SwaggerUI: \thttp://localhost:{}/swagger-ui.html\n" +
                        "----------------------------------------------------------",
                env.getProperty("spring.application.name"),
                env.getProperty("server.port"),
                InetAddress.getLocalHost().getHostAddress(),
                env.getProperty("server.port"),
                env.getProperty("server.port"));
    }


    @Bean
    public ServerEndpointExporter serverEndpointExporter() {
        return new ServerEndpointExporter();
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(MessageApplication.class);
    }

}
