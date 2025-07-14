// Was assisted with by copilot
import java.util.HashMap;
import java.util.List;

public class OrderManager {
  private HashMap<Integer, Order> orders = new HashMap<>();

  public void addOrder(int tableNum, Order order) {
    orders.put(tableNum, order);
  }

  public Order getOrder(int tablenum) {
    return orders.get(tablenum);
  }
}
