package ru.itpark.app.services;

import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.internet.MimeMessage;

@Component
public class EmailServiceImpl implements EmailService {

  @Autowired
  private JavaMailSender javaMailSender;

  @Override
  @SneakyThrows
  public void sendMail(String email, String subject, String text) {
    MimeMessage message = javaMailSender.createMimeMessage();

    message.setContent(text, "text/html");
    MimeMessageHelper messageHelper = new MimeMessageHelper(message, true);
    messageHelper.setTo(email);
    messageHelper.setSubject(subject);
    messageHelper.setText(text, true);

    javaMailSender.send(message);
  }
}
