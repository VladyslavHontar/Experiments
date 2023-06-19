import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class PriorityQueueTest {
  @Test
  void name() {
    Queue<Integer> values = new PriorityQueue<>(Comparator.reverseOrder());

    values.add(10);
    values.add(20);
    values.add(1);
    values.add(15);
    values.add(55);
    values.add(85);

    System.out.println(values);

    //        85
    //      /    \
    //     20    55
    //    /  \   /
    //   10  15 1
    //
    //
    //

    while (!values.isEmpty()) {
      System.out.println(values.poll());
    }
  }
}
