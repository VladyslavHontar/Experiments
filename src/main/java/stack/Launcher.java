package stack;

import java.util.Scanner;
import java.util.Stack;
import

public class Launcher {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //  int x = sc.nextInt();           // is polindrome
        //  String s = sc.nextLine();       // roman to int
        String[] strs = {"flower", "flow", "flight", "fl", "fla", "flaska", "flask"};
        String[] strs2 = {"dog","racecar","car"};
        Solution sol = new Solution();
        //  System.out.println(sol.isPolindrome(x));
        System.out.println(sol.longestCommonPrefix(strs));
        System.out.println(sol.longestCommonPrefix(strs2));
    }
}
class Solution {
    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode list3 = new ListNode();
        ListNode list4 = list3;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                list3.next = list1;
                list1 = list1.next;
            } else {
                list3.next = list2;
                list2 = list2.next;
            }
            list3 = list3.next;
        }
        if (list1 != null) {
            list3.next = list1;
        } else {
            list3.next = list2;
        }
        return list4.next;
    }
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(char ch: s.toCharArray()) {
            switch (ch) {
                case '(':
                case '{':
                case '[':
                    stack.push(ch);
                    break;
                case ')':
                    if(stack.isEmpty() || stack.pop() != '(') {
                    return false;
                }
                break;
                case '}':
                    if(stack.isEmpty() || stack.pop() != '{') {
                    return false;
                }
                break;
                case ']':
                    if(stack.isEmpty() || stack.pop() != '[') {
                    return false;
                }
                break;
            }
        }
        return stack.isEmpty();
    }


    public String longestCommonPrefix(String[] strs) {
        String a = "";
        int i = 0;
        int k = strs[0].length();
        int j = 0;
        if (strs.length > 0) {
            for (String str : strs) {
                if (str.length() < k) {
                    k = str.length();
                }
            }
            while (strs[i].charAt(j) == strs[i+1].charAt(j)) {
                a += strs[i].charAt(j);
                if (i < strs.length - 2) {
                    i++;
                    if (j < k - 1) {
                        j++;
                    } else {
                        break;
                    }
                } else {
                    break;
                }
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
