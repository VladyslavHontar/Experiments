import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringTest {

  static String staticField = "literal";

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

  @Test
  void trimAndStripTest() {
    assertThat("       \t\r\n".trim()).isEmpty();
    assertThat("       \t\r\n".strip()).isEmpty();

    assertThat("   \u0000  ab  \t\r\n".trim()).isEqualTo("ab");
    assertThat("   \u0000  ab  \t\r\n".strip()).isEqualTo("\u0000  ab");
    assertThat("   \u0000  ab  \t\r\n".stripLeading()).isEqualTo("\u0000  ab  \t\r\n");
    assertThat("   \u0000  ab  \t\r\n".stripTrailing()).isEqualTo("   \u0000  ab");
  }
}
