import java.util.ArrayList;
import java.util.List;

// Unpacks combo meals recursively
public class ComboHelper {
  public static List<MenuItem> unpackCombo(MenuItem item) {
    List<MenuItem> unpacked = new ArrayList<>();
    // If it is a combo, recursively unpack its items
    // copilot assisted below
    if (item.isCombo()) {
      for (MenuItem subItem : item.getComponents()) {
        unpacked.addAll(unpackCombo(subItem));
      }
    } else {
      // If it is not a combo, just add the item itself
      unpacked.add(item);
    }
    return unpacked;
  }
}
