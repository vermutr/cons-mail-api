package com.cons.mail.consmailapi.service.mail;

import com.cons.mail.consmailapi.model.MailMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MailServiceImpl implements MailService {

    private static final String OFFER_REQUEST_SUBJECT = "Offer request from Verrom application!";

    @Value("${spring.mail.username}")
    private String fromEmail;

    private final JavaMailSender emailSender;


    @Override
    public void sendMail(final MailMessage mail) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(fromEmail);
        message.setTo(mail.getMailTo());
        message.setSubject(OFFER_REQUEST_SUBJECT);
        message.setText(prepareMessage(mail));
        emailSender.send(message);
    }

    private String prepareMessage(final MailMessage message) {
        return "You need to contact with person via mail (" + message.getMailFrom() + "). \n" +
                "Reason: \n" + message.getOfferTitle() + " - " + message.getOfferDescription();
    }

}
