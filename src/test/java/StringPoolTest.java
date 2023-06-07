import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringPoolTest {

  static String staticField = "literal";
  String field = "literal";

  @Test
  void name() {
    String local = "literal";

    assertThat(staticField).isSameAs(field);
    assertThat(staticField).isSameAs(local);

    String createdString = new String("literal");
    assertThat(createdString).isNotSameAs(staticField);
    assertThat(createdString.equals(staticField)).isTrue();

    String internedString = createdString.intern();

    String first = "lit";
    String second = "eral";
    String concatenatedString = first + second;
    assertThat(concatenatedString == local).isFalse();
    assertThat(internedString == local).isTrue();

    final String firstFinal = "lit";
    final String secondFinal = "eral";
    String finalConcatenatedString = firstFinal + secondFinal;
    assertThat(finalConcatenatedString == local).isTrue();
  }
}
