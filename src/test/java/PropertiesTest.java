import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Properties;

import static org.assertj.core.api.Assertions.assertThat;

public class PropertiesTest {
  @Test
  void name() throws IOException {
    Properties properties = new Properties();
    assertThat(properties).isEmpty();

    properties.load(ConcatTest.class.getResourceAsStream("messages.properties"));
    assertThat(properties).isNotEmpty();
    assertThat(properties.getProperty("input_username")).isEqualTo("default#1");
  }
}
