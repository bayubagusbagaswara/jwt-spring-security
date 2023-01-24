package com.bayu.jwt.service.impl;

import com.bayu.jwt.model.Mail;
import com.bayu.jwt.service.MailService;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import java.io.IOException;

@Service
public class MailServiceImpl implements MailService {

    private final JavaMailSender mailSender;

    private final Configuration templateConfiguration;

    @Value("${app.velocity.templates.location}")
    private String basePackagePath;

    @Value("${spring.email.username}")
    private String mailFrom;

    @Value("${app.token.password.reset.duration}")
    private Long expiration;

    @Autowired
    public MailServiceImpl(JavaMailSender mailSender, Configuration templateConfiguration) {
        this.mailSender = mailSender;
        this.templateConfiguration = templateConfiguration;
    }

    @Override
    public void sendEmailVerification(String emailVerificationUrl, String to) throws IOException, TemplateException {

        Mail mail = new Mail();
        mail.setSubject("Email Verification [Team CEP]");
        mail.setTo(to);
        mail.setFrom(mailFrom);
        mail.getModel().put("userName", to);
        mail.getModel().put("userEmailTokenVerificationLink", emailVerificationUrl);

        templateConfiguration.setClassForTemplateLoading(getClass(), basePackagePath);
        Template template = templateConfiguration.getTemplate("email-verification.ftl");
        String mailContent = FreeMarkerTemplateUtils.processTemplateIntoString(template, mail.getModel());
        mail.setContent(mailContent);
        send(mail);
    }

    @Override
    public void sendResetLink(String resetPasswordLink, String to) {

    }

    @Override
    public void sendAccountChangeEmail(String action, String actionStatus, String to) {

    }

    @Override
    public void send(Mail mail) {

    }
}
