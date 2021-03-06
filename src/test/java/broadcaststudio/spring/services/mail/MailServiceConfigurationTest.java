package broadcaststudio.spring.services.mail;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import broadcaststudio.spring.services.mail.configuration.SMTPConfiguration;
import broadcaststudio.spring.services.mail.test.GreenMailRule;

/**
 * Testing the application configuraiton.
 * 
 * @author sandornemeth
 * @since 0.0.1
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {MailServiceConfiguration.class})
@ActiveProfiles("test")
@IntegrationTest
public class MailServiceConfigurationTest {

  @Autowired
  private ApplicationContext appContext;

  @Test
  public void configurationGetsUpAndRunning() {
  }
  
  @Test public void testSMTPConfigurationLoading() {
    SMTPConfiguration smtp = appContext.getBean(SMTPConfiguration.class);
    assertThat(smtp, notNullValue());
    
    assertThat(smtp.getHost(), is("localhost"));
    assertThat(smtp.getPort(), is(GreenMailRule.SMTP_TEST_PORT));
    assertThat(smtp.getProtocol(), is("smtp"));
    assertThat(StringUtils.isBlank(smtp.getUsername()), is(true));
    assertThat(StringUtils.isBlank(smtp.getPassword()), is(true));
  }

}
