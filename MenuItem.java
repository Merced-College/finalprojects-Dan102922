import java.util.List;
import java.util.ArrayList;

// This is the class for the menu items, with the name of the item, the price, and whether or not it's a combo
public class MenuItem {
  private String name;
  private double price;
  private boolean isCombo;
  private List<MenuItem> components; // Used for the combo meals (list of items in the combo)
  
  // Constructor to initialize a menu item
  public MenuItem(String name, double price, boolean isCombo) { 
    this.name = name;
    this.price = price;
    this.isCombo = isCombo;
    this.components = new ArrayList<>();
  }

  // Adds a component item to this combo (only if isCombo is true)
  public void addComponent(MenuItem item) {
    if (isCombo) {
      components.add(item);
    }
  }

  // Returns the list of component items (for combos)
  public List<MenuItem> getComponents() {
    return components;
  }

  // Returns true if this item is a combo
  public boolean isCombo() {
    return isCombo;
  }

  // Returns the name of the menu item
  public String getName() {
    return name;
  }

  // Returns the price of the menu item
  public double getPrice() {
    return price;
  }
}
