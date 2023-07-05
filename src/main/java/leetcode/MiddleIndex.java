package leetcode;

import java.util.Collections;
import java.util.List;

public class MiddleIndex {
    public static void main(String[] args) {
        List<Integer> numbers = new java.util.ArrayList<>(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        Collections.sort(numbers);

        int middleIndex = numbers.size() / 2;

        if (numbers.size() % 2 == 0) {
            int middleNumber1 = numbers.get(middleIndex-1);
            int middleNumber2 = numbers.get(middleIndex);
            double average = (double) (middleNumber1 + middleNumber2) / 2;
            System.out.println(middleNumber1 + " " + middleNumber2);
            System.out.println(average);
        } else {
            int middleNumber = numbers.get(middleIndex);
            System.out.println(numbers.get(middleNumber));
        }
    }
}
