import java.util.*;

interface Chair {
  void createFrame();
  void doUpholstery();
}

class VictorianChair implements Chair {
  @Override
  public void createFrame() {
    System.out.println("Создаю викторианский стул");
    System.out.println("Каркас из резного красного дерева");
  }

  @Override
  public void doUpholstery() {
    System.out.println("Обиваю бархатом с золотой вышивкой");
  }
}

class ModernChair implements Chair {
  @Override
  public void createFrame() {
    System.out.println("Создаю стул в стиле модерн");
    System.out.println("Каркас из гнутой стали и светлого шпона");
  }

  @Override
  public void doUpholstery() {
    System.out.println("Обиваю гладкой экокожей без декора");
  }
}

interface Table {
  void createTop();
  void attachLegs();
}

class VictorianTable implements Table {
  @Override
  public void createTop() {
    System.out.println("Создаю викторианский стол");
    System.out.println("Столешница из массива дуба с инкрустацией");
  }

  @Override
  public void attachLegs() {
    System.out.println("Прикручиваю точёные ножки с резьбой");
  }
}

class ModernTable implements Table {
  @Override
  public void createTop() {
    System.out.println("Создаю стол в стиле модерн");
    System.out.println("Столешница из закалённого стекла");
  }

  @Override
  public void attachLegs() {
    System.out.println("Прикручиваю хромированные ножки");
  }
}

enum ChairType {
  VICTORIAN ("VictorianChair"),
  MODERN    ("ModernChair");

  private final String description;

  ChairType(String description) {
    this.description = description;
  }
}

enum TableType {
  VICTORIAN ("VictorianTable"),
  MODERN    ("ModernTable");

  private final String description;

  TableType(String description) {
    this.description = description;
  }
}

abstract class FurnitureFactory {
  protected abstract Chair createChair(ChairType type);
  protected abstract Table createTable(TableType type);

  public void produceChair(ChairType type) {
    Chair chair = createChair(type);
    chair.createFrame();
    chair.doUpholstery();
  }

  public void produceTable(TableType type) {
    Table table = createTable(type);
    table.createTop();
    table.attachLegs();
  }
}

class VictorianFurnitureFactory extends FurnitureFactory {
  @Override
  protected Chair createChair(ChairType type) {
    System.out.println("Работаем в викторианской мастерской (стул)");
    if (type == ChairType.VICTORIAN) {
      return new VictorianChair();
    } else {
      System.out.println("Вы серьезно? Делаем викторианский");
      return new VictorianChair();
    }
  }

  @Override
  protected Table createTable(TableType type) {
    System.out.println("Работаем в викторианской мастерской (стол)");
    if (type == TableType.VICTORIAN) {
      return new VictorianTable();
    } else {
      System.out.println("Вы серьезно? Делаем викторианский");
      return new VictorianTable();
    }
  }
}

class ModernFurnitureFactory extends FurnitureFactory {
  @Override
  protected Chair createChair(ChairType type) {
    System.out.println("Работаем в мастерской модерна (стул)");
    if (type == ChairType.MODERN) {
      return new ModernChair();
    } else {
      System.out.println("Вы серьезно? Делаем модерн");
      return new ModernChair();
    }
  }

  @Override
  protected Table createTable(TableType type) {
    System.out.println("Работаем в мастерской модерна (стол)");
    if (type == TableType.MODERN) {
      return new ModernTable();
    } else {
      System.out.println("Вы серьезно? Делаем модерн");
      return new ModernTable();
    }
  }
}

public class Main {
  public static void main(String[] args) {
    FurnitureFactory victorian = new VictorianFurnitureFactory();
    FurnitureFactory modern    = new ModernFurnitureFactory();

    System.out.println("Викторианский гарнитур");
    victorian.produceChair(ChairType.VICTORIAN);
    System.out.println();
    victorian.produceTable(TableType.VICTORIAN);

    System.out.println("\nГарнитур модерн");
    modern.produceChair(ChairType.MODERN);
    System.out.println();
    modern.produceTable(TableType.MODERN);
  }
}