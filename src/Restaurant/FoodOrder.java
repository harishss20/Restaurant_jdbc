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

}
