import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;
import static org.assertj.core.api.Assertions.assertThat;

public class StreamTest {
  @Test
  void name() {
    List<String> list = List.of("a", "b", "c", "aa", "ccc");
    list.stream()
        .filter(s -> s.length() < 3)
        .map(String::toUpperCase)
        .sorted(Comparator.reverseOrder())
        .limit(2)
        .forEachOrdered(System.out::println);

    Optional<Client> any = getClients()
            .stream()
            .filter(client -> client.getPerson().getAge() > 25)
            .filter(client -> client.getLicense().map(License::getExpiredDate).isPresent())
            .findAny();

    assertThat(any).isNotEmpty()
                   .map(Client::getPerson)
                   .map(Person::getName)
                   .get()
                   .isEqualTo("Sidor");

    Map<String, Integer> map = list.stream().collect(toMap(str -> str, String::length));
  }

  public List<Client> getClients () {
    return List.of(
        new Client(new Person("Ivan", "Ivanov", 18), new License(LocalDate.now(), LocalDate.now().plusMonths(6), "111", new ArrayList<>(List.of(new Person("Ivan", "Ivanov", 18))))),
        new Client(new Person("Sidor", "Sidorov", 26), new License(LocalDate.now(), LocalDate.now().plusMonths(6), "111", new ArrayList<>(List.of(new Person("Sidor", "Sidorov", 25)))))
    );
  }
}
