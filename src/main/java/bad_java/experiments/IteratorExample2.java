package bad_java.experiments;

import lombok.Getter;

import java.util.ArrayList;

public class IteratorExample2 {
  public static void main(String[] args) {
    ArrayList<Integer> list = new ArrayList<>();
    list.add(1);
    list.add(2);
    list.add(3);
    list.add(4);
    list.add(5);

    // elementData.length = 5
    // cursor = 0

    // elementData.length = 5
    // cursor = 1

    // elementData.length = 5
    // cursor = 2

    // elementData.length = 4
    // cursor = 3

    // elementData.length = 4
    // cursor = 4

//    for (Iterator<Integer> iterator = list.iterator(); iterator.hasNext(); ) {
//      Integer current = iterator.next();
//      if (current > 3) {
////        list.remove(current);
//        iterator.remove();
//      }
//      System.out.println(list);
//    }

//    for (Integer current : list) {
//      if (current > 3) {
//        list.remove(current);
//      }
//      System.out.println(list);
//    }

//    Predicate<Integer> greaterThan3 = integer -> integer > 3;
    list.removeIf(integer -> integer > 3);
    System.out.println(list);

//    List<Person> persons = null;
//    persons.removeIf(person -> person.getAge() > 18);
  }

  @Getter
  class Person {
    int age;
  }
}
