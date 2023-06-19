import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class HashMapTest {
    Map<Integer, String> oldWay = new HashMap<>() {{
      put(1, "1");
      put(2, "2");
      put(3, "3");
    }};
  @Test
  void java9way() {

    Map<Integer, String> map = Map.of(1, "1", 2, "2");
    Map<Integer, String> bigMap = Map.ofEntries(
            Map.entry(1, "1"),
            Map.entry(2, "2"),
            Map.entry(3, "3"),
            Map.entry(4, "4"),
            Map.entry(5, "5"),
            Map.entry(6, "6"),
            Map.entry(7, "7"),
            Map.entry(8, "8"),
            Map.entry(9, "9"),
            Map.entry(10, "10"),
            Map.entry(11, "11")
    );
  }
}
