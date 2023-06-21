import org.atpfivt.ljv.LJV;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.net.URI;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

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

  @Test
  void name() {
    LJV ljv = new LJV().setTreatAsPrimitive(Integer.class).setTreatAsPrimitive(String.class);
    String s1 = "Aa";
    String s2 = "BB";
    System.out.println(s1.hashCode());
    System.out.println(s2.hashCode());
    System.out.println(s1.equals(s2));

    Map<String, Object> map = new HashMap<>(4);
    map.put(s1, 1);
    map.put(s2, 1);
    browse(ljv, map);
    map.put("gg", 2);
    map.put("utyu", 3);
    map.put("fgi3", 3);
    map.put("34in", 3);
    browse(ljv, map);

    System.out.println(map);
  }

  @Test
  void collisions() {
    LJV ljv = new LJV().setTreatAsPrimitive(Integer.class).setTreatAsPrimitive(String.class);
    Map<Object, Object> map = new HashMap<>(64);
    Object key1 = createConstantHashObject();
    map.put(key1, 1);
    Object key2 = createConstantHashObject();
    map.put(key2, 1);
    map.put(createConstantHashObject(), 1);
    map.put(createConstantHashObject(), 1);
    map.put(createConstantHashObject(), 1);
    map.put(createConstantHashObject(), 1);
    map.put(createConstantHashObject(), 1);
    map.put(createConstantHashObject(), 1);
    map.put(createConstantHashObject(), 1);

    assertThat(key1.hashCode()).isEqualTo(key2.hashCode());
    assertThat(System.identityHashCode(key1)).isNotEqualTo(key2);

    System.out.println(System.identityHashCode(key1));
    System.out.println(System.identityHashCode(key2));

    browse(ljv, map);
  }
  public static Object createConstantHashObject() {
    return new Object() {
      @Override
      public int hashCode() {
        return 3;
      }
    };
  }

  public static void browse(LJV ljv, Object obj) {
    try {
      String str = ljv.drawGraph(obj);
      var dot= URLEncoder.encode(str, "UTF-8").replaceAll("\\+", "%20");
      Desktop.getDesktop().browse(new URI("https://dreampuf.github.io/GraphvizOnline/#" + dot));
    } catch (Exception e) {
      throw new IllegalStateException(e);
    }
  }
}
