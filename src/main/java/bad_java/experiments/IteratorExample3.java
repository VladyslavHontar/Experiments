package bad_java.experiments;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.ListIterator;

public class IteratorExample3 {
  public static void main(String[] args) {
    ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));

    ListIterator<Integer> iterator = list.listIterator();
    System.out.println(iterator.next());
    System.out.println(iterator.next());
    System.out.println(iterator.previous());

    iterator.set(100500);
    System.out.println(list);

  }
}
