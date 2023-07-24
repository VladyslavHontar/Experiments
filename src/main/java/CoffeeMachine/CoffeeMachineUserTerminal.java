package CoffeeMachine;

import java.io.PrintStream;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class CoffeeMachineUserTerminal {

  private final Map<String, Runnable> actions = new LinkedHashMap<>() {{
    put("buy", CoffeeMachineUserTerminal.this::buy);
    put("remaining", CoffeeMachineUserTerminal.this::remaining);
    put("exit", () -> {});
  }};

  private final CoffeeMachine machine;
  private final Scanner in;
  private final PrintStream out;

  CoffeeMachineUserTerminal(Scanner userInput, PrintStream userOutput, CoffeeMachine machine) {
    this.machine = machine;
    this.in = userInput;
    this.out = userOutput;
  }

  public void start() {
    do {
      out.println("Write action (" + String.join(", ", actions.keySet()) + "):");
      out.print("> ");
      String action = in.nextLine();

      if (action.equals("exit")) {
        return;
      }
      out.println();
      actions.getOrDefault(action, () -> out.println("Unknown action required!")).run();
      out.println();
    } while (true);
  }

  private void remaining() {
    out.println("Coffee machine has:");
    machine.getSupplies().forEach((ingredient, amount) -> out.println(amount + " of " + ingredient.getName()));
    out.println(machine.money + " of money");
  }

  private void buy() {
    out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino: ");
    out.print("> ");
    CoffeeSort coffeeSort;
    switch (in.nextLine()) {
      case "1":
        coffeeSort = CoffeeSort.ESPRESSO;
        break;

      case "2":
        coffeeSort = CoffeeSort.LATTE;
        break;

      case "3":
        coffeeSort = CoffeeSort.CAPPUCCINO;
        break;

      case "back":
        return;

      default:
        out.println("Unknown type of coffee!");
        return;
    }
    try {
      machine.make(coffeeSort);
      out.println("I have enough resources, making you a coffee!");
    } catch (IllegalStateException ex) {
      out.println(ex.getMessage());
    }
  }
}