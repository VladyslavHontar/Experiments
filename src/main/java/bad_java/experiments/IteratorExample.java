package bad_java.experiments;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

public class IteratorExample {
  public static void main(String[] args) {
    List<String> list = Arrays.asList("a", "b", "c", "d");
    for (int i = 0; i < list.size(); i++) {
      System.out.println(list.get(i));
    }
    Iterator<String> iterator = list.iterator();
    while (iterator.hasNext()) {
      System.out.println(iterator.next());
    }

    MyCollection myCollection = new MyCollection();
    for (String s : myCollection) {
      System.out.println(s);
    }
    list.forEach(System.out::println);

    Consumer<String> sout = System.out::println;
    Consumer<String> serr = System.err::println;
    list.forEach(sout);
    list.forEach(serr);
  }
  static class MyCollection implements Iterable<String> {
    private final String[] values = {"a", "b", "c", "d"};
    @Override
    public Iterator<String> iterator() {
      return new Iterator<>() {
        int index = 0;
        @Override
        public boolean hasNext() {
          return index < values.length;
        }
        @Override
        public String next() {
          return values[index++];
        }
      };
    }
  }
}
