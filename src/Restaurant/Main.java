package Restaurant;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TableReg table = new TableReg();
        Menu menu = new Menu();
        FoodOrder FO= new FoodOrder();

        try {
            int choice;
            do {
                System.out.println("\nMenu:");
                System.out.println("1. Show Tables");
                System.out.println("2. Select Table");
                System.out.println("3. Show Menu and order Food");
                System.out.println("4. Show orders Table wise");
                System.out.println("5. Show All Table orders");
                System.out.println("8. Exit");
                System.out.println();

                System.out.print("Enter your choice: ");

                choice = sc.nextInt();

                switch (choice) {
                    case 1:
                        table.showTable();
                        break;
                    case 2:
                        table.selectTable();
                        break;

                    case 3:
                        menu.showMenu();
                        FO.orderFood();
                        break;

                    case 4:
                        FO.showTableOrders();
                        break;
                    case 5:
                        FO.showAllTables();
                        break;
                    case 8:
                        System.out.println("Thankyou. visit again!");
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                        break;
                }
            } while (choice != 8);
        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        } finally {
            sc.close();
        }
    }
}
