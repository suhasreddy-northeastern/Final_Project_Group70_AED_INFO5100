package business.EmailAlert;

import business.Role.ResidentRole;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;
import java.util.Properties;

public class EmailAlert {

    // Email configuration
    private static final String USERNAME = "livingease.notificationalert@gmail.com";
    private static final String PASSWORD = "gais cjtg rntn htcz";
    private static final String SMTP_HOST = "smtp.gmail.com";
    private static final String SMTP_PORT = "587"; // TLS port for Gmail

    // Send an email notification when a maintenance request is closed
    public void sendMaintenanceRequestClosedEmail(ResidentRole residentRole, String facility) {
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", SMTP_HOST);
        props.put("mail.smtp.port", SMTP_PORT);

        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(USERNAME, PASSWORD);
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(USERNAME));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(residentRole.getUserAccount().getEmail())); // Send to the resident's email
            message.setSubject("Maintenance Request Closed for " + facility);

            String body = "Dear " + residentRole.getUserAccount().getUsername() + ",\n\n"
                    + "We are pleased to inform you that your maintenance request for " + facility + " has been successfully closed.\n\n"
                    + "If you need further assistance, feel free to contact us.\n\n"
                    + "Regards,\n"
                    + "Maintenance Team";
            message.setText(body);

            Transport.send(message);
            System.out.println("Maintenance request closed email sent to " + residentRole.getUserAccount().getEmail());

        } catch (MessagingException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    // Send email to the resident regarding lease status (approved or rejected)
    public void sendLeaseStatusEmail(String residentEmail, String subject, String bodyContent) {
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", SMTP_HOST);
        props.put("mail.smtp.port", SMTP_PORT);

        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(USERNAME, PASSWORD);
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(USERNAME));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(residentEmail)); // Resident's email
            message.setSubject(subject);

            message.setText(bodyContent);

            Transport.send(message);
            System.out.println("Lease status email sent to " + residentEmail);

        } catch (MessagingException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    // Send an email with login details when a new resident user is created
    public void sendUserCreatedEmail(ResidentRole residentRole, String username, String password) {
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", SMTP_HOST);
        props.put("mail.smtp.port", SMTP_PORT);

        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(USERNAME, PASSWORD);
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(USERNAME));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(residentRole.getUserAccount().getEmail())); // Resident's email from UserAccount
            message.setSubject("Welcome to Our Community");

            String body = "Dear " + residentRole.getUserAccount().getUsername() + ",\n\n"
                    + "Your account has been successfully created. Here are your login credentials:\n\n"
                    + "Username: " + username + "\n"
                    + "Password: " + password + "\n\n"
                    + "We look forward to having you as part of our community.\n\n"
                    + "Regards,\n"
                    + "Admin Team";
            message.setText(body);

            Transport.send(message);
            System.out.println("User account email sent to " + residentRole.getUserAccount().getEmail());

        } catch (MessagingException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
