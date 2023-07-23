import lombok.AllArgsConstructor;
import lombok.Getter;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class OptionalTest {
  @Test
  void name() {
    Optional<Client> optionalClientIvan = getUserByName("Ivan", "Ivanov");
    System.out.println(optionalClientIvan.filter(client -> client.getPerson().getAge() > 20)
                                         .flatMap(Client::getLicense)
                                         .map(License::getId)
                                         .orElse("No license"));
    Optional<Client> optionalClientPetr = getUserByName("Petr", "Petrov");
    System.out.println(optionalClientPetr.flatMap(Client::getLicense)
                                         .map(License::getId)
                                         .orElse("No license"));

    // map = T -> R
    // flatMap = T -> Optional<R>
  }
  private static Optional<Client> getUserByName(String name, String surname) {
    if ("Ivan".equals(name) && "Ivanov".equals(surname)) {
      Person ivan = new Person(name, surname, 18);
      LocalDate localDate = LocalDate.now();
      License license = new License(localDate, localDate.plusMonths(6), "111", new ArrayList<>(List.of(ivan)));
      return Optional.of(new Client(ivan, license));
    }
    if ("Petr".equals(name) && "Petrov".equals(surname)) {
      Person petr = new Person(name, surname, 30);
      return Optional.of(new Client(petr, null));
    }
    return Optional.empty();
  }

}
@Getter
@AllArgsConstructor
class Client {
  Person person;
  License license;

  Optional<License> getLicense() {
    return Optional.ofNullable(license);
  }
}
@Getter
@AllArgsConstructor
class License {
  LocalDate registeredDate;
  LocalDate expiredDate;
  String id;
  List<Person> insuredPersons;
}
