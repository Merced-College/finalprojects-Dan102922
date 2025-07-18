import java.util.LinkedList;
import java.util.Queue;
import java.util.ArrayList;
import java.util.Collections;

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
        // Convert the queue to a list to access elements by index
        ArrayList<Integer> list = new ArrayList<>(tableQueue);
        // Find the index of the given table number
        int position = list.indexOf(tableNumber);
        // Return the position (or -1 if not found)
        return position;
    }

    // Returns the total number of tables currently in the queue
    public int size() {
        return tableQueue.size();
    }

    public Queue<Integer> getQueue() {
        return new LinkedList<>(tableQueue);
    }

    // Returns true if the table is in the queue
    public boolean hasTable(int tableNumber) {
        return tableQueue.contains(tableNumber);
    }

    // Removes a table from the queue
    public boolean removeTable(int tableNumber) {
        return tableQueue.remove(tableNumber);
    }

    /***************************************************************************************
*    Title: Sorting using sort()
*    Author: Programiz
*    Code version: Java
*    Availability: https://www.programiz.com/java-programming/algorithms
*
***************************************************************************************/
    public void displaySortedQueue() {
        ArrayList<Integer> sortedList = new ArrayList<>(tableQueue);
        Collections.sort(sortedList);
        System.out.println("Sorted Wait Queue: " + sortedList);
    }
}