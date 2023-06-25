package stack;

public class Launcher {
    public static void main(String[] args) {
        int x = 100;
    }
    public boolean isPolindrome(int x) {
        if (x < 0) {
            return false;
        } else if (x >= 0 && x <= 9){
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
}
