package com.code;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@SpringBootApplication
@MapperScan("com.code.back.mapper")
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Configuration
    public class MailConfiguration {
        @Bean
        public JavaMailSenderImpl JavaMailSender(){
            JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
            mailSender.setHost("smtp.163.com");
            mailSender.setUsername("yf_200108@163.com");
            mailSender.setPassword("CQYMEVJONDVIAMQU");
            mailSender.setPort(465);
            mailSender.setProtocol("smtps");
            mailSender.setDefaultEncoding("utf-8");
            return  mailSender;
        }
    }

}
