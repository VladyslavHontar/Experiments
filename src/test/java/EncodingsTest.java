import org.junit.jupiter.api.Test;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class EncodingsTest {
  @Test
  void encodingByteLengthBPM() {
    char ch = '现';

    String stringRepresentation = String.valueOf(ch);
    assertThat(stringRepresentation).hasSize(1);
    assertThat((int)stringRepresentation.charAt(0)).isEqualTo(29616);

    byte[] utf8Bytes = stringRepresentation.getBytes();
    System.out.println(Arrays.toString(utf8Bytes));

    assertThat(utf8Bytes).containsExactly(0xE7, 0x8E, 0xB0);

    byte[] utf16BEBytes = stringRepresentation.getBytes(StandardCharsets.UTF_16BE);
    assertThat(utf16BEBytes).containsExactly(0x73, 0xB0);

    byte[] utf16LEBytes = stringRepresentation.getBytes(StandardCharsets.UTF_16LE);
    assertThat(utf16LEBytes).containsExactly(0xB0, 0x73);

  }

  @Test
  void encodingByteLengthNonBPM() {
    char[] chars = {'\uD801', '\uDC42'};
    String str = new String(chars);

    assertThat(str.length()).isEqualTo(2);
    assertThat(str.codePoints().count()).isEqualTo(1);
    assertThat(str.charAt(0)).isGreaterThan('\u0000');
    assertThat(str.charAt(1)).isGreaterThan('\u0000');
    assertThat(str.codePointAt(0)).isEqualTo(66626 );
    assertThat(str.getBytes(StandardCharsets.UTF_8).length).isEqualTo(4);
    assertThat(str.getBytes(StandardCharsets.UTF_16BE).length).isEqualTo(4);
    assertThat(str.getBytes(Charset.forName("UTF-32")).length).isEqualTo(4);
    assertThat(str.getBytes(Charset.forName("cp1251")).length).isEqualTo(1);    // non-existing charachters length is 1

    System.out.println(str);
  }
}
