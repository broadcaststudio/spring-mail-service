package broadcaststudio.spring.services.mail.model;

import java.io.Serializable;

import lombok.Data;
import lombok.ToString;

/**
 * Represents a simple "Send this content from this person to that address with this subject"
 * command sent to the service.
 * 
 * @author sandornemeth
 * @since 0.0.1
 */
@SuppressWarnings("serial")
@Data
@ToString
public class SimpleMailCommand implements Serializable {

  private String from;

  private String to;

  private String subject;

  private String body;

}
