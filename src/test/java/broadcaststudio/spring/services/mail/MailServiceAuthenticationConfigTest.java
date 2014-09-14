package broadcaststudio.spring.services.mail;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

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

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {MailServiceConfiguration.class})
@ActiveProfiles("authtest")
@IntegrationTest
public class MailServiceAuthenticationConfigTest {

  @Autowired
  private ApplicationContext appContext;

  @Test
  public void testSMTPConfigurationLoading() {
    SMTPConfiguration smtp = appContext.getBean(SMTPConfiguration.class);
    assertThat(smtp, notNullValue());
    
    assertThat(smtp.getHost(), is("localhost"));
    assertThat(smtp.getPort(), is(GreenMailRule.SMTP_TEST_PORT));
    assertThat(smtp.getProtocol(), is("smtp"));
    assertThat(smtp.getUsername(), is("sample"));
    assertThat(smtp.getPassword(), is("sample"));
  }

}
