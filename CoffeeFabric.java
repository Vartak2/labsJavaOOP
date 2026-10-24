import java.util.*;

interface Coffee {
  void makeCoffee();
  void pourIntoCap();
}

class Espresso implements Coffee {
  @Override
  public void makeCoffee() {
    System.out.println("Варю эспрессо");
    System.out.println("Только кофе и почти никакой воды");
  }

  @Override
  public void pourIntoCap() {
    System.out.println("Наливаю в маленькую итальянскую чашку");
  }
}

class CaffeeLatte implements Coffee {
  @Override
  public void makeCoffee() {
    System.out.println("Варю латте");
    System.out.println("Варю кофейную основу");
    System.out.println("Взбиваю молочную пенку");
  }

  @Override
  public void pourIntoCap() {
    System.out.println("Наливаю в большую американскую чашку");
  }
}

enum CoffeeType {
  ESPRESSO ("Espresso"),
  LATTE ("CaffeeLatte");

  private final String description;

  CoffeeType(String description) {
    this.description = description;
  }
}

abstract class CoffeeShop {
  protected abstract Coffee createCoffee(CoffeeType type);

  public void takeOrder(CoffeeType type) {
    Coffee coffee = createCoffee(type);
    coffee.makeCoffee();
    coffee.pourIntoCap();
  }
}

class ItalianCoffeeShop extends CoffeeShop {
  @Override
  protected Coffee createCoffee(CoffeeType type) {
    System.out.println("Делаем кофе в итальянском стиле");
    if (type == CoffeeType.ESPRESSO) {
      return new Espresso();
    } else {
      return new CaffeeLatte();
    }
  }
}

class AmericanCoffeeShop extends CoffeeShop {
  @Override
  protected Coffee createCoffee(CoffeeType type) {
    System.out.println("Делаем кофе в американском стиле");
    if (type == CoffeeType.ESPRESSO) {
      return new Espresso();
    } else {
      return new CaffeeLatte();
    }
  }
}


public class Main {
    public static void main(String[] args) {
      System.out.println("Hello, World!");
    }
}