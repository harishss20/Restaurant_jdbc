package Restaurant;

import java.sql.*;
import java.util.*;

public class FoodOrder {

    DatabaseCon dbCon = new DatabaseCon();
    Scanner sc = new Scanner(System.in);

    public void orderFood() throws SQLException {
        String fetchQuery= "SELECT name, category, price FROM menu WHERE item_id =?";
        String insertOrderQuery ="INSERT INTO order_items (table_id, item_id, quantity) values (?,?,?)";

        Connection con = dbCon.getConnection();
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

            st.setInt(1,tableNumber);
            st.setInt(2,itemId);
            st.setInt(3,quantity);
            st.addBatch();
            st.executeBatch();
        }
    }

    public void showAllTables() throws SQLException{
        String query = "SELECT * FROM order_items";
        Connection con = dbCon.getConnection();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(query);

        System.out.printf("%-15s | %-15s | %-15s%n", "Table Number", "Item_id", "Quantity");
        System.out.println("------------------------------------");


        while (rs.next()) {
            int tb_number = rs.getInt("table_id");
            int itemId = rs.getInt("item_id");
            int quantity = rs.getInt("quantity");

            // Print row data
            System.out.printf("%-15d | %-15d | %-15d%n", tb_number, itemId, quantity);
        }

        System.out.println("------------------------------------");
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

        System.out.printf("%-15s | %-15s | %-15s%n", "Table Number", "Item_id", "Quantity");
        System.out.println("------------------------------------");


        do {
            int tb_number = rs.getInt("table_id");
            int itemId = rs.getInt("item_id");
            int quantity = rs.getInt("quantity");


            System.out.printf("%-15d | %-15d | %-15d%n", tb_number, itemId, quantity);
        } while (rs.next());

        System.out.println("------------------------------------");
    }


}
