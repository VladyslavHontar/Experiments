import bad_java.experiments.data.Employee;
import bad_java.experiments.data.EmployeeDataProvider;
import bad_java.experiments.data.JobHistoryEntry;
import bad_java.experiments.data.Person;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Supplier;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;
import static org.assertj.core.api.Assertions.*;

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
                  // .map(Person::getName)
                   .get()
                   .isEqualTo("Sidor");

    Map<String, Integer> map = list.stream().collect(toMap(str -> str, String::length));
  }

  public List<Client> getClients () {
    return List.of(
      //  new Client(new Person("Ivan", "Ivanov", 18), new License(LocalDate.now(), LocalDate.now().plusMonths(6), "111", new ArrayList<>(List.of(new Person("Ivan", "Ivanov", 18))))),
      //  new Client(new Person("Sidor", "Sidorov", 26), new License(LocalDate.now(), LocalDate.now().plusMonths(6), "111", new ArrayList<>(List.of(new Person("Sidor", "Sidorov", 25)))))
    );
  }

  @Test
  void streams() throws IOException {
    Stream<? extends Serializable> stream1 = Stream.of("a", "b", 1, 12312412L);

    String[] strings = {"a", "b", "c"};
    Stream<String> strings1 = Stream.of(strings);
    Stream<String> strings2 = Arrays.stream(strings);

    File tempFile = File.createTempFile("java_experiments", "paupau");
    System.out.println(tempFile);
    tempFile.deleteOnExit();

    try (PrintWriter out = new PrintWriter(tempFile)) {
      out.println("10");
      out.println("-15");
      out.println("32");
    }
    Path path = Paths.get(tempFile.getAbsolutePath());
    try (Stream<String> lines = Files.lines(path)) {
      //Integer result = lines.map(Integer::parseInt).reduce(0, Integer::sum);
      int anotherResult = lines.mapToInt(Integer::parseInt).sum();
//      assertThat(result).isEqualTo(27);
      assertThat(anotherResult).isEqualTo(27);
    }

    byte[] bytes = {1, 2, 3, 4, '\n', 1, 2, 4};
    BufferedReader in = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(bytes)));
    assertThat(in.lines().count()).isEqualTo(2);

    Stream.Builder<Double> builder = Stream.builder();
    builder.add(1.0).add(2.0).add(2.1);
    Stream<Double> stream = builder.build();
