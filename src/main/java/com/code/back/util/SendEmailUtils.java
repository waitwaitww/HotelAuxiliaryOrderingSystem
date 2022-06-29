package com.code.back.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class SendEmailUtils {

    @Autowired
    private  JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    private  String from;

    public  String sentEmail(String email){
        String code = RandomUtil.randomNumbers(6); // 随机一个 4位长度的验证码
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from);
        message.setSubject("小笼包酒店辅助订购系统");
        message.setText("本次邮箱验证码为："+code);
        message.setTo(email);
        javaMailSender.send(message);
        return code;
    }
}
