import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringTest {
  @Test
  void string() {
//    String str = null;
//    str.length();

    String emptyString = "";

    assertThat(emptyString).isEmpty();
    assertThat(emptyString.length()).isZero();

    assertThat(" \t\n\r  ".isBlank());

    String repeatableString = "abc ewfv abc q3jr abc";

    int first = repeatableString.indexOf("abc");        // use lastIndexOf to find last
    int result = repeatableString.indexOf("abc", first + 1);
    assertThat(result).isEqualTo(9);
  }
}
