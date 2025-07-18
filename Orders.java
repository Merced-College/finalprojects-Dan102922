import java.util.List;

public class Orders {
  private int tableNumber;
  private List<MenuItem> items;
  private Undo undo; // Undo stack for this order

  public Orders(int tableNumber, List<MenuItem> items) {
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
    return items.remove(item);
  }

  // Pushes an item to the undo stack
  public void pushUndo(MenuItem item) {
    undo.push(item);
  }

  // Undoes the last item added and returns it
  public MenuItem undoLastItem() {
    return undo.undoLastItem();
  }

  // copilot assisted fixes for the program to function
  // Essential: getter for items for Billing
  public List<MenuItem> getItems() {
    return items;
  }

  // Essential: stub for printOrderSummary and calculateTotal to avoid errors in Main
  public void printOrderSummary() {
    for (MenuItem item : items) {
      System.out.printf("%-25s $%.2f\n", item.getName(), item.getPrice());
    }
  }

  public double calculateTotal() {
    double total = 0.0;
    for (MenuItem item : items) {
      total += item.getPrice();
    }
    return total;
  }
}
