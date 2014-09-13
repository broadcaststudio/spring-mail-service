package broadcaststudio.spring.services.mail;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import broadcaststudio.spring.services.mail.test.GreenMailRule;

/**
 * Integration test for email sending.
 * 
 * @author sandornemeth
 * @since 0.0.1
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {MailServiceConfiguration.class})
@ActiveProfiles("test")
@WebAppConfiguration
public class MailServiceIntegrationTest {

  @Rule
  public GreenMailRule greenMail = new GreenMailRule();

  @Test
  public void empty() {
    System.out.println("during testing");
  }
}
