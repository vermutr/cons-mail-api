package com.cons.mail.consmailapi.converter;

import com.cons.mail.consmailapi.model.MailMessage;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.jms.JMSException;
import jakarta.jms.Message;
import jakarta.jms.Session;
import jakarta.jms.TextMessage;
import org.springframework.jms.support.converter.MessageConversionException;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.stereotype.Component;

@Component
public class MailMessageConverter implements MessageConverter {

    private static final ObjectMapper mapper = new ObjectMapper();


    @Override
    public Message toMessage(Object object, Session session) throws JMSException, MessageConversionException {
        return null;
    }

    @Override
    public Object fromMessage(Message message) throws JMSException, MessageConversionException {
        if (message instanceof TextMessage) {
            TextMessage textMessage = (TextMessage) message;
            try {
                return mapper.readValue(textMessage.getText(), MailMessage.class);
            } catch (JsonProcessingException e) {
                throw new MessageConversionException("Error converting JSON to MailMessage", e);
            }
        }
        throw new MessageConversionException("Message isn't a TextMessage");
    }

}
