package net.javaguides.service;

public interface EmailService {

    void sendHtmlEmail(String to, String subject, String htmlBody);

    void sendEmployeeWelcomeMail(String toEmail, String employeeName);
    
    void sendLoginSuccessMail(String toEmail, String employeeName);

}


//package net.javaguides.service;
//
//public interface EmailService {
//    void sendTeacherWelcomeMail(String toEmail, String teacherName, String subject);
//}

