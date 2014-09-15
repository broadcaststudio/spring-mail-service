package broadcaststudio.spring.services.mail.configuration;

import lombok.Getter;
import lombok.Setter;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Configuration holder to provide a place where properties can be auto-loaded by Spring using
 * {@link ConfigurationProperties}.
 * 
 * @author sandornemeth
 * @since 1.0.0
 */
@Component
@ConfigurationProperties(prefix = "spring.services.mail")
@Getter 
@Setter
public class SMTPConfiguration {

  private String host;
  private int port;
  private String protocol;
  private String username;
  private String password;
  
}
