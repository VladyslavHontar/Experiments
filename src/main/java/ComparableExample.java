import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class ComparableExample implements Comparable<Integer>{
  public static void main(String[] args) {
    for (Method declaredMethod : ComparableExample.class.getDeclaredMethods()) {
      System.out.println(declaredMethod + ": is Synthetic "+ " = " + declaredMethod.isSynthetic() + " | is Bridge = " + declaredMethod.isBridge());
    }
    for (Constructor<?> declaredConstructor : ComparableExample.class.getDeclaredConstructors()) {
      System.out.println(declaredConstructor + ": is Synthetic "+ " = " + declaredConstructor.isSynthetic());
    }
  }
  @Override
  public int compareTo(Integer o) {
    return 0;
  }
}
