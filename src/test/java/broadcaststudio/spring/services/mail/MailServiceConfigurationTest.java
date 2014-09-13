package broadcaststudio.spring.services.mail;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Testing the application configuraiton.
 * 
 * @author sandornemeth
 * @since 0.0.1
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {MailServiceConfiguration.class})
public class MailServiceConfigurationTest {

  @Test public void configurationGetsUpAndRunning() {
    
  }
  
}
