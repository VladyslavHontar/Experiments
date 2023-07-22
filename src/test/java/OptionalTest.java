import lombok.AllArgsConstructor;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class OptionalTest {
  @Test
  void name() {
    Optional<Client> optionalClient = getUserByName("Ivan", "Ivanov");
    optionalClient.orElseThrow(() -> new IllegalArgumentException("User not found"));

  }
  private static Optional<Client> getUserByName(String name, String surname) {
    if ("Ivan".equals(name) && "Ivanov".equals(surname)) {
      Person ivan = new Person("Ivan", "Ivanov", 35);
      LocalDate localDate = LocalDate.now();
      License license = new License(localDate, localDate.plusMonths(6), "111", new ArrayList<>(List.of(ivan)));
      return Optional.of(new Client(ivan, license));
    }
    return Optional.empty();
  }

}
@AllArgsConstructor
class Client {
  Person person;
  License license;
}
@AllArgsConstructor
class License {
  LocalDate registeredDate;
  LocalDate expiredDate;
  String id;
  List<Person> insuredPersons;
}
