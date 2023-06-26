package stack;

import java.util.Scanner;

public class Launcher {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //  int x = sc.nextInt();           // is polindrome
        //  String s = sc.nextLine();       // roman to int
        String[] strs = {"flower", "flow", "flight"};
        Solution sol = new Solution();
        //  System.out.println(sol.isPolindrome(x));
        System.out.println(sol.longestCommonPrefix(strs));
    }
}
class Solution {
    public String longestCommonPrefix(String[] strs) {
        String a = "";
        for (int i = 0; i < strs[0].length(); i++) {
            char c = strs[0].charAt(i);
            boolean b = true;
            for (String str : strs) {
                if (str.length() <= i || str.charAt(i) != c) {
                    b = false;
                    break;
                }
            }
            if (b) {
                a += c;
            } else {
                break;
            }
        }
        return a;
    }

    public boolean isPolindrome(int x) {
        if (x < 0) {
            return false;
        } else if (x >= 0 && x <= 9) {
            return true;
        } else {
            String s1 = Integer.toString(x);
            String s2 = "";
            for (int i = s1.length(); i != 0; i--) {
                s2 += s1.charAt(i - 1);
            }
            return s2.equals(s1);
        }
    }

    public int romanToInt(String s) {
        int a = 0, n = 0, p = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            switch (s.charAt(i)) {
                case 'M' -> n = 1000;
                case 'D' -> n = 500;
                case 'C' -> n = 100;
                case 'L' -> n = 50;
                case 'X' -> n = 10;
                case 'V' -> n = 5;
                case 'I' -> n = 1;
            }
            if (n < p) {
                a -= n;
            } else {
                a += n;
            }
            p = n;
        }
        return a;
    }
}
