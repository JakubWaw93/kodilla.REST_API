package com.crud.tasks.service;

import com.crud.tasks.domain.Mail;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessagePreparator;

import javax.mail.internet.MimeMessage;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class SimpleEmailServiceTest {

    @InjectMocks
    private SimpleEmailService service;

    @Mock
    private JavaMailSender javaMailSender;

    @Test
    void shouldSendEmail() {
        //Given
        Mail mail = Mail.builder()
                .mailTo("test@test.com")
                .subject("Test")
                .message("Test  message")
                .build();

        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setText(mail.getMessage());
        mailMessage.setSubject(mail.getSubject());
        mailMessage.setTo(mail.getMailTo());


        if (Optional.ofNullable(mail.getToCC()).isPresent()) {
            mailMessage.setCc(mail.getToCC());
        }

        //When
        MimeMessagePreparator message = service.createMimeMessage(mail);
        javaMailSender.send(message);

        //Then
        verify(javaMailSender, times(1)).send(message);
    }
}