package broadcaststudio.spring.services.mail;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * The main Spring configuration class of the service.
 * 
 * @author sandornemeth
 * @since 0.0.1
 */
@Configuration
@EnableAutoConfiguration
@ComponentScan
public class MailServiceConfiguration {

  public static void main(String[] args) {
    SpringApplication.run(MailServiceConfiguration.class, args);
  }
  
}
