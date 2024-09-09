package waya.model;

import java.util.List;

public class Stand {
  private final int id;
  private List<Basket> baskets;

  public Stand(int id, List<Basket> baskets) {
    this.id = id;
    this.baskets = baskets;
  }

  public List<Basket> getFruitBaskets() {
    return baskets;
  }

  public int getId() {
    return id;
  }

  @Override
  public String toString() {
    return "Stand{" +
        "id=" + id +
        ", baskets=" + baskets +
        '}';
  }
}
