import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class VarianceTest {
  @Test
  void name() {

    String str = "hello world";
    Object obj = str;

    String[] strings = {};
    Object[] objects = strings;

    List<Integer> integers = null;
    List<? extends Number> numbers = integers;

    CustomOptional<String> stringOptional = null;
    //   CustomOptional<Object> objectOptional = stringOptional;

    List<Number> numberList = null;
    List<? super Integer> intergerList = numberList;
  }

  @Test
  void arrayCovarianceIssue() {
    String[] strings = {"1", "2"};
    Object[] objects = strings;
//    objects[0] = 1;
//    Integer[] integers = (Integer[]) objects;

  }

  @Test
  void genericsInvariance() {
    List<Object> objects = new ArrayList<>();
    List<String> strings = new ArrayList<>();
    strings.add("1");
    String s = strings.get(0);

//  objects = strings;  // compile error

    List<?> wildcards = strings;
    wildcards.add(null);
    Object o = wildcards.get(0);

    List<? extends Number> numbers1 = new ArrayList<Long>();
    numbers1.add(null);
    Number number = numbers1.get(0);

    List<? super Number> numbers2 = new ArrayList<Object>();
    Number num = 1;
    numbers2.add(num);
    numbers2.add(2);
    numbers2.add(2.5);
    numbers2.add(3L);

//  Producer
//  Extends
//  Consumer
//  Super
  }

  @Test
  void comparatorsExample() {
    String[] str = {"1", "22", "333", "4444"};

    Comparator<String> reverseComporator = new Comparator<String>() {
      @Override
      public int compare(String o1, String o2) {
        return -o1.compareTo(o2);
      }
    };
    Arrays.sort(str, reverseComporator);

    System.out.println(Arrays.toString(str));
  }
}

class A {
  public Number method() throws Exception {
    return null;
  }
}
class B extends A {
  @Override
  public Integer method() throws IOException {
    return null;
  }
}