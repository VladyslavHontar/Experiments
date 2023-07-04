package stack;

import java.util.Scanner;

public class Launcher {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack stack = new Stack();
        while (true) {
            String command = sc.nextLine();
            String[] parts = command.split(" ");
            switch (parts[0].toUpperCase()) {
                case "PUSH" -> stack.push(command.substring(5));
                case "POP" -> System.out.println(stack.pop());
                case "SIZE" -> System.out.println(stack.size());
                case "CONTAINS" -> System.out.println(stack.contains(parts[1]));
                case "EXIT" -> {
                    return;
                }
            }
        }
    }
}
