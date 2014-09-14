package broadcaststudio.spring.services.mail;

import javax.servlet.http.HttpServletRequest;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import broadcaststudio.spring.services.mail.model.SimpleMailCommand;

/**
 * A controller class that is accepting the requests coming to the service.
 * 
 * @author sandornemeth
 * @since 0.0.1
 */
@RestController
@Slf4j
public class MailController {

  private static final String RESULT_OK = "OK";

  @Autowired
  private MailService service;

  @RequestMapping(value = "/mail/send/simple", method = RequestMethod.POST)
  public String sendSimpleMail(@RequestBody SimpleMailCommand simpleMailCommand) {
    log.info("Sending email {}", new Object[] {simpleMailCommand.toString()});
    service.sendSimpleMail(simpleMailCommand);
    return RESULT_OK;
  }
  
  @ExceptionHandler(MailException.class)
  public ResponseEntity<Void> handleMailError(HttpServletRequest req, Exception exception) {
    log.error(exception.getLocalizedMessage(), exception);
    return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
  }

}
