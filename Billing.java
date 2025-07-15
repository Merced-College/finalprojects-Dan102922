// The billing class, with both the total price of food and tip (connect to main later)
public class Billing {
  // Calculate the final bill, including the tip
  public double totalCost(double baseTotal) {
    // implement proper algorithm later
  }
}

public double getBaseTotal() {
  double total = 0.0;
  for (MenuItem item : items) {
    total += item.getPrice();
  }
  return total;
}