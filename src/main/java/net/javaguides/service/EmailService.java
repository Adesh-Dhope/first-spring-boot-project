package net.javaguides.service;


public interface EmailService {
    void sendTeacherWelcomeMail(String toEmail, String teacherName, String subject);
}

