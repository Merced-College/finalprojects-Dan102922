import java.util.List;

public class Order {
  private int tableNumber;
  private List<MenuItem> items;
  private Undo undo; // Undo stack for this order

  public Order(int tableNumber, List<MenuItem> items) {
    this.tableNumber = tableNumber;
    this.items = items;
    undo = new Undo(); // Initialize undo stack
  }

  public int getTableNumber() {
    return tableNumber;
  }

  public void setTableNumber(int tableNumber) {
    this.tableNumber = tableNumber;
  }

  // Adds an item to the order
  public void addItem(MenuItem item) {
    items.add(item);
    pushUndo(item);
  }

  // Removes an item from the order
  public boolean removeItem(MenuItem item) {
    boolean removed = items.remove(item);
    if (removed) {
      pushUndo(item);
    }
    return removed;
  }

  // Pushes an item to the undo stack
  public void pushUndo(MenuItem item) {
    undo.push(item);
  }

  // Undoes the last item added and returns it
  public MenuItem undoLastItem() {
    return undo.undoLastItem();
  }
}
