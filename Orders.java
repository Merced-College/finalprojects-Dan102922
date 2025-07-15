import java.util.List;

public class Order {
  private int tableNumber;
  private List<MenuItem> items;

  public Order(int tableNumber, List<MenuItem> items) {
    this.tableNumber = tableNumber;
    this.items = items;
  }

  public int getTableNumber() {
    return tableNumber;
  }

  public void setTableNumber(int tableNumber) {
    this.tableNumber = tableNumber;
  }
}
