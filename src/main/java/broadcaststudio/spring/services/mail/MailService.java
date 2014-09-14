package broadcaststudio.spring.services.mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

import broadcaststudio.spring.services.mail.model.SimpleMailCommand;

/**
 * Service for sending emails.
 * 
 * @author sandornemeth
 * @since 0.0.1
 */
@Service
public class MailService {

  @Autowired
  private MailSender sender;


  public void sendSimpleMail(SimpleMailCommand command) {
    SimpleMailMessage message = new SimpleMailMessage();
    message.setFrom(command.getFrom());
    message.setTo(command.getTo());
    message.setSubject(command.getSubject());
    message.setText(command.getBody());
    sender.send(message);
  }

}
