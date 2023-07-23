import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.assertj.core.api.Assertions.assertThat;

public class MapApiTest {
  @Test
  void name() {
    HashMap<String, Integer> map = new HashMap<>();

    map.merge("name", 1, Integer::sum);
    map.merge("name", 1, Integer::sum);
    map.merge("name", 1, Integer::sum);

    assertThat(map.get("name")).isEqualTo(3);

    map.computeIfAbsent("Abar", String::length);
    map.putIfAbsent("Abar", 1);
    assertThat(map.get("Abar")).isEqualTo(4);

    map.compute("Abar", (k, v) -> 55);

    map.forEach((k, v) -> System.out.println("key = {" + k + "}, value = " + v + "}"));
  }
}
