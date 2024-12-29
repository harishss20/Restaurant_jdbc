package Restaurant;

import java.sql.*;
import java.util.*;

public class FoodOrder {

    DatabaseCon dbCon = new DatabaseCon();
    TableReg tb = new TableReg();
    Scanner sc = new Scanner(System.in);

    public void orderFood() throws SQLException {
        String fetchQuery = "SELECT price FROM menu WHERE item_id = ?";
        String insertOrderQuery = "INSERT INTO order_items (table_id, item_id, quantity, price) VALUES (?, ?, ?, ?)";

        try (Connection con = dbCon.getConnection();
             PreparedStatement fetchStmt = con.prepareStatement(fetchQuery);
             PreparedStatement insertStmt = con.prepareStatement(insertOrderQuery)) {

            System.out.print("Enter the Table Number: ");
            int tableNumber = sc.nextInt();

            boolean tb_status = tb.selectTable(tableNumber);
            if (!tb_status) {
                System.out.println("Table is not available or already selected.");
                return;
            }

            System.out.print("How many items do you want to order: ");
            int itemCount = sc.nextInt();

            for (int i = 0; i < itemCount; i++) {
                System.out.print("Enter item ID from menu: ");
                int itemId = sc.nextInt();

                System.out.print("Enter the quantity: ");
                int quantity = sc.nextInt();

                if (quantity <= 0) {
                    System.out.println("Invalid quantity. Please try again.");
                    continue;
                }

                fetchStmt.setInt(1, itemId);
                try (ResultSet rs = fetchStmt.executeQuery()) {
                    if (rs.next()) {
                        double pricePerUnit = rs.getDouble("price");
                        double totalPrice = pricePerUnit * quantity;

                        insertStmt.setInt(1, tableNumber);
                        insertStmt.setInt(2, itemId);
                        insertStmt.setInt(3, quantity);
                        insertStmt.setDouble(4, totalPrice);
                        insertStmt.addBatch();
                    } else {
                        System.out.println("Item ID " + itemId + " not found in the menu.");
                    }
                }
            }

            int[] results = insertStmt.executeBatch();
            System.out.println(results.length + " items successfully added to the order.");
        } catch (SQLException e) {
            System.out.println("Error during order placement: " + e.getMessage());
            throw e;
        }
    }

    public void showAllTables() throws SQLException{
        String query = "SELECT * FROM order_items";
        Connection con = dbCon.getConnection();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(query);

        System.out.printf("%-15s | %-15s | %-15s | %-15s%n", "Table Number", "Item_id", "Quantity", "price");
        System.out.println("-----------------------------------------------------------------");


        while (rs.next()) {
            int tb_number = rs.getInt("table_id");
            int itemId = rs.getInt("item_id");
            int quantity = rs.getInt("quantity");
            double price = rs.getDouble("price");


            System.out.printf("%-15d | %-15d | %-15d| %-152f%n", tb_number, itemId, quantity,price);
        }

        System.out.println("-----------------------------------------------------------------");
    }

    public void showTableOrders() throws SQLException {
        System.out.println("Enter your table Number:");
        int tb = sc.nextInt();

        String query = "SELECT * FROM order_items WHERE table_id = ?";

        Connection con = dbCon.getConnection();
        PreparedStatement st = con.prepareStatement(query);
        st.setInt(1, tb);

        ResultSet rs = st.executeQuery();


        if (!rs.next()) {
            System.out.println("The table number is wrong. Please, try again!");
            return;
        }

        System.out.printf("%-15s | %-15s | %-15s | %-15s%n", "Table Number", "Item_id", "Quantity", "price");
        System.out.println("------------------------------------------------------------------");


        do {
            int tb_number = rs.getInt("table_id");
            int itemId = rs.getInt("item_id");
            int quantity = rs.getInt("quantity");
            double price = rs.getDouble("price");


            System.out.printf("%-15d | %-15d | %-15d| %-15f%n", tb_number, itemId, quantity,price);
        } while (rs.next());

        System.out.println("------------------------------------------------------------------");
    }


}
