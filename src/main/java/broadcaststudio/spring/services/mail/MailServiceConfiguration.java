package broadcaststudio.spring.services.mail;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.MailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import broadcaststudio.spring.services.mail.configuration.SMTPConfiguration;

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

  @Autowired
  private SMTPConfiguration smtpConfiguration;

  public static void main(String[] args) {
    SpringApplication.run(MailServiceConfiguration.class, args);
  }

  @Bean
  public MailSender mailSender() {
    JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
    mailSender.setHost(smtpConfiguration.getHost());
    mailSender.setPort(smtpConfiguration.getPort());
    mailSender.setProtocol(smtpConfiguration.getProtocol());
    if (!StringUtils.isBlank(smtpConfiguration.getUsername())) {
      mailSender.setUsername(smtpConfiguration.getUsername());
      mailSender.setPassword(smtpConfiguration.getPassword());
    }
    return mailSender;
  }
}
