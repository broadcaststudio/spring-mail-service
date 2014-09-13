package broadcaststudio.spring.services.mail.test;

import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

import com.icegreen.greenmail.util.GreenMail;
import com.icegreen.greenmail.util.ServerSetup;

/**
 * JUnit rule to reuse the GreenMail configuration that implements for testing.
 * 
 * @author sandornemeth
 * @since 0.0.1
 */
public class GreenMailRule implements TestRule {

  private static final int SMTP_TEST_PORT = 3025;

  private GreenMail greenMail;

  public GreenMail getGreenMail() {
    return greenMail;
  }

  @Override
  public Statement apply(final Statement base, final Description description) {
    return new Statement() {

      @Override
      public void evaluate() throws Throwable {
        greenMail = new GreenMail(new ServerSetup(SMTP_TEST_PORT, null, "smtp"));
        greenMail.start();
        try {
          base.evaluate();
        } finally {
          greenMail.stop();
        }
      }
    };
  }

}
