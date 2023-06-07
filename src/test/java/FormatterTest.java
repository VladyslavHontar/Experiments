import org.junit.jupiter.api.Test;

import java.util.Formatter;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;

public class FormatterTest {
  @Test
  void formatterTest() {
    StringBuilder stringBuilder = new StringBuilder();
    Formatter formatter = new Formatter(stringBuilder);

    String simpleText = formatter.format("Just simple text").toString();
    assertThat(simpleText).isEqualTo("Just simple text");
    stringBuilder.setLength(0);

    // %[argument_index$][flags][width][.precision]conversion

    // %conversion
    String textWithBoolean = formatter.format("this is boolean value [%b]", true).toString();
    assertThat(textWithBoolean).isEqualTo("this is boolean value [true]");
    stringBuilder.setLength(0);

    String textWithInteger = formatter.format("this is an Integer value [%d]", 123).toString();
    assertThat(textWithInteger).isEqualTo("this is an Integer value [123]");
    stringBuilder.setLength(0);

    String textWithDecimal = formatter.format("this is a float value [%f]", 5.2367).toString();
    assertThat(textWithDecimal).isEqualTo("this is a float value [5.236700]");
    stringBuilder.setLength(0);

    String textWithString = formatter.format("this is a string [%s]", "Karman").toString();
    assertThat(textWithString).isEqualTo("this is a string [Karman]");
    stringBuilder.setLength(0);

    String textWithPercent = formatter.format("Current loading is %d%%", 23).toString();
    assertThat(textWithPercent).isEqualTo("Current loading is 23%");
    stringBuilder.setLength(0);

    // %[width]conversion
    String textWithIntegerW = formatter.format("this is an Integer value |%8d|", 123).toString();
    assertThat(textWithIntegerW).isEqualTo("this is an Integer value |     123|");
    stringBuilder.setLength(0);

    // %[width][.precision]conversion
    String textWithDecimalWP = formatter.format("this is a float value [%8.3f]", 5.2367).toString();
    assertThat(textWithDecimalWP).isEqualTo("this is a float value [   5.237]");
    stringBuilder.setLength(0);

    String textWithStringWP = formatter.format("this is a string [%.5s]", "Karman").toString();
    assertThat(textWithStringWP).isEqualTo("this is a string [Karma]");
    stringBuilder.setLength(0);
  }

  @Test
  void argumentIndexTest() {
    Formatter formatter = new Formatter();
    String result = formatter.format("Decimal: %3$.1f | Integer: %2$d | Again Integer: %<d | String: %1$s", "abc", 2, 0.1).toString();
    assertThat(result).isEqualTo("Decimal: 0.1 | Integer: 2 | Again Integer: 2 | String: abc");
  }

  @Test
  void formatterPerformanceTest() {
    StringBuilder stringBuilder = new StringBuilder();
    Formatter formatter = new Formatter(stringBuilder);
    ThreadLocalRandom random = ThreadLocalRandom.current();

    long start = System.nanoTime();

    for (int i = 0; i < 1000; i++) {
      System.out.println(formatter.format("Just simple text %d - %f%n", random.nextInt(), random.nextDouble()));
    }

    long finish = System.nanoTime();
    System.out.println(TimeUnit.NANOSECONDS.toSeconds(finish - start));
  }

  @Test
  void baselineFormatterPerformanceTest() {
    ThreadLocalRandom random = ThreadLocalRandom.current();

    long start = System.nanoTime();

    for (int i = 0; i < 1000; i++) {
      System.out.print("Just simple text " + random.nextInt() + " - " + random.nextDouble() + System.lineSeparator());
    }

    long finish = System.nanoTime();
    System.out.println(TimeUnit.NANOSECONDS.toSeconds(finish - start));
  }
}
