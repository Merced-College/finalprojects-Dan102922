import java.util.List;

Public class order {
  private int tableNumber;
  private List<MenuItem> items;

  public Order(int tableNumber, List<MenuItem> items) {
    this.tableNumber = tableNumber;
    this.items = items;
  }

  getTableNumber() {
    return tableNumber;
  }

  settablenumber(int tableNumber) {
    this.tableNumber = tableNumber;
  }
}
