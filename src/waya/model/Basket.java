package waya.model;

public class Basket {
  private Fruit fruit;
  private int price;

  public Basket(Fruit fruit, int price) {
    this.fruit = fruit;
    this.price = price;
  }

  public Fruit getFruit() {
    return fruit;
  }

  public int getPrice() {
    return price;
  }

  @Override
  public String toString() {
    return "Basket{" +
        "fruit=" + fruit +
        ", price=" + price +
        '}';
  }
}
