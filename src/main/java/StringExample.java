public class StringExample {
  public static void main(String[] args) {
    // 586

    // UTF-8      1...4 bytes per symbol
    // 00000010 01001010

    // UTF-16
    // 00000010 01001010

    // UTF-32
    // 00000000 00000000 00000010 01001010

    System.out.println(Integer.toBinaryString(586));
  }
}
