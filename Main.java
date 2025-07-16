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
        // Initiates scanner for user input
        Scanner scanner = new Scanner(System.in)

        // Display UI options:
        boolean running = true;
        while (running) {
            System.out.println("Welcome to the McDonalds Ordering System!");
            System.out.println("1. View our menu");
            System.out.println("2. Create order");
            System.out.println("3. Add item to order");
            System.out.println("4. Undo last item");
            System.out.println("5. Wait time estimate");
            System.out.println("6. Checkout");
            System.out.println("7. Exit");

            System.out.println("Choose an option by number: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
            case 1:
                // TODO: View menu
                break;
            case 2:
                // TODO: Create order
                break;
            case 3:
                // TODO: Add item to order
                break;
            case 4:
                // TODO: Undo last item
                break;
            case 5:
                // TODO: Wait time estimate
                break;
            case 6:
                // TODO: Checkout
                break;
            case 7:
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