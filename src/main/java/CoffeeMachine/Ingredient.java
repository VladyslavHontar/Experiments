package CoffeeMachine;

public enum Ingredient {
  WATER("water", "ml"),
  MILK("milk", "ml"),
  COFFEE_BEANS("coffee beans", "g"),
  SUGAR("sugar", "g"),
  CUP("cup", "pc");

  private final String name;
  private final String unit;

  Ingredient(String name, String unit) {
    this.name = name;
    this.unit = unit;
  }

  public String getName() {
    return name;
  }
  public String getUnit() {
    return unit;
  }
}
