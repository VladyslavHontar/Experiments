package CoffeeMachine;

import java.util.Map;

public enum CoffeeSort {
  ESPRESSO(Map.of(Ingredient.WATER, 30,
                  Ingredient.COFFEE_BEANS, 18,
                  Ingredient.CUP, 1)),
  LATTE(Map.of(Ingredient.WATER, 30,
               Ingredient.MILK, 120,
               Ingredient.COFFEE_BEANS, 18,
               Ingredient.SUGAR, 15,
               Ingredient.CUP, 1)),
  CAPPUCCINO(Map.of(Ingredient.WATER, 30,
                    Ingredient.MILK, 120,
                    Ingredient.COFFEE_BEANS, 18,
                    Ingredient.CUP, 1));

  private final Map<Ingredient, Integer> recipe;

  CoffeeSort(Map<Ingredient, Integer> recipe) {
    this.recipe = recipe;
  }
  public Map<Ingredient, Integer> getRecipe() {
    return recipe;
  }
}
