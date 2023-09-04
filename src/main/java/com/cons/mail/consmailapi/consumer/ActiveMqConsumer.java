package com.cons.mail.consmailapi.consumer;

import com.cons.mail.consmailapi.model.MailMessage;
import com.cons.mail.consmailapi.service.mail.MailService;
import lombok.RequiredArgsConstructor;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ActiveMqConsumer {

    private final MailService mailService;


    @JmsListener(destination = "${activemq.mail.queue}", containerFactory = "activeMqJmsListenerContainerFactory")
    public void messageListener(MailMessage mailMessage) {
        mailService.sendMail(mailMessage);
    }

}
