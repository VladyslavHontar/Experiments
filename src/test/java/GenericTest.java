public class GenericTest {
  public static void main(String[] args) {
    Integer i = 1;
    Class<? extends Integer> aClass = i.getClass();
    System.out.println(aClass);
  }
}
