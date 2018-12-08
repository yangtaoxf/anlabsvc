package com.poto.anlab.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
public class MailServiceImpl {
    @Autowired
    JavaMailSender mailSender;

    public void sendHtmlEmail(String deliver, String[] receiver, String[] carbonCopy, String subject, String content, boolean isHtml) throws ServiceException {
        long startTimestamp = System.currentTimeMillis();
        logger.info("Start send email ...");

        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper messageHelper = new MimeMessageHelper(message);

            messageHelper.setFrom(deliver);
            messageHelper.setTo(receiver);
            messageHelper.setCc(carbonCopy);
            messageHelper.setSubject(subject);
            messageHelper.setText(content, isHtml);

            mailSender.send(message);
            logger.info("Send email success, cost {} million seconds", System.currentTimeMillis() - startTimestamp);
        } catch (MessagingException e) {
            logger.error("Send email failed, error message is {} \n", e.getMessage());
            e.printStackTrace();
            throw new ServiceException(e.getMessage());
        }
    }

}
