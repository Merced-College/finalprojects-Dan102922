import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        MenuItem[] menu = { // Array of menu items, complete with names, prices, and whether or not they are a combo
            new MenuItem("Soda", 1.29, false)
        };
        // Create a HashMap to store menu items with their names as keys
        HashMap<String, MenuItem> menuMap = new HashMap<>();
        // Populate the HashMap with menu items
        for (MenuItem item : menu) {
            menuMap.put(item.getName(), item);
        }
    }
}