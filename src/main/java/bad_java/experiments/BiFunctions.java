package bad_java.experiments;

import java.util.function.BiFunction;

public class BiFunctions {
  public static void main(String[] args) {
    // First-class citizen (обьекты первого класса)
    // Pure functions (чистые функции)
    // Higher-order functions (функции высшего порядка)

    BiFunction<Integer, Integer, Integer> adder = BiFunctions::add;
    int result = adder.apply(1, 2);
    System.out.println(result);
  }
  public static int add(int a, int b) {
    return a + b;
  }
}
