package bad_java.experiments;

import java.util.ArrayList;
import java.util.List;
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
//    System.out.println(grade(40));
    inRange(sc);
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
  public static String grade(int grade) {
    if (grade >= 85) {
      return "A";
    } else if (grade >= 70) {
      return "B";
    } else if (grade >= 55) {
      return "C";
    } else if (grade >= 40) {
      return "D";
    } else {
      return "F";
    }
  }
  public static void inRange(Scanner scanner) {
    System.out.println("Write the first integer: ");
    int num1 = scanner.nextInt();
    System.out.println("Write the second integer: ");
    int num2 = scanner.nextInt();
    boolean isNumber1InRange = false, isNumber2InRange = false;

    if (num1 >= 67 && num1 <= 73) {
      System.out.println("Num1 is in range");
      isNumber1InRange = true;
    } else {
      System.out.println("Num1 is outside of the range");
    }
    if (num2 > 100 && num2 < 999) {
      System.out.println("Num2 is in the range");
      isNumber2InRange = true;
    } else {
      System.out.println("Num2 is outside of the range");
    }

    if (!isNumber1InRange && !isNumber2InRange) {
      System.out.println("Both numbers are outside of the range");
    }
  }
}
