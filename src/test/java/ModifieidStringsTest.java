import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ModifieidStringsTest {

  @Test
  void name() {
    StringBuilder stringBuilder = new StringBuilder();
    final String base = "bad_java.experimets.User#";
    stringBuilder.append(base);
    for (int i = 0; i < 100; i++) {
      stringBuilder.setLength(base.length());
      stringBuilder.append(i);
      System.out.println(stringBuilder);
    }
  }

  @Test
  void capacityTest() {
    StringBuilder builder  = new StringBuilder(6);
    builder.append("123");

    assertThat(builder.length()).isEqualTo(3);
    assertThat(builder.capacity()).isEqualTo(6);

    builder.append("abcde");
    assertThat(builder.length()).isEqualTo(8);
    assertThat(builder.capacity()).isEqualTo(14);

    builder.setLength(builder.length() - 1);
    assertThat(builder.length()).isEqualTo(7);
    assertThat(builder.capacity()).isEqualTo(14);
    assertThat(builder).contains("123abcd");

    builder.trimToSize();
    assertThat(builder.length()).isEqualTo(7);
    assertThat(builder.capacity()).isEqualTo(7);

    builder.setLength(0);
    assertThat(builder.length()).isEqualTo(0);
    assertThat(builder.capacity()).isEqualTo(7);
  }

  @Test
  void modification() {
    StringBuilder builder = new StringBuilder("Hello World");
    builder.append('!');
    builder.insert(0, ">> ");

    assertThat(builder).contains(">> Hello World!");

    builder.deleteCharAt(1);
    builder.delete(1, 7);
    assertThat(builder).contains("World!");

    builder.reverse();
    assertThat(builder).contains("!dlroW");

    StringBuilder secondBuilder = new StringBuilder(builder);
    assertThat(secondBuilder).isNotEqualTo(builder);

    String str = secondBuilder.toString();
    assertThat(str.contentEquals(builder)).isTrue();
  }
}
