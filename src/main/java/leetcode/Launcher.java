package leetcode;

import java.util.*;

public class Launcher {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    //  int x = sc.nextInt();           // is polindrome
    //  String s = sc.nextLine();       // roman to int
    int nums[] = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
    int i;
    String[] strs = {"flower", "flow", "flight", "fl", "fla", "flaska", "flask"};
    String[] strs2 = {"dog", "racecar", "car"};
    Solution sol = new Solution();
    //  System.out.println(sol.isPolindrome(x));
    System.out.println(sol.maxSubArray(nums));
    System.out.println(sol.longestCommonPrefix(strs));
    System.out.println(sol.longestCommonPrefix(strs2));
  }
}

class Solution {
  public int climbStairs(int n) {
    Map<Integer, Integer> memo = new HashMap<>();
    return climbStairs(n, memo);
  }

  private int climbStairs(int n, Map<Integer, Integer> memo) {
    if (n == 0 || n == 1) {
      return 1;
    }
    if (!memo.containsKey(n)) {
      memo.put(n, climbStairs(n - 1, memo) + climbStairs(n - 2, memo));
    }
    return memo.get(n);
  }

  public int maxSubArray(int[] nums) {
    int maxSum = Integer.MIN_VALUE;
    int currentSum = 0;

    for (int i = 0; i < nums.length; i++) {
      currentSum += nums[i];

      if (currentSum > maxSum) {
        maxSum = currentSum;
      }

      if (currentSum < 0) {
        currentSum = 0;
      }
    }

    return maxSum;
  }

  public class ListNode {
    int val;
    Solution.ListNode next;

    ListNode() {
    }

    ListNode(int val) {
      this.val = val;
    }

    ListNode(int val, Solution.ListNode next) {
      this.val = val;
      this.next = next;
    }
  }

  public Solution.ListNode mergeTwoLists(Solution.ListNode list1, Solution.ListNode list2) {
    Solution.ListNode list3 = new Solution.ListNode();
    Solution.ListNode list4 = list3;
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
    for (char ch : s.toCharArray()) {
      switch (ch) {
        case '(':
        case '{':
        case '[':
          stack.push(ch);
          break;
        case ')':
          if (stack.isEmpty() || stack.pop() != '(') {
            return false;
          }
          break;
        case '}':
          if (stack.isEmpty() || stack.pop() != '{') {
            return false;
          }
          break;
        case ']':
          if (stack.isEmpty() || stack.pop() != '[') {
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
      while (strs[i].charAt(j) == strs[i + 1].charAt(j)) {
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

  public String convert(String s, int numRows) {
    String[][] map = new String[numRows][(s.length() / numRows + 1) * numRows];
    boolean goingF = true;

    int row = 0;
    int col = 0;
    for (int i = 0; i < s.length(); i++) {

      map[row][col] = String.valueOf(s.charAt(i));

      if (numRows == 1) {
        return s;
      }
      if (i % (numRows - 1) == 0 && i > 0) {
        goingF = !goingF;
      }

      if (goingF) {
        row++;
      } else {
        row--;
        col++;
      }

    }

    String result = "";
    for (int i = 0; i < map.length; i++) {
      for (int j = 0; j < map[i].length; j++) {
        result = result + (map[i][j] != null ? map[i][j] : "");
        if (j == map[i].length) {
          j = 0;
        }
      }
    }
    return result;
  }

  public int reverse(int x) {
    StringBuilder sb = new StringBuilder();
    sb.append(Math.abs(x));
    sb.reverse();
    int pos = Integer.parseInt(sb.toString());
    int res;
    if (x < 0) {
      res = (~(pos - 1));
    } else {
      res = pos;
    }
    return res;
  }
}


