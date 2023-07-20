import bad_java.experiments.User;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

public class ComparatorTest {
  @Test
  void comparator() {
    Comparator<Person> firstnameComparator = (person1, person2) -> person1.getName().compareTo(person2.getName());
    Comparator<Person> lastnameComparator = (person1, person2) -> person1.getSurname().compareTo(person2.getSurname());

    Comparator<Person> personComparator = getPersonComparator(Person::getName);
    Comparator<Person> personComparator2 = getPersonComparator(Person::getSurname);

    Comparator<String> lengthComparator = getComparator(String::length);
    List<String> strings = new ArrayList<>(List.of("1", "333", "22", ""));
    strings.sort(lengthComparator);
    System.out.println(strings);

    Comparator<String> hashComparator = getComparator(String::hashCode);
    Comparator<User> usernameComparator = getComparator(User::getUsername);
  }

  @Test
  void testByMultipleAttributes() {
    List<Person> list = new ArrayList<>(List.of(new Person("A", "b"),
                                              new Person("B", "a"),
                                              new Person("D", "b"),
                                              new Person("C", "c"),
                                              new Person("A", "d"),
                                              new Person("U", "b")));
    list.sort(Comparator.comparing(Person::getSurname).thenComparing(Person::getName));
    list.forEach(System.out::println);
  }

  public Comparator<Person> getPersonComparator(Function<Person, String> extractor) {
    return (person1, person2) -> extractor.apply(person1).compareTo(extractor.apply(person2));
  }
  public <T, R extends Comparable<? super R>> Comparator<T> getComparator(Function<T, R> extractor) {
    return (o1, o2) -> extractor.apply(o1).compareTo(extractor.apply(o2));
  }
}
