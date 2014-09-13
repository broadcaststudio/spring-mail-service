package broadcaststudio.spring.services.mail;

import java.io.Serializable;

import lombok.Data;

/**
 * A mail command is a DTO that the service receives with all the necessary parameters for sending
 * an email.
 * 
 * @author sandornemeth
 * @since 0.0.1
 */
@SuppressWarnings("serial")
@Data
public class MailCommand implements Serializable {

  private String from; 
  
  private String to;
  
  private String subject;
  
  private String body;
  
}
