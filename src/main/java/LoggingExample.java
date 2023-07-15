import java.util.logging.Level;
import java.util.logging.Logger;

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
public class LoggingExample {
  /**
   *    . (root logger)
   *    LoggingExample    // package.class name  (cause my class is located in java folder, I gave no package)
   *
   *
   */
  private static final Logger log = Logger.getLogger("LoggingExample");

  public static void main(String[] args) {
    Logger logger = null;

    User user = User.builder()
                    .id(42)
                    .type(User.Type.ADMIN)
                    .username("adm_username")
                    .password("pwd")
                    .build();
      logger.log(Level.INFO, "User successfully passed validation " + user.getId() + " " + user.getUsername());
  }
}
