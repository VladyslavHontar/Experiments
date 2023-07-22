import org.junit.jupiter.api.Test;

import java.time.*;

public class DateTimeApiTest {
  @Test
  void name() {
    LocalDate localDate = LocalDate.now();
    System.out.println(localDate);

    LocalTime localTime = LocalTime.now();
    localTime = localTime.plusHours(19);
    System.out.println(localTime);

    LocalDateTime localDateTime = LocalDateTime.now();
    localDateTime = localDateTime.plusDays(2).plusHours(23);
    System.out.println(localDateTime);

    ZonedDateTime zonedDateTime = ZonedDateTime.now();
    System.out.println(zonedDateTime);

    System.out.println(Duration.between(LocalDateTime.of(2010, 1, 1, 0, 0, 0), LocalDateTime.now()).toDays());

    Instant instant = Instant.now();
    System.out.println(instant);
  }
}
