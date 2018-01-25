package ru.itpark.app.services;

public interface EmailService {
  void sendMail(String email, String subject, String text);
}
