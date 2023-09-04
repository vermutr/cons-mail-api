package com.cons.mail.consmailapi.service.mail;

import com.cons.mail.consmailapi.model.MailMessage;

public interface MailService {

    void sendMail(final MailMessage mail);

}
