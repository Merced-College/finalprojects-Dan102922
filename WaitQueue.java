import java.util.LinkedList;
import java.util.Queue;

// This class represents a wait queue for customers, sorting by table numbers

public class WaitQueue {
    // Queue to hold table numbers in the order they are added
    private Queue<Integer> tableQueue;

    public WaitQueue() {
        // Constructor that initializes an empty queue using linkedlist
        tableQueue = new LinkedList<>();
    }

    // Adds a table to the end of the table queue
    public void addTable(int tableNumber) {
        tableQueue.offer(tableNumber);
    }
    
    // Returns the 0-based position of a table in the queue
    public int getPosition(int tableNumber) {
        // add proper algorithm later
        return 0;
    }

    // Returns the total number of tables currently in the queue
    public int size() {
        return tableQueue.size();
    }
}