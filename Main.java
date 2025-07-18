import java.util.HashMap;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    // Helper to prompt for table number
    public static int promptForTableNumber(Scanner scanner) {
        System.out.print("Enter table number: ");
        return getIntInput(scanner);
    }

    // Helper to safely get integer input with validation
    // input validation implemented by copilot to prevent the program from exiting on invalid input
    public static int getIntInput(Scanner scanner) {
        while (true) {
            String input = scanner.nextLine();
            try {
                return Integer.parseInt(input.trim());
            } catch (NumberFormatException e) {
                System.out.print("Invalid input. Please enter a valid number: ");
            }
        }
    }

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
        // Populate combo items with their components
        // Big mac combo
        menu[0].addComponent(menu[4]);
        menu[0].addComponent(menu[5]);
        menu[0].addComponent(menu[8]);
        // Hamburger combo
        menu[1].addComponent(menu[3]);
        menu[1].addComponent(menu[5]);
        menu[1].addComponent(menu[8]); 
        // Chicken nugget combo
        menu[2].addComponent(menu[6]);
        menu[2].addComponent(menu[5]);
        menu[2].addComponent(menu[8]);

        // Create a HashMap to store menu items with their names as keys
        HashMap<String, MenuItem> menuMap = new HashMap<>();
        // Populate the HashMap with menu items
        for (MenuItem item : menu) {
            menuMap.put(item.getName(), item);
        }
        // Initializes these for uses in later cases
        OrderManager orderManager = new OrderManager();
        WaitQueue waitQueue = new WaitQueue();
        // Initiates scanner for user input
        Scanner scanner = new Scanner(System.in);
        Billing billing = new Billing(); // Essential: instantiate Billing
        System.out.println("Welcome to the McDonalds Ordering System!");

        // Display UI options, the user picks one by number
        boolean running = true;
        while (running) {
            System.out.println("------------------------");
            System.out.println("1. View our menu");
            System.out.println("2. Create order"); // This is meant to be done first
            System.out.println("3. Add item to order");
            System.out.println("4. Undo last item");
            System.out.println("5. Wait time estimate");
            System.out.println("6. Checkout");
            System.out.println("7. Exit");
            System.out.println("------------------------");

            System.out.println("Choose an option by number: ");
            int choice = getIntInput(scanner);

            switch (choice) {
            case 1: // Display the menu
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
                System.out.print("Pick a table number: ");
                int tableNumber2 = getIntInput(scanner);

                // Check if order already exists
                if (orderManager.getOrder(tableNumber2) != null) {
                    System.out.println("An order for this table already exists.");
                } else {
                    // Creates the order and adds it to manager
                    Orders newOrder = new Orders(tableNumber2, new ArrayList<MenuItem>()); // Essential: pass items list
                    orderManager.addOrder(tableNumber2, newOrder);

                    waitQueue.addTable(tableNumber2);
                    System.out.println("Order created for table #" + tableNumber2);
                }
                break;
            case 3: // Add an item to the order
                System.out.print("Add item to which order #? ");
                int tableNumber3 = getIntInput(scanner);
                // copilot assisted below
                Orders order3 = orderManager.getOrder(tableNumber3);
                // If the user enters a table number that isn't in the queue
                if (order3 == null) {
                    System.out.println("No order found for table #" + tableNumber3);
                } else {
                    System.out.print("Enter item name to add: ");
                    String itemName = scanner.nextLine();
                    MenuItem item = menuMap.get(itemName);
                    if (item == null) {
                        System.out.println("Item not found in menu, maybe you mispelled it?");
                    } else {
                        order3.addItem(item); // Adds item
                        System.out.println(itemName + " added to order for table #" + tableNumber3);
                    }
                }
                break;
            case 4: // Undo last item
                System.out.print("Undo last item for which order #? ");
                int tableNumber4 = getIntInput(scanner);
                Orders order4 = orderManager.getOrder(tableNumber4);

                if (order4 == null) {
                    System.out.println("No order found for this table number");
                    break;
                }

                // Undos the last item
                MenuItem lastItem = order4.undoLastItem();

                if (lastItem == null) {
                    System.out.println("There is nothing to undo");
                } else {
                    // Remove the last item from the order
                    order4.removeItem(lastItem);
                    System.out.println("Removed " + lastItem.getName() + " from table #" + tableNumber4 + "'s order");
                }
                break;
            case 5: // Wait time estiamte
                int tableNumber5 = promptForTableNumber(scanner);

                if (!waitQueue.hasTable(tableNumber5)) {
                    System.out.println("Table " + tableNumber5 + " isn't in the wait queue");
                    break;
                }

                int position = waitQueue.getPosition(tableNumber5);
                // Uses position from waitQueue, and adds a set prep time
                final int prepTime = 5;
                int estimatedWait = (position * prepTime) + 5;
                System.out.println("Estimated wait time for table #" + tableNumber5 + " is " + estimatedWait + " minutes.");
                break;
            case 6: // Checkout
                int tableNumber6 = promptForTableNumber(scanner);
                Orders currentOrder = orderManager.getOrder(tableNumber6);

                if (currentOrder == null) {
                    System.out.println("No order found for this table number");
                    break;
                }
                // Prompts user to enter a tip percentage
                System.out.print("Would you like to leave a tip? (enter in percentage) ");
                double tipPercent = 0;
                try {
                    tipPercent = Double.parseDouble(scanner.nextLine());
                } catch (Exception e) {
                    tipPercent = 0;
                }
                // Displays the full receipt from the Billing class
                billing.displayReceipt(currentOrder, tipPercent);

                // copilot assisted below
                System.out.println("Order summary for table #" + tableNumber6 + ":");
                currentOrder.printOrderSummary();
                double total = currentOrder.calculateTotal();
                System.out.printf("Total: $%.2f%n", total);

                // Remove from wait queue after checkout
                waitQueue.removeTable(tableNumber6);

                break;
            case 7: // Exit
                running = false;
                System.out.println("Goodbye");
                break;
            default:
                System.out.println("Invalid option. Please try again.");
                break;
            }
        }
        scanner.close(); // Close the scanner to avoid resource leak
    }
}