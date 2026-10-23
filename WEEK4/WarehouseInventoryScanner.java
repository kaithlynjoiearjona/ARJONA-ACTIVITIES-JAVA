import java.util.Scanner;

public class WarehouseInventoryScanner {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        // 2D Array: Rows = Ailes, Columns = Shelves (-1 means damaged)
        int[][] warehouse = {
            { 15,  8, -1, 20 },
            {  3, 12, 10, -1 },
            { -1,  4, 25, 18 }
        };

        int choice = 0;

        // do-while menu
        do {
            System.out.println("\n=== WAREHOUSE INVENTORY MENU ===");
            System.out.println("1. Calculate Total Inventory");
            System.out.println("2. Find Critically Low Shelf");
            System.out.println("3. Restock Shelf");
            System.out.println("4. Exit System");
            System.out.print("Enter choice (1-4): ");

            String input = scan.nextLine().trim();
            if (input.isEmpty()) {
                continue;
            }
            choice = Integer.parseInt(input);

            if (choice == 1) {
                int totalItems = 0;
                // for loop with continue skipping damaged shelves (-1)
                for (int aisle = 0; aisle < warehouse.length; aisle++) {
                    for (int shelf = 0; shelf < warehouse[aisle].length; shelf++) {
                        if (warehouse[aisle][shelf] == -1) {
                            continue; // Skip damaged shelf
                        }
                        totalItems += warehouse[aisle][shelf];
                    }
                }
                System.out.println("Total Intact Inventory: " + totalItems + " items");

            } else if (choice == 2) {
                boolean found = false;
                // Nested loops with break to locate first critically low shelf (< 5 items)
                for (int aisle = 0; aisle < warehouse.length; aisle++) {
                    for (int shelf = 0; shelf < warehouse[aisle].length; shelf++) {
                        int count = warehouse[aisle][shelf];
                        if (count != -1 && count < 5) {
                            System.out.println("Critically low shelf found at Aisle " + aisle + ", Shelf " + shelf + " (Items: " + count + ")");
                            found = true;
                            break; // Stop checking current aisle
                        }
                    }
                    if (found) {
                        break; // Stop searching remaining aisles
                    }
                }
                if (!found) {
                    System.out.println("No critically low shelves detected.");
                }

            } else if (choice == 3) {
                // Calls restocking method with return for input validation
                restockSystem(scan, warehouse);

            } else if (choice == 4) {
                System.out.println("Exiting Warehouse System. Goodbye!");
            } else {
                System.out.println("Invalid choice. Try again.");
            }

        } while (choice != 4);

        scan.close();
    }

    public static void restockSystem(Scanner scan, int[][] warehouse) {
        System.out.print("Enter Aisle index (0-" + (warehouse.length - 1) + "): ");
        int aisle = Integer.parseInt(scan.nextLine().trim());

        System.out.print("Enter Shelf index (0-" + (warehouse[0].length - 1) + "): ");
        int shelf = Integer.parseInt(scan.nextLine().trim());

        // Return early if location is invalid or damaged
        if (aisle < 0 || aisle >= warehouse.length || shelf < 0 || shelf >= warehouse[0].length) {
            System.out.println("Error: Invalid aisle or shelf location.");
            return; 
        }

        if (warehouse[aisle][shelf] == -1) {
            System.out.println("Error: Cannot restock a damaged shelf (-1).");
            return; 
        }

        int addedStock = 0;
        while (true) {
            System.out.print("Enter items to add (must be positive): ");
            addedStock = Integer.parseInt(scan.nextLine().trim());

            if (addedStock > 0) {
                break; 
            }
            System.out.println("Invalid count. Amount must be greater than 0.");
        }

        warehouse[aisle][shelf] += addedStock;
        System.out.println("Successfully updated Aisle " + aisle + ", Shelf " + shelf + ". New Count: " + warehouse[aisle][shelf]);
    }
}
