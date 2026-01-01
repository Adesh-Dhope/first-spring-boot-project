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

    // 🔹 CORE REUSABLE METHOD
    @Override
    public void sendHtmlEmail(String to, String subject, String htmlBody) {

        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);

            helper.setFrom(fromEmail);
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(htmlBody, true); // HTML enabled

            mailSender.send(message);
            System.out.println("✅ Email sent to: " + to);

        } catch (MessagingException e) {
            System.out.println("❌ Failed to send email to: " + to);
            e.printStackTrace();
        }
    }

    // 🔹 EMPLOYEE WELCOME MAIL
    @Override
    public void sendEmployeeWelcomeMail(String toEmail, String employeeName) {

        String subject = "🎉 Welcome to Company Portal";

        String htmlContent =
                "<div style='font-family: Arial, sans-serif; background:#f4f6f8; padding:20px;'>"
              + "  <div style='max-width:600px; margin:auto; background:#ffffff; padding:20px; border-radius:8px;'>"
              + "    <h2 style='color:#2c3e50;'>Hello " + employeeName + " 👋</h2>"
              + "    <p style='font-size:14px; color:#333;'>"
              + "      Your account has been <b>successfully created</b>."
              + "    </p>"
              + "    <p style='font-size:14px; color:#333;'>"
              + "      You can now login and start using the portal."
              + "    </p>"
              + "    <hr>"
              + "    <p style='font-size:12px; color:#777;'>"
              + "      Regards,<br><b>Admin Team</b>"
              + "    </p>"
              + "  </div>"
              + "</div>";

        sendHtmlEmail(toEmail, subject, htmlContent);
    }
    
    
    @Override
    public void sendLoginSuccessMail(String toEmail, String employeeName) {

        String subject = "🔐 Login Successful";

        String htmlContent =
                "<div style='font-family: Arial, sans-serif; background:#f4f6f8; padding:20px;'>"
              + "  <div style='max-width:600px; margin:auto; background:#ffffff; padding:20px; border-radius:8px;'>"
              + "    <h2 style='color:#2c3e50;'>Hello " + employeeName + " 👋</h2>"
              + "    <p style='font-size:14px; color:#333;'>"
              + "      You have <b>successfully logged in</b> to your account."
              + "    </p>"
              + "    <p style='font-size:14px; color:#333;'>"
              + "      If this was not you, please reset your password immediately."
              + "    </p>"
              + "    <hr>"
              + "    <p style='font-size:12px; color:#777;'>"
              + "      Regards,<br><b>Security Team</b>"
              + "    </p>"
              + "  </div>"
              + "</div>";

        sendHtmlEmail(toEmail, subject, htmlContent);
    }

}


//package net.javaguides.serviceimpl;
//
//import net.javaguides.service.EmailService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.mail.javamail.JavaMailSender;
//import org.springframework.mail.javamail.MimeMessageHelper;
//import org.springframework.stereotype.Service;
//
//import jakarta.mail.MessagingException;
//import jakarta.mail.internet.MimeMessage;
//
//@Service
//public class EmailServiceImpl implements EmailService {
//
//    @Autowired
//    private JavaMailSender mailSender;
//
//    @Value("${spring.mail.username}")
//    private String fromEmail;
//
//    @Override
//    public void sendTeacherWelcomeMail(String toEmail, String teacherName, String subject) {
//
//        try {
//            MimeMessage message = mailSender.createMimeMessage();
//            MimeMessageHelper helper = new MimeMessageHelper(message, true);
//
//            helper.setFrom(fromEmail);
//            helper.setTo(toEmail);
//            helper.setSubject("🎉 Welcome to School Portal");
//
//            String htmlContent =
//                    "<div style='font-family: Arial, sans-serif; background-color:#f4f6f8; padding:20px;'>"
//                  + "  <div style='max-width:600px; margin:auto; background:#ffffff; padding:20px; border-radius:8px;'>"
//                  + "    <h2 style='color:#2c3e50;'>Hello " + teacherName + " 👋</h2>"
//                  + "    <p style='font-size:14px; color:#333;'>"
//                  + "      You have been <b>successfully registered</b> in our School Portal."
//                  + "    </p>"
//                  + "    <p style='font-size:14px; color:#333;'>"
//                  + "      <b>Subject Assigned:</b> "
//                  + "      <span style='color:#27ae60;'>" + subject + "</span>"
//                  + "    </p>"
//                  + "    <hr>"
//                  + "    <p style='font-size:12px; color:#777;'>"
//                  + "      Regards,<br><b>School Admin</b>"
//                  + "    </p>"
//                  + "  </div>"
//                  + "</div>";
//
//            helper.setText(htmlContent, true); // true = HTML
//
//            mailSender.send(message);
//            System.out.println("✅ HTML Email sent successfully to: " + toEmail);
//
//        } catch (MessagingException e) {
//            System.out.println("❌ Error while sending email");
//            e.printStackTrace();
//        }
//    }
//}
//
