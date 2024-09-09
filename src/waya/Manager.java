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

  private static Stand findCheapest(List<Stand> stands, Fruit notBuyingThisFruit) {
    return stands.stream()
        .min((stand1, stand2) -> compareCheapest(stand1, stand2, notBuyingThisFruit))
        .get();
  }

  private static int compareCheapest(Stand stand1, Stand stand2, Fruit notBuyingThisFruit) {
    int sum1 = stand1.getFruitBaskets().stream()
        .filter(basket -> basket.getFruit() != notBuyingThisFruit)
        .mapToInt(Basket::getPrice)
        .sum();
    int sum2 = stand2.getFruitBaskets().stream()
        .filter(basket -> basket.getFruit() != notBuyingThisFruit)
        .mapToInt(Basket::getPrice)
        .sum();
    return sum1 - sum2;
  }

  public static void main(String[] args) {
    List<Stand> stands = generateStands();
    Fruit notBuyingThisFruit = Math.random() < 0.5d ? Fruit.PEACH : Fruit.CHERRY;
    Stand cheapest = findCheapest(stands, notBuyingThisFruit);

    int sum = cheapest.getFruitBaskets()
        .stream()
        .filter(basket -> basket.getFruit() != notBuyingThisFruit)
        .mapToInt(Basket::getPrice)
        .sum();

    System.out.println("Stand: " + cheapest.getId() + " Price: " + sum );
  }
}