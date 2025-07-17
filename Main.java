import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        MenuItem[] menu = { // Array of menu items, complete with names, prices, and whether or not they are a combo
        // This menu is more simplified than a regular mcdonald's menu, its prices won't be entirely accurate
            new MenuItem("#1 Big Mac combo", 10.99, true),
            new MenuItem("#2 Hamburger combo", 11.99, true),
            new MenuItem("#3 Chicken Nugget Combo", 10.59, true),
            new MenuItem("Hamburger", 2.59, false),
            new MenuItem("Big Mac", 3.59, false),
            new MenuItem("French Fries", 4.59, false),
            new MenuItem("Chicken Nuggets", 6.99, false),
            new MenuItem("Mcflurry", 3.99, false),
            new MenuItem("Soda", 1.29, false),
            new MenuItem("Barbecue sauce", 0.25, false)
        };
        // Create a HashMap to store menu items with their names as keys
        HashMap<String, MenuItem> menuMap = new HashMap<>();
        // Populate the HashMap with menu items
        for (MenuItem item : menu) {
            menuMap.put(item.getName(), item);
        }
        // Initiates scanner for user input
        Scanner scanner = new Scanner(System.in);

        // Display UI options:
        boolean running = true;
        while (running) {
            System.out.println("Welcome to the McDonalds Ordering System!");
            System.out.println("1. View our menu");
            System.out.println("2. Create order"); // This is meant to be done first
            System.out.println("3. Add item to order");
            System.out.println("4. Undo last item");
            System.out.println("5. Wait time estimate");
            System.out.println("6. Checkout");
            System.out.println("7. Exit");

            System.out.println("Choose an option by number: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
            case 1: // View the menu
                System.out.println("Menu:");
                System.out.println("#1 Big Mac combo: 10.99");
                System.out.println("#2 Hamburger combo: 11.99");
                System.out.println("#3 Chicken Nugget Combo: 10.59");
                System.out.println("Hamburger: 2.59");
                System.out.println("Big Mac: 3.59");
                System.out.println("French Fries: 4.59");
                System.out.println("Chicken Nuggets: 6.99");
                System.out.println("Mcflurry: 3.99");
                System.out.println("Soda: 1.29");
                System.out.println("Barbecue sauce: 0.25");
                break;
            case 2: // Create an order
                static OrderManager orderManager = new OrderManager();
                static WaitQueue waitQueue = new WaitQueue();
                System.out.print("Pick a table number: ");
                int tableNumber = scanner.nextInt();
                scanner.nextLine();

                // Check if order already exists
                if (orderManager.getOrder(tableNumber) != null) {
                    System.out.println("An order for this table already exists.");
                } else {
                    // Creates the order and adds it to manager
                    Orders newOrder = new Orders(tableNumber);
                    orderManager.addOrder(tableNumber, newOrder);

                    waitQueue.addTable(tableNumber);
                    System.out.println("Order created for table #" + tableNumber);
                }
                break;
            case 3: // Add an item to the order
                System.out.print("Add item to which order #?")
                int tableNumber = scanner.nextInt();
                scanner.nextLine();
                // copilot assisted below
                Orders order = orderManager.getOrder(tableNumber);
                if (order == null) {
                    System.out.println("No order found for table #" + tableNumber + ". Please create an order first.");
                } else {
                    System.out.print("Enter item name to add: ");
                    String itemName = scanner.nextLine();
                    MenuItem item = menuMap.get(itemName);
                    if (item == null) {
                        System.out.println("Item not found in menu.");
                    } else {
                        order.addItem(item);
                        System.out.println(itemName + " added to order for table #" + tableNumber);
                    }
                }
                break;
            case 4: // Undo last item
                System.out.print("Add item to which order #?");
                int tableNumber = scanner.nextInt();
                scanner.nextLine();
                Orders order = orderManager.getOrder(tableNumber);

                if (order == null) {
                    System.out.println("No order found for this table number");
                    break;
                }

                // Undos the last item
                MenuItem lastItem = order.undoLastItem();

                if (lastItem == null) {
                    System.out.println("There is nothing to undo");
                } else {
                    boolean removed = order.removeItem(lastItem);
                    System.out.println("Removed " + lastItem.getName() + " from table #" + tableNumber + "'s order");
                }
                break;

                break;
            case 5: // Wait time estiamte
                // TODO: Wait time estimate
                break;
            case 6: // Checkout
                // TODO: Checkout
                break;
            case 7: // Exit
                // TODO: Exit
                running = false;
                System.out.println("Goodbye");
                break;
            default:
                System.out.println("Invalid option. Please try again.");
                break;
            }
        }
    }
}