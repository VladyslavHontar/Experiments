package bad_java.experiments;

import java.util.ArrayList;
import java.util.List;

public class ClosureExample {
  private Runnable task;
  private static final String CONST = "CONSTANT";
  private int field = 55;
  public static void main(String[] args) {
    ClosureExample example = new ClosureExample();

  }
  public void anonymous() {
    int value = 42;

    List<String> list = new ArrayList<>(List.of("a", "b", "c", "d"));

    ClosureExample _this = this;
    task = new Runnable() {
      @Override
      public void run() {
        Runnable _this = this;
        System.out.println(value);
        System.out.println(list);
        System.out.println(CONST);
        System.out.println(field);
      }
    };

    task.run();

    list.add("e");
  }
  public void lambda() {
    int value = 42;

    List<String> list = new ArrayList<>(List.of("a", "b", "c", "d"));

    ClosureExample _this = this;

    task = () -> {
      ClosureExample _this2 = this;
      System.out.println(value);
      System.out.println(list);
      System.out.println(CONST);
      System.out.println(field);
    };

    task.run();

    list.add("e");
  }
}
