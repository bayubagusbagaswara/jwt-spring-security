package com.bayu.jwt.service.impl;

import com.bayu.jwt.model.Mail;
import com.bayu.jwt.service.MailService;
import org.springframework.stereotype.Service;

@Service
public class MailServiceImpl implements MailService {

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
