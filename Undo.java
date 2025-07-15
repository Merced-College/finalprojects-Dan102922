import java.util.Stack;

// This keeps tracks of orders made in order to support undo functionality

public class undo {
  private Stack<MenuItem> undoItems {
    undoItems = new Stack<>();
  }

  // Pushes an item when it was added to the order
  public void push(MenuItem item) {
    undoStack.push(item)
  }

// This undos the last item that was added
// (need to implement in main later)
  public MenuItem undoLastItem() {
    if (!undoItems.isEmpty()) {
      return undoItems.pop();
    }
    return null;
  }
}
