package bad_java.experiments;

import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * log4g
 * JUL - java.util.logging Framework
 * JCL - Java Commons Logging API
 * SLF4j - Simple Logging Facade for Java
 * Logback
 * <p>
 *
 * log4j2:
 *  - logger
 *  - appender
 *  - layout
 *
 */
@Log4j2
public class LoggingExample {
  /**
   *    . (root logger)
   *    bad_java.experiments.LoggingExample
   * <p>
   *
   * LEVELS:
   *   - trace
   *   - debug
   *   - info
   *   - warn
   *   - error
   */
  private static final Logger log = LogManager.getLogger(LoggingExample.class);

  public static void main(String[] args) {
    Logger logger = null;

    User user = User.builder()
                    .id(42)
                    .type(User.Type.ADMIN)
                    .username("adm_username")
                    .password("pwd")
                    .build();

    log.trace("trace");
    log.debug("debug");
    log.info("info");
    log.warn("warn");
    log.error("error");

    //      logger.log(Level.INFO, "bad_java.experimets.User successfully passed validation " + user.getId() + " " + user.getUsername());
  }
}
