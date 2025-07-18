import java.util.Collections;
import java.util.ArrayList;
import java.util.List;

// The billing class, with both the total price of food and tip (connect to main later)
public class Billing {
  // Calculate the base total, no tip yet
  public double totalCost(double baseTotal) {
    double total = 0;
    for (MenuItem item : items) {
      total = item.getPrice();
    }
    return 0.0;
  }

  // Calculates total WITH tip
  public double totalCost(double baseTotal, double tipPercent) {
    double tipAmount = baseTotal * (tipPercent / 100);
    return baseTotal + tipAmount;
  }

   // Displays a receipt for the given order, and sorts item by price, and displays base total with and without tip
   // Copilot assisted below
  public void displayReceipt(Order order, double tipPercent) {
    // Get a copy of the items and sort by price
    List<MenuItem> sortedItems = new ArrayList<>(order.getItems());
    Collections.sort(sortedItems, (a, b) -> Double.compare(a.getPrice(), b.getPrice()));

    System.out.println("----- Receipt for Table #" + order.getTableNumber() + " -----");
    for (MenuItem item : sortedItems) {
      System.out.printf("%-25s $%.2f\n", item.getName(), item.getPrice());
    }

    // Calculate base total
    double baseTotal = 0.0;
    for (MenuItem item : sortedItems) {
      baseTotal += item.getPrice();
    }
    System.out.printf("Base Total: $%.2f\n", baseTotal);

    // Show total with no tip
    System.out.printf("Total (no tip): $%.2f\n", baseTotal);

    // Show total with tip if tipPercent > 0
    if (tipPercent > 0) {
      double tipAmount = baseTotal * (tipPercent / 100.0);
      double totalWithTip = baseTotal + tipAmount;
      System.out.printf("Tip (%.1f%%): $%.2f\n", tipPercent, tipAmount);
      System.out.printf("Total (with tip): $%.2f\n", totalWithTip);
    }
    System.out.println("-------------------------------");
  }
}