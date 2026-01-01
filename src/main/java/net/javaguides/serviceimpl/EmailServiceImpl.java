package net.javaguides.serviceimpl;

import net.javaguides.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class EmailServiceImpl implements EmailService {

    @Autowired
    private JavaMailSender mailSender;

    @Value("${spring.mail.username}")
    private String fromEmail;

    @Override
    public void sendTeacherWelcomeMail(String toEmail, String teacherName, String subject) {

        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);

            helper.setFrom(fromEmail);
            helper.setTo(toEmail);
            helper.setSubject("🎉 Welcome to School Portal");

            String htmlContent =
                    "<div style='font-family: Arial, sans-serif; background-color:#f4f6f8; padding:20px;'>"
                  + "  <div style='max-width:600px; margin:auto; background:#ffffff; padding:20px; border-radius:8px;'>"
                  + "    <h2 style='color:#2c3e50;'>Hello " + teacherName + " 👋</h2>"
                  + "    <p style='font-size:14px; color:#333;'>"
                  + "      You have been <b>successfully registered</b> in our School Portal."
                  + "    </p>"
                  + "    <p style='font-size:14px; color:#333;'>"
                  + "      <b>Subject Assigned:</b> "
                  + "      <span style='color:#27ae60;'>" + subject + "</span>"
                  + "    </p>"
                  + "    <hr>"
                  + "    <p style='font-size:12px; color:#777;'>"
                  + "      Regards,<br><b>School Admin</b>"
                  + "    </p>"
                  + "  </div>"
                  + "</div>";

            helper.setText(htmlContent, true); // true = HTML

            mailSender.send(message);
            System.out.println("✅ HTML Email sent successfully to: " + toEmail);

        } catch (MessagingException e) {
            System.out.println("❌ Error while sending email");
            e.printStackTrace();
        }
    }
}


//package net.javaguides.serviceimpl;
//
//import net.javaguides.service.EmailService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.mail.SimpleMailMessage;
//import org.springframework.mail.javamail.JavaMailSender;
//import org.springframework.stereotype.Service;
//import org.springframework.beans.factory.annotation.Value;
//
//@Service
//public class EmailServiceImpl implements EmailService {
//
//    @Autowired
//    private JavaMailSender mailSender;
//    
//
//    @Value("${spring.mail.username}")
//    private String fromEmail;
//
//    @Override
//    public void sendTeacherWelcomeMail(String toEmail, String teacherName, String subject) {
//
//        SimpleMailMessage message = new SimpleMailMessage();
//        message.setFrom(fromEmail);   // ⭐ IMPORTANT
//        message.setTo(toEmail);
//        message.setSubject("Welcome to School Portal");
//        message.setText(
//                "Hello " + teacherName + ",\n\n" +
//                "You have been successfully registered.\n" +
//                "Subject Assigned: " + subject + "\n\n" +
//                "Regards,\nSchool Admin"
//        );
//
//        mailSender.send(message);
//        System.out.println("✅ Email sent successfully to: " + toEmail);
//    }
//}
//
