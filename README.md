# Final Project: McDonald's Restaurant Ordering System
## Daniel Mota
### 7/18/25
### Description:

This program is a terminal-based ordering system that allows the user to create orders, add items to them, and calculate the total cost.
(Note: the prices are not entirely accurate to how much real-world McDonald's items cost, plus they can vary depending on location)

### User Interface
The user interface sorts the options by case, and when the user submits a number corresponding to that case, it performs the corresponding action.

### 1. View our menu
Displays the menu with the names of the items and prices
### 2. Create order
Prompts the user to pick a table number, and creates that table number to add items to
### 3. Add item to order
Asks for a valid table number and prompts the user to add an item to the order. Though it is case-sensitive, it's most ideal to copy-paste an item from the menu
### 4. Undo last item
Asks for a valid table number, and removes the last item that was added, does nothing if there is no item to remove
### 5. Wait time estimate
Asks for a valid table number, and estimates how long it will take based on the order they were created, as shown below
- #1 -> 5 minutes
- #2 -> 10 minutes
- #3 -> 15 minutes
### 6. Checkout
Asks for a valid table number, then prompts the user to enter a percentage-based tip, and calculates the total cost of the order with and without it
### 7. Exit
Self-explanatory
