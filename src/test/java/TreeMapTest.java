import org.junit.jupiter.api.Test;

import java.util.Map;
import java.util.TreeMap;

public class TreeMapTest {
  @Test
  void name() {
    Map<String, Integer> map = new TreeMap<>();   // key cannot be null. Can be used Comparator.reverseOrder()
    map.put("a", 1);
    map.put("b", 2);
    map.put(".", 3);
    map.put("_", 3);
    System.out.println(map);
  }
}
