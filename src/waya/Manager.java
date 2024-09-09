package waya;

import waya.model.Basket;
import waya.model.Fruit;
import waya.model.Stand;

import java.util.ArrayList;
import java.util.List;

public class Manager {

  public static List<Stand> generateStands() {
    List<Stand> stands = new ArrayList<>();
    for (int i = 0; i < 10; i++) {
      List<Basket> baskets = new ArrayList<>();
      for (Fruit fruit : Fruit.values()) {
        int price = (int) (Math.random() * 100);
        baskets.add(new Basket(fruit, price));
      }
      stands.add(new Stand(i, baskets));
    }
    return stands;
  }

  private static Stand findCheapest(List<Stand> stands) {
    return stands.stream()
        .min(Manager::compareCheapest)
        .get();
  }

  private static int compareCheapest(Stand stand1, Stand stand2) {
    int sum1 = stand1.getFruitBaskets().stream()
        .mapToInt(Basket::getPrice)
        .sum();
    int sum2 = stand2.getFruitBaskets().stream()
        .mapToInt(Basket::getPrice)
        .sum();
    return sum1 - sum2;
  }


  public static void main(String[] args) {
    List<Stand> stands = generateStands();
    Stand cheapest = findCheapest(stands);
    System.out.println(cheapest);
  }
}