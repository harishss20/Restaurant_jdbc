package Restaurant;

import java.sql.*;
import java.util.*;

public class FoodOrder {

    DatabaseCon dbCon = new DatabaseCon();
    Scanner sc = new Scanner(System.in);

    public void orderFood() throws SQLException {
        String fetchQuery= "SELECT  price FROM menu WHERE item_id =?";
        String insertOrderQuery ="INSERT INTO order_items (table_id, item_id, quantity,price ) values (?,?,?,?)";

        Connection con = dbCon.getConnection();
        PreparedStatement fst = con.prepareStatement(fetchQuery);
        PreparedStatement  st= con.prepareStatement(insertOrderQuery);

        System.out.print("Enter the Table Number: ");
        int tableNumber= sc.nextInt();

        System.out.print("How many items do you want to order ?");
        int itemCount = sc.nextInt();

        for(int i=0; i<itemCount; i++){
            System.out.println("Enter item Id from menu: ");
            int itemId = sc.nextInt();
            System.out.println("Enter the Number of Quantity:");
            int quantity = sc.nextInt();

            fst.setInt(1,itemId);
            ResultSet frs = fst.executeQuery();

            if (frs.next()) {
                double pricePerUnit = frs.getDouble("price");
                double totalPrice = pricePerUnit * quantity;


                st.setInt(1, tableNumber);
                st.setInt(2, itemId);
                st.setInt(3, quantity);
                st.setDouble(4, totalPrice);
                st.addBatch();
            } else {
                System.out.println("Item ID " + itemId + " not found in the menu.");
            }
        }
        int[] result = st.executeBatch();
        System.out.println(result.length + " items successfully added to the order.");
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
