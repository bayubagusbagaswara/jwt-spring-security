package com.bayu.jwt.service;

import com.bayu.jwt.model.Mail;
import freemarker.template.TemplateException;

import java.io.IOException;

public interface MailService {

    public void sendEmailVerification(String emailVerificationUrl, String to) throws IOException, TemplateException;

    public void sendResetLink(String resetPasswordLink, String to);

    public void sendAccountChangeEmail(String action, String actionStatus, String to);

    public void send(Mail mail);

}
