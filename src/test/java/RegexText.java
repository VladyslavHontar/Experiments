import org.junit.jupiter.api.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

public class RegexText {
  @Test
  void name() {
    assertThat("111230134\\".matches("\\d+0\\d+\\\\")).isTrue();

    Pattern pattern = Pattern.compile("\\d+[23]");

    Matcher matcher1 = pattern.matcher("123");
    assertThat(matcher1.matches()).isTrue();
    assertThat(matcher1.pattern()).isSameAs(pattern);
    assertThat(matcher1.pattern().pattern()).isEqualTo("\\d+[23]");

    Matcher matcher2 = pattern.matcher("0");
    assertThat(matcher2.matches()).isFalse();

    Matcher matcher3 = Pattern.compile("^\\w+").matcher("Some text = 00 ");
    assertThat(matcher3.lookingAt()).isTrue();
    assertThat(matcher3.group()).isEqualTo("Some");

    assertThat(matcher3.reset("~ Text").lookingAt()).isFalse();

    Matcher matcher4 = pattern.matcher("Current value = 02, max value = 03, another text");
    assertThatCode(() -> matcher4.group()).isInstanceOf(IllegalStateException.class);

    assertThat(matcher4.find()).isTrue();
    assertThat(matcher4.start()).isEqualTo(16);
    assertThat(matcher4.end()).isEqualTo(18);
    assertThat(matcher4.group()).isEqualTo("02");

    assertThat(matcher4.find()).isTrue();
    assertThat(matcher4.start()).isEqualTo(32);
    assertThat(matcher4.end()).isEqualTo(34);
    assertThat(matcher4.group()).isEqualTo("03");

    assertThat(matcher4.find()).isFalse();

    matcher4.reset();
    assertThat(matcher4.find(18)).isTrue();
    assertThat(matcher4.start()).isEqualTo(32);
    assertThat(matcher4.end()).isEqualTo(34);
    assertThat(matcher4.group()).isEqualTo("03");
  }

  @Test
  void split() {
    String[] split = "2021-08-10".split("[0-9]+");
    assertThat(split).containsExactly("", "-", "-");

    Pattern splitter = Pattern.compile("-");
    String[] result1 = splitter.split("2021-08-10");
    assertThat(result1).containsExactly("2021", "08", "10");
    String[] result2 = splitter.split("1998-10-28");
    assertThat(result2).containsExactly("1998", "10", "28");
  }

  @Test
  void groups() {
    Pattern dateParser = Pattern.compile("(\\d{4})-(\\d{2})-(\\d{2})");

    Matcher matcher1 = dateParser.matcher("Today is 2023-06-08");
    assertThat(matcher1.find()).isTrue();
    assertThat(matcher1.group()).isEqualTo("2023-06-08");
    assertThat(matcher1.group(0)).isEqualTo("2023-06-08");
    assertThat(matcher1.group(1)).isEqualTo("2023");
    assertThat(matcher1.group(2)).isEqualTo("06");
    assertThat(matcher1.group(3)).isEqualTo("08");

    Pattern pattern = Pattern.compile("(\\d+?(0+)\\d+) (\\w+)");
    Matcher matcher2 = pattern.matcher("qlhjbguc 278350000834378 dfkqjh gWEGJB");
    assertThat(matcher2.find()).isTrue();
    assertThat(matcher2.group()).isEqualTo("278350000834378 dfkqjh");
    assertThat(matcher2.group(1)).isEqualTo("278350000834378");
    assertThat(matcher2.group(2)).isEqualTo("0000");
    assertThat(matcher2.group(3)).isEqualTo("dfkqjh");

  }
}
