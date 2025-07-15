//This is the class for the menu items, with the name of the item, the price, and whether or not it's a combo
public class MenuItem {
  private String name;
  private double price;
  private boolean isCombo;
  private List<MenuItem> components; // Used for the combo meals
  
  public MenuItem(String name, double price, boolean isCombo) { 
    this.name = name;
    this.price = price;
    this.isCombo = isCombo;
    this.components = new ArrayList<>();
  }
  public void addComponent(MenuItem item) {
    if (isCombo) {
      components.add(item);
    }
  }

  public List<MenuItem> getComponents() {
    return components
  }
  public boolean isCombo() {
    return isCombo;
  }
}
