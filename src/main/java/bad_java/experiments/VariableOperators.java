package bad_java.experiments;

import java.util.Scanner;

public class VariableOperators {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
//    sumProductDifference(sc);
//    biggerSmaller(sc);
//    avg(sc);
//    largestSmallest(sc);
//    oddEven(sc);
//    positiveNegative(sc);
    System.out.println(convert("P", 1));
    sc.close();
  }
  public static void sumProductDifference(Scanner sc) {
    System.out.println("Enter two integers");
    int a = sc.nextInt();
    int b = sc.nextInt();
    int sum, difference, product;
    sum = a + b;
    difference = a - b;
    product = a * b;
    System.out.println("sum = " + sum);
    System.out.println("difference = " + difference);
    System.out.println("product = " + product);
  }
  public static void biggerSmaller(Scanner sc) {
    System.out.println("Enter two integers");
    int a, b;
    a = sc.nextInt();
    b = sc.nextInt();
    if (a > b) {
      System.out.println(a + " is greater than " + b);
    } else if (a < b) {
      System.out.println(a + " is less than " + b);
    } else {
      System.out.println(a + " is equal to " + b);
    }
  }
  public static void avg(Scanner sc) {
    int a,b,c;
    System.out.println("Enter three integers");
    a = sc.nextInt();
    b = sc.nextInt();
    c = sc.nextInt();
    int sum = a + b + c;
    double avg = sum / 3.0;
    int product = a * b * c;
    System.out.printf("sum = %d, avg = %.2f, product = %d\n", sum, avg, product);
  }
  public static void largestSmallest(Scanner sc) {
    int a,b,c,d;
    System.out.println("Enter four integers");
    a = sc.nextInt();
    b = sc.nextInt();
    c = sc.nextInt();
    d = sc.nextInt();
    int largest = a;
    if (largest < b)
      largest = b;
    if (largest < c)
      largest = c;
    if (largest < d)
      largest = d;
    System.out.println("largest = " + largest);
  }
  public static void oddEven(Scanner sc) {
    int a;
    System.out.println("Enter two integers");
    a = sc.nextInt();
    if (a % 2 == 0) {
      System.out.println(a + " is even");
    } else {
      System.out.println(a + " is odd");
    }
  }
  public static void modulos(Scanner sc) {
    double a, b;
    a = sc.nextInt();
    b = sc.nextInt();
    double modulos = a % b;
    if(modulos == 0){
      System.out.println(a  +" is divisble by " + b);
    } else {
      System.out.println(a  +" is not divisble by " + b);
    }
  }
  public static void positiveNegative(Scanner sc) {
    int a, b, c, d, e;
    System.out.println("Enter five integers");
    a = sc.nextInt();
    b = sc.nextInt();
    c = sc.nextInt();
    d = sc.nextInt();
    e = sc.nextInt();
    int positive = 0;
    int negative = 0;
    int zero = 0;

    if (a > 0)
      positive++;
    else if (a < 0)
      negative++;
    else
      zero++;
    if (b > 0)
      positive++;
    else if (b < 0)
      negative++;
    else
      zero++;
    if (c > 0)
      positive++;
    else if (c < 0)
      negative++;
    else
      zero++;
    if (d > 0)
      positive++;
    else if (d < 0)
      negative++;
    else
      zero++;
    if (e > 0)
      positive++;
    else if (e < 0)
      negative++;
    else
      zero++;

    System.out.println("There is " + negative + " negative numbers");
    System.out.println("There is " + positive + " positive numbers");
    System.out.println("There is " + zero + " zeros");
  }
  public static String convert(String s, int numRows) {
    String[][] map = new String[numRows][(s.length() / numRows + 1) * numRows];
    boolean goingF = true;

    int row = 0;
    int col = 0;
    for (int i = 0; i < s.length(); i++) {

      map[row][col] = String.valueOf(s.charAt(i));

      if (numRows == 1) {return s;}
      if(i % (numRows-1) == 0 && i >0){
        goingF = !goingF;
      }

        if(goingF){
          row++;
        }else{
          row--;
          col++;
        }

    }

    String result = "";
    for (int i = 0; i < map.length; i++) {
      for (int j = 0; j < map[i].length; j++) {
        result = result + (map[i][j] != null ?map[i][j] : "");
        if (j == map[i].length) {
          j = 0;
        }
      }
    }
    return  result;
  }
}