//    assertThat(stream.count()).isEqualTo(3);
//    assertThat(stream.reduce(0.0, Double::sum)).isEqualTo(5.1);
    assertThat(stream.min(Double::compareTo)).isNotEmpty().get().isEqualTo(1.0);    //or use Comparator.naturalOrder()

    Stream<Integer> integerStream = Stream.of(1, 2, 3, 4, 0, -1, 2, 3);
    Integer result = integerStream.filter(i -> i > 2)
                                  .reduce(1, (a, b) -> a * b);    //or use Math::multiplyExact
    // (((1 * 3) * 4) * 3) = 36
    assertThat(result).isEqualTo(36);

    Supplier<Integer> supplier = () -> ThreadLocalRandom.current().nextInt();
    Stream<Integer> stream2 = Stream.generate(supplier);
    Integer[] randomValuesFromStream = stream2.limit(50).toArray(Integer[]::new);

    IntStream intStream = ThreadLocalRandom.current().ints(20, 0, 200);

    StringJoiner joiner = new StringJoiner(", ", "[", "]");
    joiner.add("a").add("b").add("c");
    assertThat(joiner.toString()).isEqualTo("[a, b, c]");

    String intStream1 = ThreadLocalRandom.current()
                                         .ints(10, 0, 10)
                                         .mapToObj(String::valueOf)
                                         .collect(joining(", ", "[", "]"));
    assertThat(intStream1).matches("\\[\\d+(, \\d+)*]");

    Stream.iterate(1, i -> i < 10, e -> e + 2).forEach(System.out::print);

    String source = "a,b,c";
    Stream<String> stream3 = Pattern.compile(",").splitAsStream(source);
    assertThat(stream3.collect(Collectors.toList())).containsExactly("a", "b", "c");

    Stream<Integer> left = Stream.of(3,2,1);
    Stream<Integer> right = Stream.of(5,3,4);

    Stream<Integer> sorted = Stream.concat(left, right).distinct().sorted();

    assertThat(sorted).containsExactly(1,2,3,4,5);

  }
  @Test
  void primitiveStreams() {
    IntStream integerStream = IntStream.of(1, 2, 34, 5, 6, 6);
    integerStream.sum();
//    integerStream.average();
//    integerStream.min();

    int[] ints = {1, 2, 3, 4, 5};
    OptionalInt max = IntStream.of(ints).max();
    OptionalInt min = IntStream.of(ints).min();
    OptionalDouble average = IntStream.of(ints).average();

    IntSummaryStatistics intSummaryStatistics = IntStream.of(ints).summaryStatistics();
    assertThat(intSummaryStatistics.getAverage()).isCloseTo(3.0, withinPercentage(0.0001));
    assertThat(intSummaryStatistics.getCount()).isEqualTo(5);
    assertThat(intSummaryStatistics.getMax()).isEqualTo(5);
    assertThat(intSummaryStatistics.getMin()).isEqualTo(1);
    assertThat(intSummaryStatistics.getSum()).isEqualTo(15);
  }

  @Test
  void drugExample() {
    Integer[] holder = {0};
    Stream<Integer> integerStream = Stream.of(10, 2, 3, 4);
    Integer peek = integerStream.peek(i -> holder[0] = i)
                                .skip(1)
                                .reduce(10, Integer::sum);
    System.out.println(peek);
  }

  @Test
  void exercises() {
    EmployeeDataProvider employeeDataProvider = new EmployeeDataProvider();

    List<Employee> employees = employeeDataProvider.getEmployees();
    // 1. Find all Persons who had more than 2 jobs

    List<Person> personList = employees.stream()
                                       .filter(e -> e.getJobHistory().size() > 2)
                                       .map(Employee::getPerson)
                                       .collect(toList());

    // 2. Find all Persons surnames whos name is Иван

    employees.stream().map(Employee::getPerson).filter(p -> "Иван".equals(p.getName())).map(Person::getSurname).forEach(System.out::println);

    System.out.println();
    // 3. Find all persons whos older than 25yo and has dev positions

    employees.stream()
             .filter(e -> e.getPerson().getAge() > 25)
             .filter(e -> e.getJobHistory().stream().map(JobHistoryEntry::getPosition).anyMatch("dev"::equals))
             .map(Employee::getPerson)
             .forEach(System.out::println);

    System.out.println();
    // 4. Find names and surnames top 3 experienced employees

    employees.stream()
             .sorted(Comparator.<Employee>comparingInt(e -> e.getJobHistory()
                                                             .stream()
                                                             .mapToInt(JobHistoryEntry::getDuration)
                                                             .sum())
                               .reversed())
             .limit(3)
             .map(Employee::getPerson)
             .map(p -> p.getName() + " " + p.getSurname())
             .forEach(System.out::println);

    System.out.println();
    // 5. Group employees by surname and place em into the Map<String, Employee>

    Map<String, List<Employee>> collect = employees.stream().collect(groupingBy(e -> e.getPerson().getSurname()));
    collect.entrySet().stream().filter(e -> e.getValue().size() > 1).forEach(System.out::println);

    System.out.println();
    // 6. Count of surnames

    Map<String, Long> collect1 = employees.stream().collect(groupingBy(e -> e.getPerson().getSurname(), counting()));
    System.out.println(collect1);

    System.out.println();
    // 7. Divide for to categorise by age >30 & <30

    Map<Boolean, List<Employee>> collect2 = employees.stream().collect(partitioningBy(e -> e.getPerson().getAge() > 30));
    System.out.println(collect2);

    System.out.println();
    // 8. Find the most experienced employee

    OptionalInt max = employees.stream().map(Employee::getJobHistory).flatMap(Collection::stream).mapToInt(JobHistoryEntry::getDuration).max();

    System.out.println(max.orElseThrow());
  }
}
