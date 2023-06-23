import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class TreeMapTest {
  @Test
  void name() {
    TreeMap<String, Integer> map = new TreeMap<>(Comparator.reverseOrder());   // key cannot be null. Can be used Comparator.reverseOrder()
    map.put("a", 1);
    map.put("b", 2);
    map.put(".", 3);
    map.put("_", 3);
    System.out.println(map);

    map.pollFirstEntry();
    map.pollLastEntry();
    map.descendingKeySet();

    System.out.println(map);

  }
}
