package broadcaststudio.spring.services.mail;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.client.RestTemplate;

import broadcaststudio.spring.services.mail.model.SimpleMailCommand;
import broadcaststudio.spring.services.mail.test.GreenMailRule;

import com.icegreen.greenmail.util.GreenMailUtil;

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
@IntegrationTest({"server.port=0", "management.port=0"})
public class MailServiceIntegrationTest {

  static final String SIMPLE_MAIL_URL = "/mail/send/simple";
  static final String RESULT_OK = "OK";

  @Rule
  public GreenMailRule greenMail = new GreenMailRule();

  RestTemplate restTemplate = new TestRestTemplate();

  @Value("${local.server.port}")
  int port;

  @Test
  public void simpleMailSendingTest() {
    ResponseEntity<String> responseEntity =
        restTemplate.postForEntity(getServerUrl(SIMPLE_MAIL_URL), Fixtures.simpleMailCommand(),
            String.class);
    assertThat(responseEntity.getStatusCode(), is(HttpStatus.OK));
    assertThat(responseEntity.getBody(), is(RESULT_OK));
    
    assertThat(greenMail.getGreenMail().getReceivedMessages().length, is(1));
    
    String messageBody = GreenMailUtil.getBody(greenMail.getGreenMail().getReceivedMessages()[0]);
    assertThat(messageBody, is(Fixtures.SIMPLE_BODY));
  }

  private String getServerUrl(String path) {
    return new StringBuilder("http://localhost:").append(port).append(path).toString();
  }

  static class Fixtures {
    static final String FROM = "from@springservices.dev";
    static final String TO = "to@springservices.dev";
    static final String SUBJECT = "test subject";
    static final String SIMPLE_BODY = "Simple mail body";

    static HttpEntity<SimpleMailCommand> simpleMailCommand() {
      SimpleMailCommand command = new SimpleMailCommand();
      command.setFrom(FROM);
      command.setTo(TO);
      command.setSubject(SUBJECT);
      command.setBody(SIMPLE_BODY);
      return new HttpEntity<SimpleMailCommand>(command);
    }
  }
}
