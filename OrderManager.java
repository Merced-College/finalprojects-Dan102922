// Was assisted with by copilot
import java.util.HashMap;

// This class manages all orders in the system
public class OrderManager {
  // HashMap to store orders, with table number as the key
  private HashMap<Integer, Orders> orders = new HashMap<>();

  // Adds a new order for a given table number
  public void addOrder(int tableNum, Orders order) {
    orders.put(tableNum, order);
  }

  // Retrieves the order for a given table number, or null if not found
  public Orders getOrder(int tablenum) {
    return orders.get(tablenum);
  }
}
