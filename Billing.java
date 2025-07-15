// The billing class, with both the total price of food and tip (connect to main later)
public class Billing {
  // Calculate the final bill, including the tip
  private double totalCost(double baseTotal) {
    double tipAmount = baseTotal * (tipPercent / 100);
    return baseTotal + tipAmount;
  }
}

public double getBaseTotal() {
  double total = 0.0;
  for (MenuItem item : items) {
    total += item.getPrice();
  }
  return total;
}