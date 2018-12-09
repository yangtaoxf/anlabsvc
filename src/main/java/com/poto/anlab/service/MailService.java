package com.poto.anlab.service;

public interface MailService {
    void sendTemplateMail();
    void sendHtmlEmail(String deliver, String[] receiver, String[] carbonCopy, String subject, String content, boolean isHtml);
}
