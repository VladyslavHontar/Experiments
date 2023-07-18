import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.function.Consumer;

import static org.assertj.core.api.Assertions.assertThat;

public class LambdasTest {
  @Test
  void name() {
    // SAM - single abstract method
    // Function descriptor - SAM-interface (args) -> returnValue {throws list}
    // Functional interface

    Comparator<String> comparator = new Comparator<>() {
      @Override
      public int compare(String o1, String o2) {
        return o1.compareTo(o2);
      }
    };

    // (Integer, Integer) -> Integer
    // Full-body statement lambda
    Summator<Integer> sum1 = (Integer l, Integer r) -> {
      return l + r;
    };
    // Statement lambda
    Summator<Integer> sum2 = (l, r) -> {
      return l + r;
    };

    // Expression lambda
    Summator<Integer> sum3 = (l, r) -> l + r;

    Consumer<String> printer = s -> System.out.println(s);
    printer.accept("Hello from lambda");

    Runnable runnable = () -> System.out.println("Hello from runnable");
    runnable.run();

    // Expression lambda
    Summator<Integer> sum4 = Integer::sum;

  }

  @Test
  void staticMethodReference() {
    Summator<String> strSum = LambdasTest::stringSum;
    assertThat(strSum.sum("a", "b")).isEqualTo("ab");
  }

  private static String stringSum(String a, String b) {
    return a + b;
  }
  private String delimiter = ".";
  private String stringSumWithDelimiter(String a, String b) {
    return a + delimiter +b;
  }

  @Test
  void nonStaticMethodReference() {
    assertThat(this.stringSumWithDelimiter("a", "b")).isEqualTo("a.b");

    LambdasTest test = new LambdasTest();
    test.delimiter = "~";
    assertThat(test.stringSumWithDelimiter("a", "b")).isEqualTo("a~b");

    Summator<String> thisSummator = this::stringSumWithDelimiter;
    assertThat(thisSummator.sum("a", "b")).isEqualTo("a.b");

    Summator<String> testSummator = test::stringSumWithDelimiter;
    assertThat(testSummator.sum("a", "b")).isEqualTo("a~b");

    Summator<String> testSummator2 = new LambdasTest()::stringSumWithDelimiter;
    assertThat(testSummator2.sum("a", "b")).isEqualTo("a.b");

    Summator<String> testSummator3 = create("^")::stringSumWithDelimiter;
    assertThat(testSummator3.sum("a", "b")).isEqualTo("a^b");
  }

  private static LambdasTest create(String delimiter) {
    LambdasTest test = new LambdasTest();
    test.delimiter = delimiter;
    return test;
  }
}

@FunctionalInterface
interface Summator<T> {
  T sum(T a, T b);

  default int another() {
    return 0;
  }

  static void method() {}
}
