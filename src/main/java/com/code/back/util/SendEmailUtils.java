package com.code.back.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

public class SendEmailUtils {

    @Autowired
    private static JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    private static String from;

    public static String sentEmail(String email){
        String code = RandomUtil.randomNumbers(4); // 随机一个 4位长度的验证码
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from);
        message.setSubject(code);
        message.setText("测试内容");
        message.setTo(email);
        javaMailSender.send(message);
        return code;
    }
}
