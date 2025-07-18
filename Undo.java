import java.util.Stack;

// This keeps track of orders made in order to support undo functionality

public class Undo {
  // Stack to keep track of added menu items for undo
  private Stack<MenuItem> undoStack;

  public Undo() {
    undoStack = new Stack<>();
  }

  // Pushes an item when it was added to the order
  public void push(MenuItem item) {
    undoStack.push(item);
  }

  // Undoes the last item that was added
  public MenuItem undoLastItem() {
    if (!undoStack.isEmpty()) {
      return undoStack.pop();
    }
    return null;
  }
}
