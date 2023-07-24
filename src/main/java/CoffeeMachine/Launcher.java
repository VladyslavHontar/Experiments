package CoffeeMachine;

import java.util.Scanner;

public class Launcher {
  static CoffeeMachine coffeeMachine = new CoffeeMachine();
  public static void main(String[] args) {
    coffeeMachine.supplyIngredient(Ingredient.WATER, 200);
    coffeeMachine.supplyIngredient(Ingredient.MILK, 430);
    coffeeMachine.supplyIngredient(Ingredient.COFFEE_BEANS, 100);
    coffeeMachine.supplyIngredient(Ingredient.CUP, 3);
    coffeeMachine.addMoney(100);
    mode();
  }
  public static void mode() {

    Scanner scanner = new Scanner(System.in);
    do {
      System.out.println("Chose mode (1 - user, 2 - admin, 3 - shut down):");
      System.out.print("> ");
      String mode = scanner.nextLine();
      switch (mode) {
        case "1" -> {
          CoffeeMachineUserTerminal terminal = new CoffeeMachineUserTerminal(scanner, System.out, coffeeMachine);
          terminal.start();
        }
        case "2" -> {
          CoffeeMachineAdminTerminal terminal = new CoffeeMachineAdminTerminal(scanner, System.out, coffeeMachine);
          System.out.print("Password: ");
          terminal.start(scanner.nextLine());
        }
        case "3" -> {
          System.out.println("Shutting down...");
          System.exit(0);
        }
        default -> System.out.println("Unknown mode!");
      }
    } while (true);
  }
}