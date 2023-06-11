import java.io.IOException;
import java.util.List;

public class VarianceTest {
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