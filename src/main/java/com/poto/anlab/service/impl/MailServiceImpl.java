package com.poto.anlab.service.impl;

import com.google.common.collect.Lists;
import com.poto.anlab.model.Category;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.List;

@Service
public class MailServiceImpl implements com.poto.anlab.service.MailService {
    @Autowired
    JavaMailSender mailSender;

    @Autowired
    private TemplateEngine templateEngine;

    @Value("${mail.address.from}")
    private String emailFrom;

    private final static Logger logger = LoggerFactory.getLogger(MailServiceImpl.class);


    public void sendTemplateMail(){
        logger.debug("-----------------------------------------------__________________________+++++++++++++++++++++++++++++++" + (new Date()));
        //创建邮件正文
        //是导这个包import org.thymeleaf.context.Context;
        Context context = new Context();
        List<Category> categoryList = Lists.newArrayList();

        Category category1 = new Category();
        category1.setId(1);
        category1.setCnName("caName");
        category1.setEnName("enname");

        Category category2 = new Category();
        category2.setId(2);
        category2.setCnName("caName");
        category2.setEnName("enname");

        categoryList.add(category1);
        categoryList.add(category2);

        context.setVariable("categories",categoryList);
        //获取thymeleaf的html模板
        String emailContent= templateEngine.process("emailTemplate", context);
        sendMail2(emailFrom,"yanhui.zhang@potosci.com","这是thymeleaf模板邮件",emailContent);
    }

    public void sendMail2(String from,String to,String subject,String content){
        MimeMessage message=mailSender.createMimeMessage();
        try {
            //true表示需要创建一个multipart message
            MimeMessageHelper helper=new MimeMessageHelper(message,true);
            helper.setFrom(from);
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(content,true);
            mailSender.send(message);
            System.out.println("html格式邮件发送成功");
        }catch (Exception e){
            System.out.println("html格式邮件发送失败");
        }
    }



    @Override
    public void sendHtmlEmail(String deliver, String[] receiver, String[] carbonCopy, String subject, String content, boolean isHtml){
        long startTimestamp = System.currentTimeMillis();


           /* MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper messageHelper = new MimeMessageHelper(message);

            messageHelper.setFrom(deliver);
            messageHelper.setTo(receiver);
            messageHelper.setCc(carbonCopy);
            messageHelper.setSubject(subject);
            messageHelper.setText(content, isHtml);

            mailSender.send(message);*/
            //建立邮件消息
            SimpleMailMessage mainMessage = new SimpleMailMessage();
            //发送者
            mainMessage.setFrom("zhangyanhui5@126.com");
            //接收者
            mainMessage.setTo("yanhui.zhang@potosci.com");
            //发送的标题
            mainMessage.setSubject("嗨喽");
            //发送的内容
            mainMessage.setText("hello world");
            mailSender.send(mainMessage);
           // return "1";


    }

}
