import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringTest {
  // 586

  // UTF-8      1...4 bytes per symbol
  // 00000010 01001010

  // Byte order mark
  // UTF-16-LE | UTF-16-BE
  // Little endian [FFFE] | Big endian [FEFF]
  // 00000010 01001010 | 01001010 00000010

  // UTF-32
  // 00000000 00000000 00000010 01001010
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
